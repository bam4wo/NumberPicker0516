package com.bam.numberpicker0516;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import java.util.Calendar;

public class DateDialog extends AlertDialog implements DialogInterface.OnClickListener {

    private PickerFragment pickerFragment;
    private Calendar calendar;
    //private OnDateTimeSetListener mOnDateTimeSetListener;


    public DateDialog(Context context, long date) {
        super(context);
        pickerFragment = new PickerFragment(context);
        setView(pickerFragment);
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }
}
