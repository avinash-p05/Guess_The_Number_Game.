package com.example.guess_the_number;

import static com.example.guess_the_number.R.id.button;
import static com.example.guess_the_number.R.id.button2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class start_game extends AppCompatActivity {
        Button b2;
        EditText n1,n2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_start_game);
        b2=findViewById(button);
        n1=findViewById(R.id.editTextNumber2);
        n2=findViewById(R.id.editTextNumber3);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
            }
        });

    }
    public void start(){
        String s1=n1.getText().toString();
        String s2=n2.getText().toString();
        if(s1.isEmpty() ){
            Toast.makeText(this, "Please Enter the Lower range!!", Toast.LENGTH_SHORT).show();
        }
        else if(s2.isEmpty()){
            Toast.makeText(this, "Please Enter the Upper range!!", Toast.LENGTH_SHORT).show();
        }
        else {
            int a = Integer.parseInt(s1);
            int b = Integer.parseInt(s2);
            if(a<0){
                Toast.makeText(this, "Lower range should be positive!!", Toast.LENGTH_SHORT).show();
            }
            else if(b>999){
                Toast.makeText(this, "Upper range should be less than 1000 !!", Toast.LENGTH_SHORT).show();
            }
            else if(a>b){
                Toast.makeText(this, "Lower range cannot be greater than Upper range!!", Toast.LENGTH_SHORT).show();
            }
            else if(a==b){
                Toast.makeText(this, "Both ranges cannot be same!!", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(this, Game.class);
                intent.putExtra("lower", a);
                intent.putExtra("upper", b);
                startActivity(intent);

            }
        }
    }

}