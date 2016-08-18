package com.example.mfawzy.xogame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    String player1="player1" , player2="player2";
    String size="3";
    EditText text1;
    EditText text2 ;
    EditText text3 ;

    Intent myIntent ;
    Bundle myBundle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (EditText) findViewById(R.id.editText);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        myIntent = new Intent(this , Main2Activity.class);
        myBundle = new Bundle();
    }


    public void playBtn(View view) {
        player1 = text1.getText().toString();
        player2 = text2.getText().toString();
        size = text3.getText().toString();

        myBundle.putString("player1" , player1);
        myBundle.putString("player2" , player2);
        myBundle.putString("size" , size);
        myIntent.putExtras(myBundle);
        startActivity(myIntent);

    }
}
