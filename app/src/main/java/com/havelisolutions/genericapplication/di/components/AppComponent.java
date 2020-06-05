package com.havelisolutions.genericapplication.di.components;

import android.app.Application;


import com.havelisolutions.genericapplication.BaseApplication;
import com.havelisolutions.genericapplication.di.modules.ActivityBuilderModule;
import com.havelisolutions.genericapplication.di.modules.AppModule;
import com.havelisolutions.genericapplication.di.modules.ViewModelFactoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidSupportInjectionModule.class,
                ActivityBuilderModule.class,
                AppModule.class,
                ViewModelFactoryModule.class
        }
)
public interface AppComponent extends AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}
