package com.bam.numberpicker0516;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    private static final String TAG = MainActivity.class.getSimpleName();
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
        myDialog.select();

        /*內建button 資料印出的方法
        myDialog.setOnDateTimeSetListener(new DateDialog.OnDateTimeSetListener() {
            @Override
            public void OnDateTimeSet(DialogInterface dialog, String datetimestr) {
                textView.setText(datetimestr);
            }
        });*/
    }

}