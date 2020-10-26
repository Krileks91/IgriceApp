package com.example.igrice.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.igrice.R;


public class EditActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        String data = getIntent().getExtras().getString("Item", "");

        super.onCreate(savedInstanceState);
        if (data.equals("Igre")) {
            setContentView(R.layout.activity_edit);
        } else {
            setContentView(R.layout.activity_edit_kategorija);
        }
    }


}