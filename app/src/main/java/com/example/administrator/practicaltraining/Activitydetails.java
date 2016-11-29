package com.example.administrator.practicaltraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activitydetails extends AppCompatActivity {
    public TextView workName;
    public TextView workTime;
    public TextView workPlace;
    public TextView workNeed;
    public TextView workDescribe;
    public TextView howPay;
    public TextView howPay1;
    public TextView workRelease;
    public TextView have;
    public TextView wages;
    public TextView allNeed;
    public Button join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_details);
        setView();
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        // int image = bundle.getInt("image");
        String title = bundle.getString("title");
        String info = bundle.getString("info");
        String address = bundle.getString("address");
        String worktime = bundle.getString("workTime");
        String howpay = bundle.getString("howPay");
        String wages1 = bundle.getString("wages");

        //image2.setBackgroundResource(image);
        workName.setText(title);
        workDescribe.setText(title);
        workTime.setText(worktime);
        howPay.setText(howpay);
        howPay1.setText(howpay);
        wages.setText(wages1);
        workPlace.setText(address);
        workRelease.setText(info);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activitydetails.this,"您已报名",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void setView(){
        workName =(TextView) findViewById(R.id.workName);
        workTime =(TextView) findViewById(R.id.workTime);
        workPlace =(TextView) findViewById(R.id.workPlace);
        workNeed =(TextView) findViewById(R.id.workNeed);
        workDescribe =(TextView) findViewById(R.id.workDescribe);
        howPay =(TextView) findViewById(R.id.howPay);
        howPay1 =(TextView) findViewById(R.id.howPay1);
        wages =(TextView) findViewById(R.id.wages);
        allNeed =(TextView) findViewById(R.id.allNeed);
        workRelease =(TextView) findViewById(R.id.workRelease);
        join=(Button)findViewById(R.id.join);
    }

}
