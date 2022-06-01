package com.example.customizedadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        int score=intent.getIntExtra("Score",0);
        TextView textView=findViewById(R.id.result);
        if(score>=4){
            textView.setText("Congo, you have passed the Quiz. You got "+score+" out of 6.");
        }else{
            textView.setText("Sorry, you could not make it. You got "+score+" out of 6.");
        }


    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}