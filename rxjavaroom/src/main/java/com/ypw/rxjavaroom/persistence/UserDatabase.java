package com.ypw.rxjavaroom.persistence;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/24 0024
 * @pkn : com.ypw.rxjavaroom.persistence
 * @desc :
 */
@Database(entities = {User.class}, version = 1, exportSchema = true)
@TypeConverters(value = {DateConverter.class})
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private volatile static UserDatabase INSTANCE;

    public static UserDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (UserDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(), UserDatabase.class, "room_test.db")
//                            .addMigrations(MIGRATION_1_2)
//                            .fallbackToDestructiveMigrationFrom(1,2)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /*static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE new_User (" +
                    "userid TEXT PRIMARY KEY NOT NULL," +
                    "username TEXT," +
                    "age INTEGER NOT NULL DEFAULT '')");
            database.execSQL("INSERT INTO new_User (userid, username , age ) " +
                    "SELECT userid, username ,age  FROM users");
            database.execSQL("DROP TABLE users");
            database.execSQL("ALTER TABLE new_User RENAME TO users");
        }
    };*/
}
