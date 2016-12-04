package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/11/22.
 */
public class ActivityMessage extends Activity {
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        relativeLayout=(RelativeLayout)findViewById(R.id.layout_shake);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(ActivityMessage.this,ActivitySignin.class);
                startActivity(intent);
            }
        });
    }
}
