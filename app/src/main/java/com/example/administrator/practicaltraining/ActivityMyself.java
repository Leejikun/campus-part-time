package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/22.
 */
public class ActivityMyself extends Activity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_myself);
        textView=(TextView)findViewById(R.id.TextView02);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ActivityMyself.this,ActivityLogin.class);
                startActivity(intent);
            }
        });

    }
}