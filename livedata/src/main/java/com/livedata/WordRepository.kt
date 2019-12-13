package com.livedata

import androidx.lifecycle.LiveData

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/11 0011
 *  @pkn    : com.livedata
 *  @desc   :
 */
class WordRepository(val dao: WordDao) {
    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Word>> = dao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        dao.insert(word)
    }
}