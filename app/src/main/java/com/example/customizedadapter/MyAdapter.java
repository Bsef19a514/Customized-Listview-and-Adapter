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

    public MyAdapter(@NonNull Context context, int resource, @NonNull List<Question> objects) {
        super(context, resource, objects);
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView=LayoutInflater.from(getContext()).inflate(R.layout.questionview,parent,false);
        Question q =getItem(position);

        TextView question = convertView.findViewById(R.id.question);
        //RadioGroup radioGroup=convertView.findViewById(R.id.options);
        RadioButton a=convertView.findViewById(R.id.a);
        RadioButton b=convertView.findViewById(R.id.b);
        RadioButton c=convertView.findViewById(R.id.c);
        question.setText(q.getQuestion());
        a.setText(q.getCorrectOption());
        b.setText(q.getOptions()[0]);
        c.setText(q.getOptions()[1]);

        return convertView;
    }
}
