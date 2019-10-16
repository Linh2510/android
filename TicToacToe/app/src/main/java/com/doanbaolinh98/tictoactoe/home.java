package com.doanbaolinh98.tictoactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btnNewGame = findViewById(R.id.btnnewgame);
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenNewGame = new Intent(home.this, MainActivity.class);
                startActivity(intenNewGame);
            }
        });
        Button btnQuit=findViewById(R.id.btnquit);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome= new Intent(Intent.ACTION_MAIN);
                intentHome.addCategory( Intent.CATEGORY_HOME );
                intentHome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentHome);

            }
        });

    }
}
