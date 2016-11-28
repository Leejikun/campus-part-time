package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/11/22.
 */
public class ActivityClassification extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_classification);

        RelativeLayout hometeacher = (RelativeLayout)findViewById(R.id.id_classification_hometeacher);
        hometeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityClassification.this,ActivityHometeacher.class);
                startActivity(intent);
            }
        });
        RelativeLayout service = (RelativeLayout)findViewById(R.id.id_classification_service);
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityClassification.this,ActivityHometeacher.class);
                startActivity(intent);
            }
        });
        RelativeLayout life = (RelativeLayout)findViewById(R.id.id_classification_life);
        life.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityClassification.this,ActivityHometeacher.class);
                startActivity(intent);
            }
        });
        RelativeLayout propaganda = (RelativeLayout)findViewById(R.id.id_classification_propaganda);
        propaganda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityClassification.this,ActivityHometeacher.class);
                startActivity(intent);
            }
        });
        RelativeLayout longtame = (RelativeLayout)findViewById(R.id.id_classification_longtame);
        longtame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityClassification.this,ActivityHometeacher.class);
                startActivity(intent);
            }
        });
    }
}
