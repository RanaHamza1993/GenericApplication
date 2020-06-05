package com.havelisolutions.genericapplication.di.modules;

import androidx.lifecycle.ViewModelProvider;


import com.havelisolutions.genericapplication.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
abstract public class ViewModelFactoryModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory factory);
}
