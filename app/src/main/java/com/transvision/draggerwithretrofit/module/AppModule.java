package com.transvision.draggerwithretrofit.module;

import android.app.Application;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application myapplication;

    public AppModule(Application myapplication){
        this.myapplication = myapplication;
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return myapplication;
    }
}
