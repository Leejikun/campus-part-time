package com.example.administrator.practicaltraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/11/29.
 */

public class ActivitySign extends AppCompatActivity {
    public ImageView back;
    private Button button;
    private EditText editText;
    private EditText editText1;
    private EditText editText2;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setView();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button button=(Button)findViewById(R.id.id_btn);
        editText=(EditText)findViewById(R.id.truename) ;
        editText1=(EditText)findViewById(R.id.year) ;
        editText2=(EditText)findViewById(R.id.mymoblenumber);
        final String txt=editText.getText().toString();
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txt.length() == 0) {
                    Toast.makeText(ActivitySign.this, "请输入真实姓名", Toast.LENGTH_LONG).show();
                }else
                {
                    Intent intent = new Intent();
                    intent.setClass(ActivitySign.this, Activityinformsuccessful.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void setView() {
        back = (ImageView) findViewById(R.id.back);
    }
}

