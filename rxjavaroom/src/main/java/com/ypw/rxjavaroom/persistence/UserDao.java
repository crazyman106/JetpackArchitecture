/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ypw.rxjavaroom.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;

import java.util.Date;
import java.util.List;

/**
 * Data Access Object for the users table.
 * <p>
 * room支持rxjava2类型返回数据
 *
 * @Query:Publisher,Flowable,Observable
 * @Insert:Completable,Single<T>,Maybe<T> </p>
 * build.gradle
 * dependencies {
 * def room_version = "2.1.0"
 * implementation 'androidx.room:room-rxjava2:$room_version'
 * }
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM Users LIMIT 1")
    Flowable<User> getUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertUser(User user);

    @Query("DELETE FROM Users")
    void deleteAllUsers();

    // 使用复杂数据
//    @Query("SELECT * FROM Users WHERE xxx BETWEEN :from AND :to")
//    List<User> findUsersBornBetweenDates(Date from, Date to);

}
