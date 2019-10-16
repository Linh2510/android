package com.doanbaolinh98.tictoactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount;
    private int player1point;
    private int player2ponint;
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
        Button buttonReset = findViewById(R.id.btnReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //resetGame();
                Intent back = new Intent(MainActivity.this,home.class);
                startActivity(back);

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        if (player1Turn) {
            ((Button) view).setText("X");
        } else {
            ((Button) view).setText("O");
        }
        roundCount++;
        if( checkForWin()){
            if(player1Turn){
                player1Wins();
            }
            else player2Wins();
        }
        else  if (roundCount==9){
            draw();
        }
        else {
            player1Turn = !player1Turn;
        }

    }

    private boolean checkForWin() {
        String[][] filed = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                filed[i][j] = buttons[i][j].getText().toString();
            }
        }
        for( int i = 0 ; i < 3 ; i++){
            if(filed[i][0].equals(filed[i][1])&& filed[i][0].equals(filed[i][2]) && !filed[i][0].equals("")){
                return true;
            }
        }
        for( int i = 0 ; i < 3 ; i++){
            if(filed[0][i].equals(filed[1][i])&& filed[0][i].equals(filed[2][i]) && !filed[0][i].equals("")){
                return true;
            }
        }
        if(filed[0][0].equals(filed[1][1])&& filed[0][0].equals(filed[2][2]) && !filed[0][0].equals("")){
            return true;
        }
        if(filed[0][2].equals(filed[1][1])&& filed[0][2].equals(filed[2][0]) && !filed[0][2].equals("")){
            return true;
        }
        return false;
    }
    private void player1Wins(){
        player1point++;
        Toast.makeText(this, "Player 1 Win ",Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }
    private void player2Wins(){
        player2ponint++;
        Toast.makeText(this, "Player 2 Win ",Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }
    private void draw(){
        Toast.makeText(this, "Draw!",Toast.LENGTH_SHORT).show();
        resetBoard();
    }
    private void updatePointsText(){
        textViewPlayer1.setText("Player 1: "+player1point);
        textViewPlayer2.setText("Player2:"+ player2ponint);
    }
    private void resetBoard(){
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j ++){
                buttons[i][j].setText("");
            }
        }
        roundCount=0;
        player1Turn=true;
    }
    private void resetGame(){
        player1point=0;
        player2ponint=0;
        updatePointsText();
        resetBoard();
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("roundCount",roundCount);
        outState.putInt("player1point",player1point);
        outState.putInt("player2point",player2ponint);
        outState.putBoolean("player1turn",player1Turn);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        roundCount = savedInstanceState.getInt("roundCount");
        player1point= savedInstanceState.getInt("player1point");
        player2ponint= savedInstanceState.getInt("player2point");
        player1Turn= savedInstanceState.getBoolean("player1turn");
    }
}
