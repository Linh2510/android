package com.doanbaolinh98.bignumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View view) {
        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        int num1 = Integer.parseInt(btn1.getText().toString());
        int num2 = Integer.parseInt(btn2.getText().toString());
        if(view.getId()==R.id.button1){
            if (num1 >= num2 ){
                points++;
                Toast.makeText(this, "Right Answer",Toast.LENGTH_SHORT).show();}
            else {
                points--;
                Toast.makeText(this, "False Answer",Toast.LENGTH_SHORT).show();
            }

        }
        else {
            if (num1 < num2 ){
                points++;
                Toast.makeText(this, "Right Answer",Toast.LENGTH_SHORT).show();}
            else {
                points--;
                Toast.makeText(this, "False Answer",Toast.LENGTH_SHORT).show();
            }
        }
        TextView pointview = findViewById(R.id.pointTV);
        pointview.setText("Points: "+ points);
        generateRandom();


    }
//
//    public void onButton1Click(View view) {
//        Button btn1 = findViewById(R.id.button1);
//        Button btn2 = findViewById(R.id.button2);
//        int num1 = Integer.parseInt(btn1.getText().toString());
//        int num2 = Integer.parseInt(btn2.getText().toString());
//        if (num1 >= num2 )
//            points++;
//        else points--;
//        TextView pointview = findViewById(R.id.pointTV);
//        pointview.setText("Points: "+ points);
//        generateRandom();
//    }
//
//    public void onButton2Click(View view) {
//        Button btn1 = findViewById(R.id.button1);
//        Button btn2 = findViewById(R.id.button2);
//        int num1 = Integer.parseInt(btn1.getText().toString());
//        int num2 = Integer.parseInt(btn2.getText().toString());
//        if (num1 < num2 )
//            points++;
//        else points--;
//        TextView pointview = findViewById(R.id.pointTV);
//        pointview.setText("Points: "+ points);
//        generateRandom();
//    }
    private void generateRandom(){
        int num1 = new Random().nextInt(100);
        int num2 = new Random().nextInt(100);
        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        btn1.setText(String.valueOf(num1));
        btn2.setText(String.valueOf(num2));

    }
}
