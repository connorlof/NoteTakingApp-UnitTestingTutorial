package com.loftydevelopment.notetakingapp_unittestingtutorial;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.loftydevelopment.notetakingapp_unittestingtutorial.persistence.NoteDao;
import com.loftydevelopment.notetakingapp_unittestingtutorial.persistence.NoteDatabase;

import org.junit.After;
import org.junit.Before;

public abstract class NoteDatabaseTest {

    private NoteDatabase noteDatabase;

    public NoteDao getNoteDao(){
        return noteDatabase.getNoteDao();
    }

    @Before
    public void init() {
        noteDatabase = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                NoteDatabase.class
        ).build();

    }

    @After
    public void finish() {
        noteDatabase.close();
    }

}
