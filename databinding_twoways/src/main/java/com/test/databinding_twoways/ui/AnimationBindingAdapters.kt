package com.test.databinding_twoways.ui

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.animation.ValueAnimator.*
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.test.databinding_twoways.R

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/11/19 0019
 *  @pkn    : com.test.databinding_twoways.ui
 *  @desc   : A collection of [BindingAdapter]s used to create animations in the app
 */
object AnimationBindingAdapters {

    private const val VERTICAL_BIAS_ANIMATION_DURATION = 900L

    private const val BG_COLOR_ANIMATION_DURATION = 500L


    @BindingAdapter(value = ["animateBackground", "animateBackgroundStage"], requireAll = true)
    @JvmStatic
    fun animateBackground(view: View, timerRunning: Boolean, activeStage: Boolean) {
        // If the timer is not running, don't animate and set the default color.
        if (!timerRunning) {
            view.setBackgroundColor(
                ContextCompat.getColor(view.context, R.color.disabledInputColor)
            )
            // This tag prevents a glitch going from reset to started.
            view.setTag(R.id.hasBeenAnimated, false)
            return
        }
        // activeStage controls whether this particular timer (work or rest) is active.
        if (activeStage) {
            // Start animation
            animateBgColor(view, true)
            // This tag prevents a glitch going from paused to started.
            view.setTag(R.id.hasBeenAnimated, true)
        } else {
            // Prevent "end" animation if animation never started
            val hasItBeenAnimated = view.getTag(R.id.hasBeenAnimated) as Boolean?
            if (hasItBeenAnimated == true) {
                // End animation
                animateBgColor(view, false)
                view.setTag(R.id.hasBeenAnimated, false)
            }
        }
    }

    /**
     * Controls an animation that moves a view up and down.
     *
     * @param view one of the timers (work/rest)
     * @param timerRunning whether the app timer is running
     * @param activeStage whether this particular timer (work/rest) is active
     */
    @BindingAdapter(
        value = ["animateVerticalBias", "animateVerticalBiasStage"],
        requireAll = true
    )
    @JvmStatic
    fun animateVerticalBias(view: View, timerRunning: Boolean, activeStage: Boolean) {
        when {
            timerRunning && activeStage -> animateVerticalBias(view, 0.6f)
            timerRunning && !activeStage -> animateVerticalBias(view, 0.4f)
            else -> animateVerticalBias(view, 0.5f)
        }
    }

    private fun animateBgColor(view: View, tint: Boolean) {
        val colorRes = ContextCompat.getColor(view.context, R.color.colorPrimaryLight)
        val color2Res = ContextCompat.getColor(view.context, R.color.disabledInputColor)
        val animator =
            if (tint)
                ObjectAnimator.ofObject(
                    view, "backgroundColor", ArgbEvaluator(), color2Res,
                    colorRes
                ) else
                ObjectAnimator.ofObject(
                    view, "backgroundColor", ArgbEvaluator(), colorRes,
                    color2Res
                )
        animator.duration = BG_COLOR_ANIMATION_DURATION
        animator.start()
    }

    private fun animateVerticalBias(view: View, position: Float) {
        val layoutParams: ConstraintLayout.LayoutParams =
            view.layoutParams as ConstraintLayout.LayoutParams
        val animator = ofFloat(layoutParams.verticalBias, position)
        animator.addUpdateListener {
            val newParams: ConstraintLayout.LayoutParams =
                view.layoutParams as ConstraintLayout.LayoutParams
            val animatedValue = it.animatedValue as Float
            newParams.verticalBias = animatedValue
            view.requestLayout()
        }
        animator.interpolator = DecelerateInterpolator()
        animator.duration = VERTICAL_BIAS_ANIMATION_DURATION
        animator.start()
    }
}