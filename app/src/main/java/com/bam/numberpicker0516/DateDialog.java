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
    Button confirm, cancel;
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
        /*
        setButton(DialogInterface.BUTTON_POSITIVE,"确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                datetimeStr = Year +"-"+ Month +"-"+ Day ;
                if (mOnDateTimeSetListener != null) {
                    mOnDateTimeSetListener.OnDateTimeSet(dialog, datetimeStr);
                }
            }
        });
        setButton(DialogInterface.BUTTON_NEGATIVE,"取消", (OnClickListener) null);
        setCanceledOnTouchOutside(false);//点击对话框外无法关闭对话框*/



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
