package com.ypw.rxjavaroom;

import com.ypw.rxjavaroom.persistence.User;
import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/24 0024
 * @pkn : com.ypw.rxjavaroom
 * @desc :
 */
public interface UserDataSource {

    Flowable<User> getUser();

    Completable insertOrUpdateUser(User user);

    void deleteAllUsers();
}
