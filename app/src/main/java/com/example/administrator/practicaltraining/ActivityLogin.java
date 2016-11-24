package com.example.administrator.practicaltraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_login);
        TabHost tab = (TabHost)findViewById(R.id.tabhost);
        tab.setup();  //初始化TabHost容器

        LayoutInflater i= LayoutInflater.from(this);
        i.inflate(R.layout.tab1, tab.getTabContentView());  //找到tab1布局，设置为Tab视图
        i.inflate(R.layout.tab2, tab.getTabContentView());  //找到tab2布局，设置为Tab视图

        tab.addTab(tab.newTabSpec("tab1").setIndicator("手机号登录").setContent(R.id.tab1));
        tab.addTab(tab.newTabSpec("tab2").setIndicator("密码登录").setContent(R.id.tab2));
    }
}
