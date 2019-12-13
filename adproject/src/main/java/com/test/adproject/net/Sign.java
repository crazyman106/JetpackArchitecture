package com.test.adproject.net;

public class Sign {
    String appkey = "ios001";
    String device_params = AppClient.encrypt(new Params().getParams()); //encrypt(Params); 	  //AES加密
    String nonce_str = "BYYAUGEVICTKLEHPSHAEYCYYNSQGSAUD";
    String params = AppClient.encrypt("wechat=o94OB1RbYFmzyNDWePJdCwWWBhsw&wechat_name=微信名称");
    String timestamp = System.currentTimeMillis() + "";
    String sign = getStr1MD5();

    public String getParamsEncrypt() {
        return params;
    }

    public String getDeviceParams() {
        return device_params;
    }

    public String getStr1MD5() {
        String str = "appkey=" + appkey + "&device_params=" + getDeviceParams() + "&nonce_str=" + nonce_str + "&params=" + getParamsEncrypt() + "&timestamp=" + System.currentTimeMillis();
        String str1 = AppClient.MD5Encrypt1(str);
        String str2 = str1 + nonce_str + timestamp + "dhjhfk4l3Hqh15Vh";
        return AppClient.MD5Encrypt1(str2).toUpperCase();
    }
}