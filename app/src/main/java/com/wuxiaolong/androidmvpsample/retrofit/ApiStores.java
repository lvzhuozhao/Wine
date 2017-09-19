package com.wuxiaolong.androidmvpsample.retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;


public interface ApiStores {

    String API_SERVER_URL = "http://192.168.1.29:8080/hotels/";
    String Web_URL = "http://192.168.1.29:8080";

    @GET
    Call<String> getMethod(@Url String url);

    @FormUrlEncoded
    @POST
    Call<String> postMethod(@Url String url, @FieldMap Map<String, String> map);
}
