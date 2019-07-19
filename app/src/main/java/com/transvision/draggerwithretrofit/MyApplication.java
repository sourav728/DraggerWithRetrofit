package com.transvision.draggerwithretrofit;

import android.app.Application;

import com.transvision.draggerwithretrofit.component.ApiComponent;
import com.transvision.draggerwithretrofit.component.DaggerApiComponent;
import com.transvision.draggerwithretrofit.module.ApiModule;
import com.transvision.draggerwithretrofit.module.AppModule;

public class MyApplication extends Application {
    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        apiComponent = DaggerApiComponent.builder()
                        .appModule(new AppModule(this))
                        .apiModule(new ApiModule("https://gist.githubusercontent.com/sourav728/46a7ebc3aa48339f2f2178a43c1f4bc1/raw/8c0750fcef477506593ac4ad7c11263d36a98f0a/"))
                        .build();
    }

    public ApiComponent getNetComponent() {
        return apiComponent;
    }
}
