package com.example.customizedadapter;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends ArrayAdapter<Question> {
    ArrayList<String> selectedAnswers;
    public MyAdapter(@NonNull Context context,  ArrayList<Question> questionArrayList) {
        super(context, 0, questionArrayList);
        selectedAnswers=new ArrayList<>();
        for(int i=0;i<questionArrayList.size();i++){
            selectedAnswers.add(null);
        }
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView=LayoutInflater.from(getContext()).inflate(R.layout.questionview,parent,false);

        Question q =getItem(position);

        TextView question = convertView.findViewById(R.id.question);
        RadioGroup radioGroup=convertView.findViewById(R.id.options);
        RadioButton radioButtons[]=new RadioButton[3];
        radioButtons[0]=convertView.findViewById(R.id.a);
        radioButtons[1]=convertView.findViewById(R.id.b);
        radioButtons[2]=convertView.findViewById(R.id.c);
        question.setText(q.getQuestion());
        int randomNmbr = (int) (Math.floor(Math.random() * 3));
        radioButtons[randomNmbr].setText(q.getCorrectOption());
        int optionIterator = 0;
        for (int i = 0; i < 3; i++) {
            if (i != randomNmbr) {
                radioButtons[i].setText(q.getOptions()[optionIterator]);
                optionIterator++;
            }
        }
        View finalConvertView = convertView;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id=radioGroup.getCheckedRadioButtonId();
                System.out.println("id: "+id +"position: "+position);
                if(id!=-1){
                    RadioButton radioButton= finalConvertView.findViewById(id);
                    selectedAnswers.set(position,radioButton.getText().toString());
                    System.out.println(radioButton.getText().toString());
                }
            }
        });

        return convertView;
    }
}
