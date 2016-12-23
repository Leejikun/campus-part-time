package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


/**
 * Created by Administrator on 2016/12/13.
 */

public class ActivityResume extends Activity {
    private ImageView img_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        img_view = (ImageView) findViewById(R.id.back);
        img_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
