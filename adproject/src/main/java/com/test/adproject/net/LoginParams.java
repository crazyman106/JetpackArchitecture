package com.test.adproject.net;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/12/12 0012
 * @pkn : com.test.adproject.net
 * @desc :
 */
public class LoginParams {

    String device_params = new Sign().getDeviceParams();
    String params = new Sign().getParamsEncrypt();
    String sign = new Sign().getStr1MD5();
    String appkey = "ios001";
    String nonce_str = "BYYAUGEVICTKLEHPSHAEYCYYNSQGSAUD";
    String timestamp = System.currentTimeMillis() + "";
}
