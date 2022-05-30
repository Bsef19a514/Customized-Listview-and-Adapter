package com.example.customizedadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Question> arrayList=new ArrayList<>();
        arrayList.add(new Question("Q1. In which HTML tag do we put the JS code?","script tag",new String[]{"link tag","js tag"}));
        arrayList.add(new Question("Q2. Which object is in the top of the root of JavaScript?","window",new String[]{"document","URL"}));
        arrayList.add(new Question("Q3. DOM is ??","describes the structure of HTML or XML document",new String[]{"dedicated for Js","a template engine"}));
        arrayList.add(new Question("Q4. Which event do you use to perform something after the page has finished loading?","onload",new String[]{"onfinished","oncomplete"}));
        arrayList.add(new Question("Q5. Which of the following is not a property of window object?","menu",new String[]{"history","navigator"}));
        arrayList.add(new Question("Q6. Which of the following is not a valid mouse event?","onmousescroller",new String[]{"onmouseover","onmousemove"}));
        ListView listView = (ListView) findViewById(R.id.listView);
        MyAdapter adapter=new MyAdapter(this, R.layout.questionview, arrayList);
        listView.setAdapter(adapter);
    }
}