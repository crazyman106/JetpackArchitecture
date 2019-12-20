package com.paging

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.paging.api.GithubService
import com.paging.data.GithubDataRepository
import com.paging.db.GithubLocalRepository
import com.paging.db.RepoDatabase
import com.paging.ui.ViewModelFactory
import java.util.concurrent.Executors

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/16 0016
 *  @pkn    : com.paging
 *  @desc   :
 */
object Injection {

    private fun provideGithubRepository(context: Context): GithubDataRepository {
        return GithubDataRepository(GithubService.create(), provideCache(context))
    }

    private fun provideCache(context: Context): GithubLocalRepository {
        val database = RepoDatabase.getInstance(context)
        return GithubLocalRepository(database.repoDao(), Executors.newSingleThreadExecutor())
    }

    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(provideGithubRepository(context))

    }
}