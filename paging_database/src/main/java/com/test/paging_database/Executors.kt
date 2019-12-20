package com.test.paging_database

import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_database
 *  @desc   :
 */
private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

fun ioThread(f: () -> Unit) {
    IO_EXECUTOR.execute(f)
}