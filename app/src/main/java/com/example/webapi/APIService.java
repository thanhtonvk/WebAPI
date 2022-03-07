package com.example.webapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface APIService {
    Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
    APIService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.107:6969/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIService.class);
    @GET("api/hocsinh/getdshocsinh")
    Call<List<HocSinh>> GetDSHocSinh();
    @GET("api/hocsinh/gethocsinhbyid")
    Call<HocSinh> GetHocSinhByID(@Query("ID") int id);
    @POST("api/hocsinh/themhocsinh")
    Call<List<HocSinh>> ThemHocSinh(@Body HocSinh hocSinh);
    @PUT("api/hocsinh/suahocsinh")
    Call<List<HocSinh>> SuaHocSinh(@Body HocSinh hocSinh);
    @PUT("api/hocsinh/suahs")
    Call<List<HocSinh>> Edit(@Query("ID") int id,@Body HocSinh hocSinh);
}
