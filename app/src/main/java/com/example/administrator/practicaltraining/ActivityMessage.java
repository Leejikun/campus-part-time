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
    private RelativeLayout relativeLayout1;
    private RelativeLayout relativeLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        relativeLayout = (RelativeLayout) findViewById(R.id.layout_shake);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityMessage.this, ActivitySignin.class);
                startActivity(intent);
            }
        });
        relativeLayout1 = (RelativeLayout) findViewById(R.id.layout_story);
      relativeLayout1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i= new Intent();
              i.setClass(ActivityMessage.this,ActivitySysteminforms.class);
              startActivity(i);

          }
      });
        relativeLayout2 = (RelativeLayout)findViewById(R.id.layout_activity);
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityMessage.this,ActivityClient.class);
                startActivity(intent);
            }
        });

    }
}