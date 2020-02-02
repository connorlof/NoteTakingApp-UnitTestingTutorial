package com.loftydevelopment.notetakingapp_unittestingtutorial.di;

import com.loftydevelopment.notetakingapp_unittestingtutorial.NoteListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract NoteListActivity contributeNotesListActivity();

}
