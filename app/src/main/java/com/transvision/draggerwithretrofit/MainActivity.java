package com.transvision.draggerwithretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;
import com.transvision.draggerwithretrofit.model.Hero;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    //injecting Retrofit
    @Inject
    Retrofit retrofit;
    ListView listView;
    SpinKitView loader;
    List<Hero> heroList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).getNetComponent().inject(this);
        loader = findViewById(R.id.loader);
        listView = findViewById(R.id.listViewHeroes);
                getHeroes();


    }

    private void getHeroes() {
        loader.setVisibility(View.VISIBLE);
        Api api = retrofit.create(Api.class);
        Call<List<Hero>> call = api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                heroList = response.body();
                String[] heroes = new String[heroList.size()];

                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getName();
                }

                listView.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(MainActivity.this, "Clicked " +heroList.get(i).getName() , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
                        intent.putExtra("name",heroList.get(i).getName());
                        intent.putExtra("realname",heroList.get(i).getRealname());
                        intent.putExtra("team",heroList.get(i).getTeam());
                        intent.putExtra("firstappearance",heroList.get(i).getFirstappearance());
                        intent.putExtra("createdby",heroList.get(i).getCreatedby());
                        intent.putExtra("publisher",heroList.get(i).getPublisher());
                        intent.putExtra("imageurl",heroList.get(i).getImageurl());
                        intent.putExtra("bio",heroList.get(i).getBio());
                        startActivity(intent);
                    }
                });
                loader.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

