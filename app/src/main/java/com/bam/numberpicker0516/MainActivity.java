package com.bam.numberpicker0516;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    //DateDialog myDialog;
    Button ok,cancel;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        //button.setOnClickListener(this::onclick);
        textView = findViewById(R.id.textView);
    }

    public void onclick(View view){
        DateDialog myDialog = new DateDialog(this, System.currentTimeMillis());
        myDialog.show();
        myDialog.setOnDateTimeSetListener(new DateDialog.OnDateTimeSetListener() {
            @Override
            public void OnDateTimeSet(DialogInterface dialog, String datetimestr) {
                textView.setText(datetimestr);
            }
        });
        //getDialog();
    }
/*
    private void getDialog(){
        myDialog = new DateDialog(MainActivity.this,System.currentTimeMillis());
        view = getLayoutInflater().inflate(R.layout.fragment_test, null);
        myDialog.setContentView(view);
        ok = view.findViewById(R.id.button4);
        cancel = view.findViewById(R.id.button3);
        myDialog.show();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.showdate();
                myDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
    }*/



}