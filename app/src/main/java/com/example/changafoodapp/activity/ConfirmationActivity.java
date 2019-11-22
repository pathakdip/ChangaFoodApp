package com.example.changafoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.changafoodapp.R;

public class ConfirmationActivity extends AppCompatActivity {
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_confirmation);

        imgBack=findViewById(R.id.imgBack);



    }
}
