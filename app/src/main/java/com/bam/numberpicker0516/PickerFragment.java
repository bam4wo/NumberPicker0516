package com.bam.numberpicker0516;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Calendar;

public class PickerFragment extends FrameLayout {

    private NumberPicker yearPicker;
    private NumberPicker monthPicker;
    private NumberPicker dayPicker;
    private Calendar calendar;
    TextView textView;
    int year = 1960;
    int month = 1;
    int day = 1;
    String years = String.valueOf(year);
    String mon = String.valueOf(month);
    String date = String.valueOf(day);


    public PickerFragment(@NonNull Context context) {
        super(context);
        calendar = Calendar.getInstance();
        inflate(context,R.layout.fragment_test,this);
        textView = findViewById(R.id.textView);

        //年份
        yearPicker = findViewById(R.id.np_year);
        yearPicker.setMaxValue(10000);
        yearPicker.setMinValue(1900);
        yearPicker.setValue(1960);
        yearPicker.setOnValueChangedListener(onYearChangeListener);


        //月份
        monthPicker = findViewById(R.id.np_month);
        monthPicker.setMaxValue(12);
        monthPicker.setMinValue(1);
        monthPicker.setValue(1);
        monthPicker.setOnValueChangedListener(onMonthChangeListener);

        //日期
        dayPicker = findViewById(R.id.np_day);
        dayPicker.setMaxValue(31);
        dayPicker.setMinValue(1);
        dayPicker.setValue(1);
        dayPicker.setOnValueChangedListener(onDayChangeListener);

    }

    private NumberPicker.OnValueChangeListener onYearChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
            year = newVal;
        }
    };

    private NumberPicker.OnValueChangeListener onMonthChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
            month = newVal;
        }
    };

    private NumberPicker.OnValueChangeListener onDayChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
            day = newVal;
        }
    };

}
