package com.loftydevelopment.notetakingapp_unittestingtutorial.di;

import android.app.Application;

import androidx.room.Room;

import com.loftydevelopment.notetakingapp_unittestingtutorial.persistence.NoteDao;
import com.loftydevelopment.notetakingapp_unittestingtutorial.persistence.NoteDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    @Singleton
    @Provides
    static NoteDatabase provideNoteDatabase(Application application) {
        return Room.databaseBuilder(
                application,
                NoteDatabase.class,
                NoteDatabase.DATABASE_NAME
        ).build();
    }

    @Singleton
    @Provides
    static NoteDao provideNoteDao(NoteDatabase noteDatabase) {
        return noteDatabase.getNoteDoa();
    }
}
