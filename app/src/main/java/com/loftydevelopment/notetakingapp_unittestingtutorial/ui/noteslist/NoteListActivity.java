package com.loftydevelopment.notetakingapp_unittestingtutorial.ui.noteslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.loftydevelopment.notetakingapp_unittestingtutorial.R;
import com.loftydevelopment.notetakingapp_unittestingtutorial.repository.NoteRepository;
import com.loftydevelopment.notetakingapp_unittestingtutorial.ui.note.NoteActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class NoteListActivity extends DaggerAppCompatActivity {

    private static final String TAG = "NoteListActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);


        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }
}
