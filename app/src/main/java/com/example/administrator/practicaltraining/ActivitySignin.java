package com.example.administrator.practicaltraining;

import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class ActivitySignin extends AppCompatActivity {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_signin);
        DatePicker datePicker=(DatePicker)findViewById(R.id.datePicker);
      //  TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
        //获取当前的年月日小时分钟
        Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);
        hour=c.get(Calendar.HOUR);
        minute=c.get(Calendar.MINUTE);
        //初始化DatePicker组件，初始化时指定监听器
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker arg0, int year, int month, int day) {
                ActivitySignin.this.year=year;
                ActivitySignin.this.month=month;
                ActivitySignin.this.day=day;
                //显示当前日期，时间
                showDate(year,month,day,hour,minute);
            }
        });
        //为TimePicker指定监听器
        /*timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker arg0, int hour, int minute) {
                ActivitySignin.this.hour=hour;
                ActivitySignin.this.minute=minute;
                //显示当前日期，时间
                showDate(year,month,day,hour,minute);
            }
        });*/
    }
    //定义在EditText中显示当前日期时间的方法
    private void showDate(int year ,int month ,int day,int hour ,int minute ){
        EditText show=(EditText)findViewById(R.id.show);
        show.setText("您的签到时间是："+year+"年"+(month+1)+"月"+day+"日"+hour+"时"+minute+"分");
    }
    }

