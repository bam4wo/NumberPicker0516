package com.bam.numberpicker0516;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
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
    }


}