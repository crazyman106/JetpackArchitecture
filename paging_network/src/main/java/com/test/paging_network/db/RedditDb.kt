package com.test.paging_network.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.test.paging_network_lib.reddit.vo.RedditPost

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/19 0019
 *  @pkn    : com.test.paging_network.db
 *  @desc   :
 */
@Database(entities = arrayOf(RedditPost::class), version = 1, exportSchema = false)
abstract class RedditDb : RoomDatabase() {

    companion object {
        fun create(context: Context, useInMemory: Boolean): RedditDb {
            val databaseBuilder = if (useInMemory) {
                Room.inMemoryDatabaseBuilder(context, RedditDb::class.java)
            } else {
                Room.databaseBuilder(context, RedditDb::class.java, "reddit.db")
            }
            return databaseBuilder.fallbackToDestructiveMigration().build()
        }
    }

    abstract fun posts(): RedditPostDao
}