package com.test.databinding_twoways.util;

import java.lang.System;

/**
 * @author : fengzili on
 * @email  : 291924028@qq.com
 * @date   : 2019/11/18 0018
 * @pkn    : com.test.databinding_twoways.util
 * @desc   :
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/test/databinding_twoways/util/Timer;", "", "getElapsedTime", "", "getPausedTime", "reset", "", "resetPauseTime", "resetStartTime", "start", "task", "Ljava/util/TimerTask;", "updatePausedTime", "databinding_twoways_debug"})
public abstract interface Timer {
    
    public abstract void reset();
    
    public abstract void start(@org.jetbrains.annotations.NotNull()
    java.util.TimerTask task);
    
    public abstract long getElapsedTime();
    
    public abstract void updatePausedTime();
    
    public abstract long getPausedTime();
    
    public abstract void resetStartTime();
    
    public abstract void resetPauseTime();
}