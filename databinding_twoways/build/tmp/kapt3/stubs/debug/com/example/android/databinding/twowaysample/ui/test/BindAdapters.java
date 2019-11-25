package com.example.android.databinding.twowaysample.ui.test;

import java.lang.System;

/**
 * @author : fengzili on
 * @email  : 291924028@qq.com
 * @date   : 2019/11/22 0022
 * @pkn    : com.example.android.databinding.twowaysample.ui.test
 * @desc   :
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\bH\u0007J\u001a\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/example/android/databinding/twowaysample/ui/test/BindAdapters;", "", "()V", "getNumberOfSets", "", "view", "Landroid/widget/EditText;", "getProgress", "", "Landroid/widget/SeekBar;", "hideKeyboardOnInputDone", "", "enabled", "", "setNumberOfSets", "value", "setNumberOfSetsListener", "listener", "Landroidx/databinding/InverseBindingListener;", "setProgress", "setProgressSetsListener", "databinding_twoways_debug"})
public final class BindAdapters {
    public static final com.example.android.databinding.twowaysample.ui.test.BindAdapters INSTANCE = null;
    
    @androidx.databinding.BindingAdapter(value = {"numberOfSets"})
    public static final void setNumberOfSets(@org.jetbrains.annotations.NotNull()
    android.widget.EditText view, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.databinding.InverseBindingAdapter(attribute = "numberOfSets", event = "numberOfSetsAttrChanged")
    public static final java.lang.String getNumberOfSets(@org.jetbrains.annotations.NotNull()
    android.widget.EditText view) {
        return null;
    }
    
    @androidx.databinding.BindingAdapter(requireAll = false, value = {"numberOfSetsAttrChanged"})
    public static final void setNumberOfSetsListener(@org.jetbrains.annotations.NotNull()
    android.widget.EditText view, @org.jetbrains.annotations.Nullable()
    androidx.databinding.InverseBindingListener listener) {
    }
    
    /**
     * Hides keyboard when the [EditText] is focused.
     *
     * Note that there can only be one [TextView.OnEditorActionListener] on each [EditText] and
     * this [BindingAdapter] sets it.
     */
    @androidx.databinding.BindingAdapter(value = {"hideKeyboardOnInputDone"})
    public static final void hideKeyboardOnInputDone(@org.jetbrains.annotations.NotNull()
    android.widget.EditText view, boolean enabled) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"setProgress"})
    public static final void setProgress(@org.jetbrains.annotations.NotNull()
    android.widget.SeekBar view, int value) {
    }
    
    @androidx.databinding.InverseBindingAdapter(attribute = "setProgress", event = "setProgressAttrChanged")
    public static final int getProgress(@org.jetbrains.annotations.NotNull()
    android.widget.SeekBar view) {
        return 0;
    }
    
    @androidx.databinding.BindingAdapter(requireAll = false, value = {"setProgressAttrChanged"})
    public static final void setProgressSetsListener(@org.jetbrains.annotations.NotNull()
    android.widget.SeekBar view, @org.jetbrains.annotations.Nullable()
    androidx.databinding.InverseBindingListener listener) {
    }
    
    private BindAdapters() {
        super();
    }
}