package com.test.databinding_twoways.util

import java.util.*

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/11/18 0018
 *  @pkn    : com.test.databinding_twoways.util
 *  @desc   :
 */
interface Timer {
    fun reset()
    fun start(task: TimerTask)
    fun getElapsedTime(): Long
    fun updatePausedTime()
    fun getPausedTime(): Long
    fun resetStartTime()
    fun resetPauseTime()
}

object DefaultTimer : Timer {
    private const val TIMER_PERIOD_MS = 100L
    private var startTime = System.currentTimeMillis()
    private var pauseTime = 0L
    private var timer = java.util.Timer()

    override fun reset() {
        timer.cancel()
    }

    override fun start(task: TimerTask) {
        timer = Timer()
        timer.scheduleAtFixedRate(task, 0, TIMER_PERIOD_MS)
    }

    override fun getElapsedTime(): Long = System.currentTimeMillis() - startTime

    override fun updatePausedTime() {
        startTime += System.currentTimeMillis() - pauseTime
    }

    override fun getPausedTime(): Long = pauseTime - startTime

    override fun resetStartTime() {
        startTime = System.currentTimeMillis()
    }

    override fun resetPauseTime() {
        pauseTime = System.currentTimeMillis()
    }

}