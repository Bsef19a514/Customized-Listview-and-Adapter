package com.example.customizedadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button button;
ListView listView;
RadioGroup radioGroup;
ArrayList<Question> questionList=new ArrayList<>();
MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);

        questionList.add(new Question("Q1. In which HTML tag do we put the JS code?","script tag",new String[]{"link tag","js tag"}));
        questionList.add(new Question("Q2. Which object is in the top of the root of JavaScript?","window",new String[]{"document","URL"}));
        questionList.add(new Question("Q3. DOM is ??","describes the structure of HTML or XML document",new String[]{"dedicated for Js","a template engine"}));
        questionList.add(new Question("Q4. Which event do you use to perform something after the page has finished loading?","onload",new String[]{"onfinished","oncomplete"}));
        questionList.add(new Question("Q5. Which of the following is not a property of window object?","menu",new String[]{"history","navigator"}));
        questionList.add(new Question("Q6. Which of the following is not a valid mouse event?","onmousescroller",new String[]{"onmouseover","onmousemove"}));
        listView = (ListView) findViewById(R.id.listView);
        adapter=new MyAdapter(this, questionList);
        listView.setAdapter(adapter);
    }
    public void submitQuiz(View view) {
        int score=0;
        ArrayList<String> selectedAnswers=adapter.selectedAnswers;
        for(int i=0;i<questionList.size();i++){
            if(questionList.get(i).getCorrectOption().equals(selectedAnswers.get(i))){
                score++;
            }
        }
        System.out.println("Score is: "+score);
        Intent intent =new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("Score",score);
        startActivity(intent);
        finish();
    }

}