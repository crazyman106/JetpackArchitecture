package com.paging.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.paging.model.Repo
import java.security.AccessControlContext
import java.util.concurrent.Executor

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/13 0013
 *  @pkn    : com.paging.db
 *  @desc   :
 */

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<Repo>)

    /**
     * 做一个本地搜索
     *
     */
    @Query("select * from repos where (name LIKE :queryString) or (description like :queryString)  ORDER BY stars DESC, name ASC")
    fun reposByName(queryString: String): LiveData<List<Repo>>
}

abstract class RepoDatabase : RoomDatabase() {

    abstract fun repoDao(): RepoDao

    companion object {

        @Volatile
        private var INSTANCE: RepoDatabase? = null

        fun getInstance(context: Context): RepoDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): RepoDatabase {
            return Room.databaseBuilder(context, RepoDatabase::class.java, "paging.db")
                .build()
        }
    }
}

// 在正确的线程中执行数据库操作
class GithubLocalRepository(
    private val repoDao: RepoDao,
    private val ioExecutor: Executor
) {

    fun insert(repos: List<Repo>, insertFinished: () -> Unit) {
        ioExecutor.execute {
            repoDao.insert(repos)
            insertFinished()
        }
    }
}