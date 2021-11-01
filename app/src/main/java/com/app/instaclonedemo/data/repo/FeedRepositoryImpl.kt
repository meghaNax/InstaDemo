package com.app.instaclonedemo.data.repo

import android.content.Context
import com.app.feeds.data.domain.entity.FeedItem
import com.app.feeds.di.data.FeedRepository
import com.app.instaclonedemo.data.mapper.FeedItemMapper
import com.app.instaclonedemo.data.remote.entity.ApiFeedItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.InputStream
import java.lang.reflect.Type
import java.nio.charset.Charset

class FeedRepositoryImpl(
    private val context: Context,
    private val gson: Gson,
    private val feedItemMapper: FeedItemMapper
) : FeedRepository {

    override suspend fun loadFeed(): Result<List<FeedItem>> {
        return kotlin.runCatching {
            val feedType: Type = object : TypeToken<List<ApiFeedItem?>?>() {}.type
            gson.fromJson<List<ApiFeedItem>>(getJsonFromAssets(context, "insta.json"), feedType)
                .map { feedItemMapper.toDomain(it) }
        }
    }

    private suspend fun getJsonFromAssets(
        context: Context,
        fileName: String
    ): String? = withContext(Dispatchers.IO) {
        val jsonString: String = try {
            val `is`: InputStream = context.assets.open(fileName)
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
            return@withContext null
        }
        return@withContext jsonString
    }

}