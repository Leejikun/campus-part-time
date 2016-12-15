package com.example.administrator.practicaltraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityEntrylist extends AppCompatActivity {
    public ImageView back;
    public TextView workName;
    public TextView workTime;
    public TextView workPlace;
    public TextView workNeed;
    public TextView workDescribe;
    public TextView howPay;
    public TextView howPay1;

    public TextView have;
    public TextView wages;
    public TextView allNeed;
    public TextView company;
    private Button sign_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrylist);
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
        company.setText(info);
        sign_button = (Button)findViewById(R.id.sign);
        sign_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityEntrylist.this,ActivitySign.class);
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
        workTime =(TextView) findViewById(R.id.workTime);
        workPlace =(TextView) findViewById(R.id.workPlace);
        workNeed =(TextView) findViewById(R.id.workNeed);
        workDescribe =(TextView) findViewById(R.id.workDescribe);
        howPay =(TextView) findViewById(R.id.howPay);
        howPay1 =(TextView) findViewById(R.id.howPay1);
        wages =(TextView) findViewById(R.id.wages);
        company=(TextView) findViewById(R.id.company);
        allNeed =(TextView) findViewById(R.id.allNeed);
    }

}
