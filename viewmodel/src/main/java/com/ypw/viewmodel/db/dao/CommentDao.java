package com.ypw.viewmodel.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.ypw.viewmodel.db.entity.CommentEntity;

import java.util.List;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/29 0029
 * @pkn : com.ypw.viewmodel.db.dao
 * @desc :
 */
@Dao
public interface CommentDao {
    @Query("SELECT * FROM comments where productId= :productId")
    LiveData<List<CommentEntity>> loadComments(int productId); // 自动会在后台线程启动查询

    @Query("SELECT * FROM comments where productId = :productId")
    List<CommentEntity> loadCommentsSync(int productId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CommentEntity> comments);
}
