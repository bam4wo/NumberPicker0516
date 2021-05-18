package com.bam.numberpicker0516;

import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;

import java.util.Calendar;

public class PickerFragment extends FrameLayout {

    private final NumberPicker yearPicker;
    private final NumberPicker monthPicker;
    private final NumberPicker dayPicker;
    private Calendar calendar;
    int myear, mmonth, mday;
    Button button;
    private OnDateTimeChangedListener mOnDateTimeChangedListener;

    public PickerFragment(@NonNull Context context) {
        super(context);
        calendar = Calendar.getInstance();
        myear = calendar.get(Calendar.YEAR);
        mmonth = calendar.get(Calendar.MONTH);

        inflate(context,R.layout.fragment_test,this);
        button = findViewById(R.id.bt_confirm);

        //年份
        yearPicker = findViewById(R.id.np_year);
        yearPicker.setMaxValue(2100);
        yearPicker.setMinValue(1900);
        yearPicker.setValue(1960);
        yearPicker.setOnValueChangedListener(onYearChangeListener);


        //月份
        monthPicker = findViewById(R.id.np_month);
        monthPicker.setMaxValue(12);
        monthPicker.setMinValue(1);
        monthPicker.setValue(1);
        monthPicker.setFormatter(formatter);
        monthPicker.setOnValueChangedListener(onMonthChangeListener);


        //日期
        dayPicker = findViewById(R.id.np_day);
        judgeMonth();
        mday = calendar.get(Calendar.DAY_OF_MONTH);
        dayPicker.setValue(1);
        dayPicker.setFormatter(formatter);
        dayPicker.setOnValueChangedListener(onDayChangeListener);

    }

    private NumberPicker.OnValueChangeListener onYearChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
            myear = yearPicker.getValue();
            judgeYear();
            onDateTimeChanged();
        }
    };

    private NumberPicker.OnValueChangeListener onMonthChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
            mmonth = monthPicker.getValue();
            judgeMonth();
            onDateTimeChanged();
        }
    };

    private NumberPicker.OnValueChangeListener onDayChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
            mday = dayPicker.getValue();
            onDateTimeChanged();
        }
    };


    private NumberPicker.Formatter formatter = new NumberPicker.Formatter() {
        @Override
        public String format(int value) {
            String string = String.valueOf(value);
            if(value < 10){
                string = "0" + string;
            }
            return string;
        }
    };

    public interface OnDateTimeChangedListener {
        void onDateTimeChanged(PickerFragment view, int year, int month, int day);
    }

    public void setOnDateTimeChangedListener(OnDateTimeChangedListener callback) {
        mOnDateTimeChangedListener = callback;
    }

    private void onDateTimeChanged() {
        if (mOnDateTimeChangedListener != null) {
            mOnDateTimeChangedListener.onDateTimeChanged(this, myear, mmonth, mday);
        }
    }


    private void judgeYear() {
        if(mmonth == 2){
            if(myear%4 == 0){
                if(dayPicker.getMaxValue() != 29){
                    dayPicker.setDisplayedValues(null);
                    dayPicker.setMaxValue(29);
                    dayPicker.setMinValue(1);
                }
            }else {
                if(dayPicker.getMaxValue() != 28) {
                    dayPicker.setDisplayedValues(null);
                    dayPicker.setMaxValue(28);
                    dayPicker.setMinValue(1);
                }
            }
        }
        mday = dayPicker.getValue();
    }

    private void judgeMonth(){
        if(mmonth == 2){
            if(myear%4 == 0){
                if(dayPicker.getMaxValue() != 29){
                    dayPicker.setDisplayedValues(null);
                    dayPicker.setMaxValue(29);
                    dayPicker.setMinValue(1);
                }
            }else {
                if(dayPicker.getMaxValue() != 28) {
                    dayPicker.setDisplayedValues(null);
                    dayPicker.setMaxValue(28);
                    dayPicker.setMinValue(1);
                }
            }
        }else {
            switch (mmonth){
                case 4:
                case 6:
                case 9:
                case 11:
                    if(dayPicker.getMaxValue() != 30){
                        dayPicker.setDisplayedValues(null);
                        dayPicker.setMaxValue(30);
                        dayPicker.setMinValue(1);
                    }
                    break;
                default:
                    if(dayPicker.getMaxValue() != 31){
                        dayPicker.setDisplayedValues(null);
                        dayPicker.setMaxValue(31);
                        dayPicker.setMinValue(1);
                    }
            }
        }
        mday = dayPicker.getValue();
    }

}
