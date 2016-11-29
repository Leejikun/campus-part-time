package com.example.administrator.practicaltraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;

public class ActivityLogin extends AppCompatActivity {
     private EditText editText;
       private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_login);
        TabHost tab = (TabHost)findViewById(R.id.tabhost);
        tab.setup();  //初始化TabHost容器

        LayoutInflater i= LayoutInflater.from(this);
        i.inflate(R.layout.login_tab1, tab.getTabContentView());  //找到tab1布局，设置为Tab视图
        i.inflate(R.layout.login_tab2, tab.getTabContentView());  //找到tab2布局，设置为Tab视图

        tab.addTab(tab.newTabSpec("login_tab1").setIndicator("手机号登录").setContent(R.id.tab1));
        tab.addTab(tab.newTabSpec("login_tab2").setIndicator("密码登录").setContent(R.id.tab2));

        editText=(EditText)findViewById(R.id.moblenumber);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        editText1=(EditText)findViewById(R.id.sixnumber);
        editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText("");
            }
        });
        editText2=(EditText)findViewById(R.id.tab2moblenumber);
        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText2.setText("");
            }
        });
        editText3=(EditText)findViewById(R.id.tab2password);
        editText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText3.setText("");
            }
        });
    }


}
