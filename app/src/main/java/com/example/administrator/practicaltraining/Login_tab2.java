package com.example.administrator.practicaltraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

public class Login_tab2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_tab2);
        TextView textView = (TextView)findViewById(R.id.login_text_change_pwd);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Login_tab2.this,Resetpwd.class);
                startActivity(intent);

            }
        });
        TextView textView1 = (TextView)findViewById(R.id.login_btn_register);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Login_tab2.this,ActivityRegister.class);
                startActivity(intent);

            }
        });
    }
}
