package com.loftydevelopment.notetakingapp_unittestingtutorial.ui.noteslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.loftydevelopment.notetakingapp_unittestingtutorial.R;

import dagger.android.support.DaggerAppCompatActivity;

public class NoteListActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
    }
}
