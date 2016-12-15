package com.example.administrator.practicaltraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activitydetails extends AppCompatActivity {
    public ImageView back;
    public TextView workName;
    public TextView workTime;
    public TextView workPlace;
    public TextView workNeed;
    public TextView workDescribe;
    public TextView howPay;
    public TextView howPay1;
    public TextView dowhat;
    public TextView wages;
    public TextView allNeed;
    public TextView stoptime;
    public TextView company;
    public TextView phone;
    private Button sign_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_details);
        setView();
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String title = bundle.getString("title");
        String info = bundle.getString("info");
        String address = bundle.getString("address");
        String worktime = bundle.getString("workTime");
        String howpay = bundle.getString("howPay");
        String wages1 = bundle.getString("wages");

        workName.setText(title);
        workDescribe.setText(title);
        workTime.setText(worktime);
        howPay.setText(howpay);
        howPay1.setText(howpay);
        wages.setText(wages1);
        workPlace.setText(address);
        company.setText(info);
        sign_button = (Button)findViewById(R.id.sign);
        sign_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Activitydetails.this,ActivitySign.class);
                startActivity(intent);
            }
        });
        //返回上一页
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public void setView(){
        back=(ImageView)findViewById(R.id.back);

        workName =(TextView) findViewById(R.id.workName);
        allNeed =(TextView) findViewById(R.id.allNeed);
        howPay1 =(TextView) findViewById(R.id.howPay1);
        howPay =(TextView) findViewById(R.id.howPay);
        wages =(TextView) findViewById(R.id.wages);
        workTime =(TextView) findViewById(R.id.workTime);
        workPlace =(TextView) findViewById(R.id.workPlace);
        workNeed =(TextView) findViewById(R.id.workNeed);
        workDescribe =(TextView) findViewById(R.id.workDescribe);
        stoptime=(TextView)findViewById(R.id.stopTime);
        company=(TextView) findViewById(R.id.company);
        phone=(TextView)findViewById(R.id.phone);

    }

}
