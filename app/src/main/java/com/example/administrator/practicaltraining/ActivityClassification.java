package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/22.
 */
public class ActivityClassification extends Activity {
    public TextView teacher;
    public TextView server;
    public TextView life1;
    public TextView xuanch;
    public TextView longpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_classification);

        findViewById(R.id.aaaaa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(ActivityClassification.this,baidumap.class);
                startActivity(i);
            }
        });

        final RelativeLayout hometeacher = (RelativeLayout)findViewById(R.id.id_classification_hometeacher);
         teacher=(TextView)findViewById(R.id.teacher);
        hometeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityClassification.this,ActivityHometeacher.class);
                Bundle bundle=new Bundle();
                String teac=teacher.getText().toString();
                bundle.putString("name",teac);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        RelativeLayout service = (RelativeLayout)findViewById(R.id.id_classification_service);
        server=(TextView)findViewById(R.id.server);
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityClassification.this,ActivityHometeacher.class);
                Bundle bundle=new Bundle();
                String service=server.getText().toString();
                bundle.putString("name",service);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        RelativeLayout life = (RelativeLayout)findViewById(R.id.id_classification_life);
        life1=(TextView)findViewById(R.id.life);
        life.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityClassification.this,ActivityHometeacher.class);
                Bundle bundle=new Bundle();
                String life2=life1.getText().toString();
                bundle.putString("name",life2);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        RelativeLayout propaganda = (RelativeLayout)findViewById(R.id.id_classification_propaganda);
        xuanch=(TextView)findViewById(R.id.xuanch);
        propaganda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityClassification.this,ActivityHometeacher.class);
                Bundle bundle=new Bundle();
                String xuanchuan=xuanch.getText().toString();
                bundle.putString("name",xuanchuan);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        RelativeLayout longtame = (RelativeLayout)findViewById(R.id.id_classification_longtame);
        longpt=(TextView)findViewById(R.id.longparttime);
        longtame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityClassification.this,ActivityHometeacher.class);
                Bundle bundle=new Bundle();
                String longtime=longpt.getText().toString();
                bundle.putString("name",longtime);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
