package com.test.databinding_twoways.ui;

import java.lang.System;

/**
 * @author : fengzili on
 * @email  : 291924028@qq.com
 * @date   : 2019/11/19 0019
 * @pkn    : com.test.databinding_twoways.ui
 * @desc   : A collection of [BindingAdapter]s used to create animations in the app
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/test/databinding_twoways/ui/AnimationBindingAdapters;", "", "()V", "BG_COLOR_ANIMATION_DURATION", "", "VERTICAL_BIAS_ANIMATION_DURATION", "animateBackground", "", "view", "Landroid/view/View;", "timerRunning", "", "activeStage", "animateBgColor", "tint", "animateVerticalBias", "position", "", "databinding_twoways_debug"})
public final class AnimationBindingAdapters {
    private static final long VERTICAL_BIAS_ANIMATION_DURATION = 900L;
    private static final long BG_COLOR_ANIMATION_DURATION = 500L;
    public static final com.test.databinding_twoways.ui.AnimationBindingAdapters INSTANCE = null;
    
    @androidx.databinding.BindingAdapter(requireAll = true, value = {"animateBackground", "animateBackgroundStage"})
    public static final void animateBackground(@org.jetbrains.annotations.NotNull()
    android.view.View view, boolean timerRunning, boolean activeStage) {
    }
    
    /**
     * Controls an animation that moves a view up and down.
     *
     * @param view one of the timers (work/rest)
     * @param timerRunning whether the app timer is running
     * @param activeStage whether this particular timer (work/rest) is active
     */
    @androidx.databinding.BindingAdapter(requireAll = true, value = {"animateVerticalBias", "animateVerticalBiasStage"})
    public static final void animateVerticalBias(@org.jetbrains.annotations.NotNull()
    android.view.View view, boolean timerRunning, boolean activeStage) {
    }
    
    private final void animateBgColor(android.view.View view, boolean tint) {
    }
    
    private final void animateVerticalBias(android.view.View view, float position) {
    }
    
    private AnimationBindingAdapters() {
        super();
    }
}