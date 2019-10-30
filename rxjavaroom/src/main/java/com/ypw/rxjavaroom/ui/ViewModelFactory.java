package com.ypw.rxjavaroom.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.ypw.rxjavaroom.UserDataSource;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/24 0024
 * @pkn : com.ypw.rxjavaroom.ui
 * @desc :
 */
public class ViewModelFactory implements ViewModelProvider.Factory {
    private final UserDataSource mDataSource;

    public ViewModelFactory(UserDataSource mDataSource) {
        this.mDataSource = mDataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(UserViewModel.class)) {
            return (T) new UserViewModel(mDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
