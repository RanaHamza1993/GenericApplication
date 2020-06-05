package com.havelisolutions.genericapplication.di.modules;

import com.havelisolutions.genericapplication.activities.MainActivity;
import com.havelisolutions.genericapplication.di.modules.main.MainFragmentsBuilderModule;
import com.havelisolutions.genericapplication.di.modules.main.MainModule;
import com.havelisolutions.genericapplication.di.modules.main.MainScope;
import com.havelisolutions.genericapplication.di.modules.main.MainViewModelsModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilderModule {

    @MainScope
    @ContributesAndroidInjector(
            modules = {
                    MainFragmentsBuilderModule.class,
                    MainModule.class,
                    MainViewModelsModule.class}
    )
    abstract MainActivity contributeMainActivity();

}
