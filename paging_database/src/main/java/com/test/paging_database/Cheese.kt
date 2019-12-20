package com.test.paging_database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_database
 *  @desc   :
 */
@Entity
data class Cheese(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)