package com.example.guess_the_number;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class winner extends AppCompatActivity {
    Button b,b1;
    TextView t;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_winner);
        b=findViewById(R.id.button5);
        b1=findViewById(R.id.button7);
        t=findViewById(R.id.textView7);
        String at=getIntent().getStringExtra("at");
        t.setText(at);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                again();
            }
        });

    }
    public void again(){
        Intent intent = new Intent(this,start_game.class);
        startActivity(intent);
    }
}