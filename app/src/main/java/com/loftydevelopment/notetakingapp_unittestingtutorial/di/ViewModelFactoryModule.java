package com.loftydevelopment.notetakingapp_unittestingtutorial.di;

import androidx.lifecycle.ViewModelProvider;

import com.loftydevelopment.notetakingapp_unittestingtutorial.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(
      ViewModelProviderFactory viewModelProviderFactory
    );
}
