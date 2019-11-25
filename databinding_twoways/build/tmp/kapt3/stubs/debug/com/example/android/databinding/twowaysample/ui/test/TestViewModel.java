package com.example.android.databinding.twowaysample.ui.test;

import java.lang.System;

/**
 * @author : fengzili on
 * @email  : 291924028@qq.com
 * @date   : 2019/11/22 0022
 * @pkn    : com.example.android.databinding.twowaysample.ui.test
 * @desc   :
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/example/android/databinding/twowaysample/ui/test/TestViewModel;", "Lcom/test/databinding_twoways/util/ObservableViewModel;", "()V", "value", "", "progress", "getProgress", "()I", "setProgress", "(I)V", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "databinding_twoways_debug"})
public final class TestViewModel extends com.test.databinding_twoways.util.ObservableViewModel {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String value;
    private int progress;
    
    @org.jetbrains.annotations.NotNull()
    @androidx.databinding.Bindable()
    public final java.lang.String getValue() {
        return null;
    }
    
    public final void setValue(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @androidx.databinding.Bindable()
    public final int getProgress() {
        return 0;
    }
    
    public final void setProgress(int value) {
    }
    
    public TestViewModel() {
        super();
    }
}