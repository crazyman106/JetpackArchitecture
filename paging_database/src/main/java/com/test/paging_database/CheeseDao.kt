package com.test.paging_database

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_database
 *  @desc   :
 */
@Dao
interface CheeseDao {

    @Query("select * from Cheese ORDER BY name COLLATE NOCASE ASC")
    fun allCheesesByName(): DataSource.Factory<Int, Cheese>

    @Insert
    fun insert(cheese: Cheese)

    @Insert
    fun insert(cheese: List<Cheese>)

    @Delete
    fun delete(cheese: Cheese)
}