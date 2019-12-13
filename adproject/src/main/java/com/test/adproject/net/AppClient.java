package com.test.adproject.net;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author : fengzili on
 * @email : 291924028@qq.com
 * @date : 2019/12/12 0012
 * @pkn : com.test.adproject.net
 * @desc :
 */
public class AppClient {
    private static ApiService apiService;

    public static ApiService getApiService() {
        if (apiService == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                    .sslSocketFactory(SSLContextFactory.createSSLSocketFactory())
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(chain -> {
                        Request request = chain.request()
                                .newBuilder()
//                                    .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//                                    .addHeader("Accept-Encoding", "gzip, deflate")
//                                    .addHeader("Connection", "keep-alive")
//                                    .addHeader("Accept", "*/*")
                                .build();
                        return chain.proceed(request);
                    })
//                    .addInterceptor(addQueryParameterInterceptor())
                    .build();
            Retrofit retrofit = new Retrofit.Builder().client(okHttpClient)
                    .baseUrl("https://taoqichong.cn/api.php/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }


    /**
     * 添加公共参数
     *
     * @return
     */
    private static Interceptor addQueryParameterInterceptor() {
        Interceptor addQueryParameterInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request;
                HttpUrl httpUrl = originalRequest.url().newBuilder()
                        /* .addQueryParameter("mac", "")*/
                        .build();
                request = originalRequest.newBuilder().url(httpUrl).build();
                return chain.proceed(request);
            }
        };
        return addQueryParameterInterceptor;
    }

    private static String getHeader() {
        return "";
    }

    // aes
    /*
     * 加密
     */
    public static String encrypt(String cleartext) {
        if (TextUtils.isEmpty(cleartext)) {
            return cleartext;
        }
        try {
            byte[] result = encrypt("bgVf#3vT8@41v#O$", cleartext);
            return new String(Base64.encode(result, Base64.DEFAULT));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] encrypt(String password, String clear) throws Exception {
        // 创建AES秘钥
        SecretKeySpec secretKeySpec = new SecretKeySpec(password.getBytes(), "AES/ECB/PKCS5PADDING");//AES是加密方式 CBC是工作模式 PKCS5Padding是填充模式
        // 创建密码器
        Cipher cipher = Cipher.getInstance("AES");
        // 初始化加密器
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        // 加密
        return cipher.doFinal(clear.getBytes("UTF-8"));
    }

    private byte[] decrypt(byte[] content, String password) throws Exception {
        // 创建AES秘钥
        SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES/ECB/PKCS5PADDING");
        // 创建密码器
        Cipher cipher = Cipher.getInstance("AES");
        // 初始化解密器
        cipher.init(Cipher.DECRYPT_MODE, key);
        // 解密
        return cipher.doFinal(content);
    }

    // MD5
    public static final byte[] MD5Encrypt2(String string) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(string.getBytes("UTF-8"));
            return digest;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final static String MD5Encrypt1(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4',
                '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] btInput = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
