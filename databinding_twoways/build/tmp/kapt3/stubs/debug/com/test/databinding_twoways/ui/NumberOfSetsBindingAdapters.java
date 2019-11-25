package com.test.databinding_twoways.ui;

import java.lang.System;

/**
 * The @={} notation, which importantly includes the "=" sign, receives data changes to the property and listen to user updates at the same time
 *
 * The [EditText] that controls the number of sets is using two-way Data Binding. Applying a
 * 2-way expression to the `android:text` attribute of the EditText triggers an update on every
 * keystroke. This is an alternative implementation that uses a [View.OnFocusChangeListener]
 * instead.
 *
 * `numberOfSetsAttrChanged` creates a listener that triggers when the focus is lost
 *
 * `hideKeyboardOnInputDone` (in a different file) will clear focus when the `Done` action on
 * the keyboard is dispatched, triggering `numberOfSetsAttrChanged`.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\u0010\bJ#\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u00020\n*\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0007H\u0007J\u0014\u0010\u0011\u001a\u00020\n*\u00020\u00072\u0006\u0010\f\u001a\u00020\u0012H\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/test/databinding_twoways/ui/NumberOfSetsBindingAdapters;", "", "()V", "getNumberOfSets_alternative", "", "", "editText", "Landroid/widget/EditText;", "(Landroid/widget/EditText;)[Ljava/lang/Integer;", "setNumberOfSets_alternative", "", "view", "value", "(Landroid/widget/EditText;[Ljava/lang/Integer;)V", "setListener", "listener", "Landroidx/databinding/InverseBindingListener;", "setNumberOfSets", "", "databinding_twoways_debug"})
public final class NumberOfSetsBindingAdapters {
    public static final com.test.databinding_twoways.ui.NumberOfSetsBindingAdapters INSTANCE = null;
    
    /**
     * Needs to be used with [NumberOfSetsConverters.setArrayToString].
     */
    @androidx.databinding.BindingAdapter(value = {"setNumberOfSets"})
    public static final void setNumberOfSets(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$setNumberOfSets, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    /**
     * Called when the [InverseBindingListener] of the `numberOfSetsAttrChanged` binding adapter
     * is notified of a change.
     *
     * Used with the inverse method of [NumberOfSetsConverters.setArrayToString], which is
     * [NumberOfSetsConverters.stringToSetArray].
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.databinding.InverseBindingAdapter(attribute = "numberOfSets")
    public static final java.lang.String setNumberOfSets(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$setNumberOfSets) {
        return null;
    }
    
    /**
     * That this Binding Adapter is not defined in the XML. "AttrChanged" is a special
     * suffix that lets you manage changes in the value, using two-way Data Binding.
     *
     * Note that setting a [View.OnFocusChangeListener] overrides other listeners that might be set
     * with `android:onFocusChangeListener`. Consider supporting both in the same binding adapter
     * with `requireAll = false`. See [android.databinding.adapters.CompoundButtonBindingAdapter]
     * for an example.
     */
    @androidx.databinding.BindingAdapter(value = {"numberOfSetsAttrChanged"})
    public static final void setListener(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$setListener, @org.jetbrains.annotations.NotNull()
    androidx.databinding.InverseBindingListener listener) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"numberOfSets_alternative"})
    public static final void setNumberOfSets_alternative(@org.jetbrains.annotations.NotNull()
    android.widget.EditText view, @org.jetbrains.annotations.NotNull()
    java.lang.Integer[] value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.databinding.InverseBindingAdapter(attribute = "numberOfSets_alternative")
    public static final java.lang.Integer[] getNumberOfSets_alternative(@org.jetbrains.annotations.NotNull()
    android.widget.EditText editText) {
        return null;
    }
    
    private NumberOfSetsBindingAdapters() {
        super();
    }
}