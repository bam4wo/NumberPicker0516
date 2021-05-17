package com.bam.numberpicker0516;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class DateDialog extends AlertDialog implements DialogInterface.OnClickListener {

    private PickerFragment pickerFragment;
    private Calendar calendar = Calendar.getInstance();
    int Year, Month, Day;
    private OnDateTimeSetListener mOnDateTimeSetListener;
    Button ok, cancel;
    TextView textView;
    private String datetimeStr;

    public DateDialog(Context context, long date) {
        super(context);
        pickerFragment = new PickerFragment(context);
        setView(pickerFragment);

        pickerFragment.setOnDateTimeChangedListener(new PickerFragment.OnDateTimeChangedListener() {
            @Override
            public void onDateTimeChanged(PickerFragment view, int year, int month, int day) {
                Year = year;
                Month = month;
                Day = day;
            }
        });
        Year = calendar.get(Calendar.YEAR);
        Month = calendar.get(Calendar.MONTH) + 1;
        Day = calendar.get(Calendar.DAY_OF_MONTH);

    }



    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }

    public interface OnDateTimeSetListener {
        void OnDateTimeSet(DialogInterface dialog, String datetimestr);
    }


    public void setOnDateTimeSetListener(OnDateTimeSetListener callBack) {
        mOnDateTimeSetListener = callBack;
    }
}
