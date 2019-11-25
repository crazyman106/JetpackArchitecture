package com.test.databinding_twoways.data;

import java.lang.System;

/**
 * @author : fengzili on
 * @email  : 291924028@qq.com
 * @date   : 2019/11/18 0018
 * @pkn    : com.test.databinding_twoways.data
 * @desc   :
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0016\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/test/databinding_twoways/data/IntervalTimerViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "()V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "databinding_twoways_debug"})
public final class IntervalTimerViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
    public static final com.test.databinding_twoways.data.IntervalTimerViewModelFactory INSTANCE = null;
    
    /**
     * isAssignableFrom()方法与instanceof关键字的区别总结为以下两个点：
     *
     * 1. isAssignableFrom()方法是从类继承的角度去判断，instanceof关键字是从实例继承的角度去判断。父类.class.isAssignableFrom(子类.class)
     * 2. isAssignableFrom()方法是判断是否为某个类的父类，instanceof关键字是判断是否某个类的子类。子类实例 instanceof 父类类型
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass) {
        return null;
    }
    
    private IntervalTimerViewModelFactory() {
        super();
    }
}