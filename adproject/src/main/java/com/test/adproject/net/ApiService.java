package com.test.adproject.net;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/12/12 0012
 * @pkn : com.test.adproject.net
 * @desc :
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("user/login")
    Observable<String> login(@Field("device_params") String device_params, @Field("params") String params, @Field("sign") String sign,
                             @Field("appkey") String appkey, @Field("nonce_str") String nonce_str, @Field("timestamp") String timestamp);

    @POST("user/login")
    Observable<String> login1(@Body LoginParams bean);
}
