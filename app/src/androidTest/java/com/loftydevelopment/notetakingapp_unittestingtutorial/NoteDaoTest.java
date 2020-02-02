package com.loftydevelopment.notetakingapp_unittestingtutorial;

import android.database.sqlite.SQLiteConstraintException;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.loftydevelopment.notetakingapp_unittestingtutorial.models.Note;
import com.loftydevelopment.notetakingapp_unittestingtutorial.util.LiveDataTestUtil;
import com.loftydevelopment.notetakingapp_unittestingtutorial.util.TestUtil;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.internal.matchers.Not;

import java.util.List;

public class NoteDaoTest extends NoteDatabaseTest {

    public static final String TEST_TITLE = "This is a test title";
    public static final String TEST_CONTET = "This is a test title";
    public static final String TEST_TIMESTAMP = "08-2018";

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    /*
        Insert, read, delete
     */
    @Test
    public void insertReadDelete() throws Exception{

        Note note = new Note(TestUtil.TEST_NOTE_1);

        //insert
        getNoteDao().insertNote(note).blockingGet();

        //read
        LiveDataTestUtil<List<Note>> listLiveDataTestUtil = new LiveDataTestUtil<>();
        List<Note> insertedNotes = listLiveDataTestUtil.getValue(getNoteDao().getNotes());

        Assert.assertNotNull(insertedNotes);

        Assert.assertEquals(note.getContent(), insertedNotes.get(0).getContent());
        Assert.assertEquals(note.getTimestamp(), insertedNotes.get(0).getTimestamp());
        Assert.assertEquals(note.getTitle(), insertedNotes.get(0).getTitle());

        note.setId(insertedNotes.get(0).getId());
        Assert.assertEquals(note, insertedNotes.get(0));

        //delete
        getNoteDao().deleteNote(note).blockingGet();

        //confirm the database is empty
        insertedNotes = listLiveDataTestUtil.getValue(getNoteDao().getNotes());
        Assert.assertEquals(0, insertedNotes.size());

    }

    /*
        Insert, read, update, read, delete
     */

    @Test
    public void insertReadUpdateReadDelete() throws Exception{

        Note note = new Note(TestUtil.TEST_NOTE_1);

        //insert
        getNoteDao().insertNote(note).blockingGet();

        //read
        LiveDataTestUtil<List<Note>> listLiveDataTestUtil = new LiveDataTestUtil<>();
        List<Note> insertedNotes = listLiveDataTestUtil.getValue(getNoteDao().getNotes());

        Assert.assertNotNull(insertedNotes);

        Assert.assertEquals(note.getContent(), insertedNotes.get(0).getContent());
        Assert.assertEquals(note.getTimestamp(), insertedNotes.get(0).getTimestamp());
        Assert.assertEquals(note.getTitle(), insertedNotes.get(0).getTitle());

        note.setId(insertedNotes.get(0).getId());
        Assert.assertEquals(note, insertedNotes.get(0));

        //update
        note.setTitle(TEST_TITLE);
        note.setContent(TEST_CONTET);
        note.setTimestamp(TEST_TIMESTAMP);
        getNoteDao().updateNote(note).blockingGet();

        //read
        insertedNotes = listLiveDataTestUtil.getValue(getNoteDao().getNotes());

        Assert.assertEquals(TEST_TITLE, insertedNotes.get(0).getTitle());
        Assert.assertEquals(TEST_CONTET, insertedNotes.get(0).getContent());
        Assert.assertEquals(TEST_TIMESTAMP, insertedNotes.get(0).getTimestamp());

        note.setId(insertedNotes.get(0).getId());
        Assert.assertEquals(note, insertedNotes.get(0));

        //delete
        getNoteDao().deleteNote(note).blockingGet();

        //confirm the database is empty
        insertedNotes = listLiveDataTestUtil.getValue(getNoteDao().getNotes());
        Assert.assertEquals(0, insertedNotes.size());

    }

    /*
        Insert note with null title, throw exception
     */
    @Test(expected = SQLiteConstraintException.class)
    public void insert_nullTitle_throwSQLiteConstraintException() throws Exception{

        final Note note = new Note(TestUtil.TEST_NOTE_1);
        note.setTitle(null);

        getNoteDao().insertNote(note).blockingGet();

    }

    /*
        Insert, update with null title, throw exception
     */
    @Test(expected = SQLiteConstraintException.class)
    public void update_nullTitle_throwSQLiteConstraintException() throws Exception{

        Note note = new Note(TestUtil.TEST_NOTE_1);

        //insert
        getNoteDao().insertNote(note).blockingGet();

        //read
        LiveDataTestUtil<List<Note>> listLiveDataTestUtil = new LiveDataTestUtil<>();
        List<Note> insertedNotes = listLiveDataTestUtil.getValue(getNoteDao().getNotes());
        Assert.assertNotNull(insertedNotes);

        //update
        note = new Note(insertedNotes.get(0));
        note.setTitle(null);
        getNoteDao().updateNote(note).blockingGet();

    }

}
