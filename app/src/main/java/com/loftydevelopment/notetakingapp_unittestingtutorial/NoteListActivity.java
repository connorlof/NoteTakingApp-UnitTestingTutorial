package com.loftydevelopment.notetakingapp_unittestingtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NoteListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
    }
}