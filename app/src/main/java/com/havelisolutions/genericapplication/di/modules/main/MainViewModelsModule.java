package com.havelisolutions.genericapplication.di.modules.main;

import androidx.lifecycle.ViewModel;


import com.havelisolutions.genericapplication.di.annotations.ViewModelKey;
import com.havelisolutions.genericapplication.viewmodels.BaseViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(BaseViewModel.class)
    public abstract ViewModel bindSharedViewModel(BaseViewModel viewModel);

}
