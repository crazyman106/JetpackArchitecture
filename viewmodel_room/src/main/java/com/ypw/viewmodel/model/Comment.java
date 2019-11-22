package com.ypw.viewmodel.model;

import java.util.Date;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/10/29 0029
 * @pkn : com.ypw.viewmodel.model
 * @desc :
 */
public interface Comment {
    int getId();
    int getProductId();
    String getText();
    Date getPostedAt();
}
