package com.transvision.draggerwithretrofit;

import com.transvision.draggerwithretrofit.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    //String BASE_URL = "https://gist.githubusercontent.com/sourav728/46a7ebc3aa48339f2f2178a43c1f4bc1/raw/8c0750fcef477506593ac4ad7c11263d36a98f0a/";
    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
