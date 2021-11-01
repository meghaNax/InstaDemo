package com.app.instaclonedemo.data.mapper

import android.util.Log
import com.app.feeds.data.domain.entity.Action
import com.app.feeds.data.domain.entity.FeedDetails
import com.app.feeds.data.domain.entity.FeedItem
import com.app.feeds.data.domain.entity.From
import com.app.instaclonedemo.data.remote.entity.ApiFeedItem
import com.app.instaclonedemo.exception.InvalidResponseBodyException

class FeedItemMapper() : Mapper<ApiFeedItem, FeedItem> {

    override fun toDomain(model: ApiFeedItem): FeedItem {
        return FeedItem(
            id = model.id ?: throw InvalidResponseBodyException("id is unknown"),
            message = model.message ?: "",
            type = model.type ?: "",
            createdTime = model.createdTime ?: "",
            updatedTime = model.updatedTime ?: "",
            from = model.from?.run {
                From(
                    id = this.id ?: throw InvalidResponseBodyException("id is unknown"),
                    name = this.name ?: throw InvalidResponseBodyException("name is unknown")
                )
            } ?: throw InvalidResponseBodyException("id is unknown"),
            actions = model.actions?.map {
                Action(
                    it.name ?: throw InvalidResponseBodyException("action name unknown"),
                    it.link ?: throw InvalidResponseBodyException("action link unknown")
                )
            } ?: throw InvalidResponseBodyException("actions are unknown"),
            feedItems = model.feedItems?.map {
                Log.d("TEST_URL",it.url)
                FeedDetails(
                    it.type ?: throw InvalidResponseBodyException(" type unknown"),
                    it.url ?: throw InvalidResponseBodyException(" url unknown")
                )
            } ?: throw InvalidResponseBodyException("feedItems are unknown"),
        )
    }
}