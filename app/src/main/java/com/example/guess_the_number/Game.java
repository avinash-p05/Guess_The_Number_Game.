package com.example.guess_the_number;

import static com.example.guess_the_number.R.id.button4;

import static com.example.guess_the_number.R.id.button6;
import static com.example.guess_the_number.R.id.editTextNumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Game extends AppCompatActivity {
    Button b4,b5;
    EditText e;
    TextView t;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_game);
        b4=findViewById(button4);
        b5=findViewById(button6);
        e=findViewById(editTextNumber);
        t=findViewById(R.id.textView3);
        int a = getIntent().getIntExtra("lower",1);
        int b = getIntent().getIntExtra("upper",100);
        Random random = new Random();
        int minRange = a;  // Minimum number in the range
        int maxRange = b;  // Maximum number in the range
        int Number = random.nextInt(maxRange - minRange + 1) + minRange;

        final int[] attempts = new int[1];
        attempts[0]=0;
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempts[0] =check(Number,attempts[0]);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
            }
        });



    }
    public int check(int Number,int attempts){
        String s = e.getText().toString();
        if(s.isEmpty()){
            Toast.makeText(this, "Please Enter your Guess!!", Toast.LENGTH_SHORT).show();
            return 0;
        }
        int a = Integer.parseInt(s);
        if (a==Number){
            attempts++;
            at(attempts);
            String g = (String) t.getText();
            Intent intent = new Intent(this,winner.class);
            intent.putExtra("at",g);
            startActivity(intent);
            return attempts;
        }
        else if(a<Number){
            if(Number-a<= 10){
                Toast.makeText(this, "You are close, Try a bit Higher!!", Toast.LENGTH_SHORT).show();
                attempts++;
                at(attempts);
                return attempts;

            }
            else{
                Toast.makeText(this, "Try a Higher Number!!", Toast.LENGTH_SHORT).show();
                attempts++;
                at(attempts);
                return attempts;
            }
        }
        else if(a>Number){
            if(a-Number <= 10){
                Toast.makeText(this, "You are close, Try a bit Lower!!", Toast.LENGTH_SHORT).show();
                attempts++;
                at(attempts);
                return attempts;
            }
            else{
                Toast.makeText(this, "Try a Lower Number!!", Toast.LENGTH_SHORT).show();
                attempts++;
                at(attempts);
                return attempts;
            }
        }
        return 0;


    }
    public void at(int n){
        t.setText("Attempts taken - "+n);

    }
    public void restart(){
        Intent intent = new Intent(this,Game.class);
        startActivity(intent);
    }

}