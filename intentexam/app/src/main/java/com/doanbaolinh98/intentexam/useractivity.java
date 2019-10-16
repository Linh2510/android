package com.doanbaolinh98.intentexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class useractivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useractivity);
        Intent intent = getIntent();
        String usernameStr = intent.getStringExtra("username");
        TextView usernameTV = findViewById(R.id.usernameET);
        usernameTV.setText(usernameStr);
    }

    public void backbtnOnclick(View view) {
        EditText ageEt = findViewById(R.id.ageET);
        EditText mailEt = findViewById(R.id.emailET);
        Intent dataIntent = new Intent();
        dataIntent.putExtra("userAge",ageEt.getText().toString());
        dataIntent.putExtra("usermail",mailEt.getText().toString());
        setResult(Activity.RESULT_OK,dataIntent);
        finish();

    }
}
