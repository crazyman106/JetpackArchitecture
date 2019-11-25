package com.test.databinding_twoways.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/test/databinding_twoways/util/DefaultTimer;", "Lcom/test/databinding_twoways/util/Timer;", "()V", "TIMER_PERIOD_MS", "", "pauseTime", "startTime", "timer", "Ljava/util/Timer;", "getElapsedTime", "getPausedTime", "reset", "", "resetPauseTime", "resetStartTime", "start", "task", "Ljava/util/TimerTask;", "updatePausedTime", "databinding_twoways_debug"})
public final class DefaultTimer implements com.test.databinding_twoways.util.Timer {
    private static final long TIMER_PERIOD_MS = 100L;
    private static long startTime;
    private static long pauseTime;
    private static java.util.Timer timer;
    public static final com.test.databinding_twoways.util.DefaultTimer INSTANCE = null;
    
    @java.lang.Override()
    public void reset() {
    }
    
    @java.lang.Override()
    public void start(@org.jetbrains.annotations.NotNull()
    java.util.TimerTask task) {
    }
    
    @java.lang.Override()
    public long getElapsedTime() {
        return 0L;
    }
    
    @java.lang.Override()
    public void updatePausedTime() {
    }
    
    @java.lang.Override()
    public long getPausedTime() {
        return 0L;
    }
    
    @java.lang.Override()
    public void resetStartTime() {
    }
    
    @java.lang.Override()
    public void resetPauseTime() {
    }
    
    private DefaultTimer() {
        super();
    }
}