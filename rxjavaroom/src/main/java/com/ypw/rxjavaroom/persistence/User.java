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

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.UUID;

import static androidx.room.ColumnInfo.INTEGER;

/**
 * Immutable model class for a User
 */
@Entity(tableName = "users")
public class User {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "userid")
    private String mId;

    @ColumnInfo(name = "username")
    private String mUserName;

  /*  @ColumnInfo(name = "age", typeAffinity = INTEGER, defaultValue = "11")
    private Integer age;*/


 /*   public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }*/
    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public void setmId(@NonNull String mId) {
        this.mId = mId;
    }



    @Ignore
    public User(String userName) {
        mId = UUID.randomUUID().toString();
        mUserName = userName;
    }

    public User(String id, String userName) {
        this.mId = id;
        this.mUserName = userName;
    }

    public String getId() {
        return mId;
    }

    public String getUserName() {
        return mUserName;
    }

    @Override
    public String toString() {
        return "User{" +
                "mId='" + mId + '\'' +
                ", mUserName='" + mUserName + '\'' +
                '}';
    }
}
