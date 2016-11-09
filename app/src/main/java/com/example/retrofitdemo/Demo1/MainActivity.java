package com.example.retrofitdemo.Demo1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.retrofitdemo.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<Tngou> {
    private ListView listView;
    private TngouAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.tngou.net/api/cook/list")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service service = retrofit.create(Service.class);
        final Call<Tngou> call = service.getList("cook",0,1,50);
        call.enqueue(this);
        listView = (ListView) findViewById(R.id.listView1);
        adapter = new TngouAdapter(this,new ArrayList<Cook>());
        listView.setAdapter(adapter);
    }

    @Override
    public void onResponse(Response<Tngou> response, Retrofit retrofit) {
        List<Cook> list = response.body().getList();
        adapter.addAll(list);
    }

    @Override
    public void onFailure(Throwable throwable) {

    }
}
