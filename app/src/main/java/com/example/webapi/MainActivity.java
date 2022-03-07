package com.example.webapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        Gson gson = new Gson();
        HocSinh hocSinh = new HocSinh(10,"xin chao",20);
        APIService.apiService.ThemHocSinh(hocSinh).enqueue(new Callback<List<HocSinh>>() {
            @Override
            public void onResponse(Call<List<HocSinh>> call, Response<List<HocSinh>> response) {
                List<HocSinh>hocSinhs = response.body();
                String json  = gson.toJson(hocSinhs);
                tv.setText(json);
            }

            @Override
            public void onFailure(Call<List<HocSinh>> call, Throwable t) {

            }
        });
    }
}