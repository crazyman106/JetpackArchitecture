package com.ypw.rxjavaroom.ui;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.ypw.rxjavaroom.UserDataSource;
import com.ypw.rxjavaroom.persistence.User;
import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/24 0024
 * @pkn : com.ypw.rxjavaroom.ui
 * @desc :
 */
public class UserViewModel extends ViewModel {
    private UserDataSource mDataSource;
    private User mUser;

    public UserDataSource getmDataSource() {
        return mDataSource;
    }

    public UserViewModel(UserDataSource dataSource) {
        mDataSource = dataSource;
    }

    public Flowable<String> getUserName() {
        Log.e("UserViewModel", mUser != null ? mUser.toString() : "--");
        return mDataSource.getUser()
                .map(user -> {
                    mUser = user;
                    return user.getUserName();
                });
    }

    public Completable updateUserName(final String userName) {
        mUser = mUser == null
                ? new User(userName)
                : new User(mUser.getId(), userName);
        return mDataSource.insertOrUpdateUser(mUser);
    }

    public void delete() {
        mDataSource.deleteAllUsers();
    }
}
