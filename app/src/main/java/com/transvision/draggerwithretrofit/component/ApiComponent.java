package com.transvision.draggerwithretrofit.component;


import com.transvision.draggerwithretrofit.MainActivity;
import com.transvision.draggerwithretrofit.module.ApiModule;
import com.transvision.draggerwithretrofit.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}