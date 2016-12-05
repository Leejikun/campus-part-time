package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/11/30.
 */

public class ActivityPublish extends Activity {
    public ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publishparttime);
        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
