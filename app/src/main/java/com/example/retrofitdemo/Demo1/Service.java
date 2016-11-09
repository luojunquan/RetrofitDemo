package com.example.retrofitdemo.Demo1;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by：赖上罗小贱 on 2016/11/9
 * 邮箱：ljq@luojunquan.top
 * 个人博客：www.luojunquan.top
 * CSDN:http://blog.csdn.net/u012990171
 */
public interface Service {
    @POST("/api/{category}/list")
    @FormUrlEncoded
    Call<Tngou> getList(@Path("category") String category, @Field("id") int id,
                        @Field("page") int page, @Field("rows") int rows);
    /*
     @GET("/api/cook/list")
      Call<Tngou> getList(@Query("id") int id, @Query("page") int page, @Query("rows") int rows);
     */
}
