package com.example.administrator.practicaltraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class ActivityPersonal extends AppCompatActivity {
    private ImageView img_view;
    private TextView tex_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        img_view = (ImageView)findViewById(R.id.back);
        img_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ActivityPersonal.this, ActivityMyself.class);
                startActivity(intent);
            }
        });

        tex_view = (TextView)findViewById(R.id.text);
        tex_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ActivityPersonal.this, CaptureActivity.class);
                startActivity(intent);
            }
        });

    }
}
