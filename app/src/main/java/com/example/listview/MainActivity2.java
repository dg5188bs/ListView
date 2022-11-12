package com.example.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.math.BigDecimal;


public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView Lv;
    TextView tv1, tv2, tv3, tv4;
    String[] arr = new String[20];
    Double[] sumArray = new Double[20];
    Double first;
    Double multiplier;
    int type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv1 = (TextView) findViewById(R.id.textView5);
        tv2 = (TextView) findViewById(R.id.textView6);
        tv3 = (TextView) findViewById(R.id.textView7);
        tv4 = (TextView) findViewById(R.id.textView8);
        Lv = (ListView) findViewById(R.id.list);
        Intent gi = getIntent();
        first = gi.getDoubleExtra("first", -99999);
        multiplier = gi.getDoubleExtra("multiplier", -99999);
        type = gi.getIntExtra("type", -99999);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arr);
        Lv.setOnItemClickListener(this);
        Lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        Lv.setAdapter(adp);
        int check = e(Double.toString(first));
        String str = String.format("%.02f", first);
        if(check>2) {
            tv1.setText(str + "E" + Integer.toString(check - 2));
        }
        else {
            tv1.setText(str);
        }
        int check2 = e(Double.toString(multiplier));
        String str2 = String.format("%.02f",multiplier);
        if(check2>2) {
            tv2.setText(str2 + "E" + Integer.toString(check2 - 2));
        }
        else {
            tv2.setText(str2);
        }


        if (type == 0) {
            Mathemtical();
        } else {
            Geometrical();
        }
    }

    public int e (String str){
        int s = str.indexOf(".");
        int e = str.indexOf("E");
        if(e==-1) {
            return (str.substring(s + 1)).length();
        }
        else{
            return (str.substring(s+1)).length()+Integer.parseInt(str.substring(e+1));
        }
    }
    public void Mathemtical() {
        for (int i = 0; i < 20; i++) {
            sumArray[i] = first;
            int check = e(Double.toString(first));
            String str = String.format("%.02f", first);
            if(check>2) {
                arr[i] = str + "E" + Integer.toString(check - 2);
            }
            else {
                arr[i] = str;
            }
            first = first+multiplier;
        }
    }

    public void Geometrical() {
        for (int i = 0; i < 20; i++) {
            sumArray[i] = first;
            int check = e(Double.toString(first));
            String str = String.format("%.02f", first);
            if(check>2) {
                arr[i] = str + "E" + Integer.toString(check - 2);
            }
                else {
                    arr[i] = str;
                }
            first = first*multiplier;
        }
    }





    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Double sum=0.0;
        tv3.setText(Integer.toString(i+1));
        for(int k=0;k<i+1;k++){
            sum = sum+sumArray[k];
        }
        int check = e(Double.toString(sum));
        String str = String.format("%.02f", sum);
        if(check>2) {
            tv4.setText(str + "E" + Integer.toString(check - 2));
        }
        else {
            tv4.setText(str);
        }
    }

    public void back(View view) {
        finish();
    }

}


