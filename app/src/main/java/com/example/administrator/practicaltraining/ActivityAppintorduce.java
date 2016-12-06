package com.example.administrator.practicaltraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View;
import android.widget.ImageView;

public class ActivityAppintorduce extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appintorduce);

        findViewById(R.id.wm_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setContentView(R.layout.activity_activity_appintorduce);
        imageView=(ImageView)findViewById(R.id.fk_back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ActivityAppintorduce.this,ActivityMyself.class);
                startActivity(intent);
            }
        });
    }
}
