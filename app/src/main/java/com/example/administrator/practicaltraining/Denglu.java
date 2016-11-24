package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/11/22.
 */
public class Denglu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button denglubtn=(Button)findViewById(R.id.id_denglu_dlbtn);
        denglubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setClass(Denglu.this,Myself.class);
                startActivity(intent);
            }
        });
        Button zhucebtn=(Button)findViewById(R.id.id_denglu_zcbtn);
        zhucebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setClass(Denglu.this,Zhuce.class);
                startActivity(intent);
            }
        });
    }
}
