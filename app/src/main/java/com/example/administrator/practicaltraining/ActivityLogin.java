package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;
import android.widget.TabHost;
import android.widget.Toast;

import com.baidu.platform.comapi.map.N;

public class ActivityLogin extends AppCompatActivity {
     private EditText editText;
       private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private Button button;
    private EditText editText4;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        button=(Button)findViewById(R.id.getpassword);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder AdBuilder = new AlertDialog.Builder(ActivityLogin.this);
                AdBuilder.setIcon(R.drawable.comemessage);
                AdBuilder.setTitle("温馨提示");
                editText4=(EditText)findViewById(R.id.moblenumber);
               String text=(editText4).getText().toString();
                if(text.length()!=11){
                    Toast.makeText(ActivityLogin.this,"请输入11位手机号",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(ActivityLogin.this,"输入合法",Toast.LENGTH_LONG).show();
                    AdBuilder.setMessage("您确定给您的手机号为"+text+"发短信？");
                    AdBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AdBuilder.setNegativeButton("取消", null);
                    AdBuilder.create();
                    AdBuilder.show();
                }


            }


        });
    }
}
