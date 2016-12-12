package com.example.administrator.practicaltraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/11/29.
 */

public class ActivitySign extends AppCompatActivity {
    public ImageView back;
    private Button button;
    public  RadioButton man;
    public  RadioButton woman;
    public  RadioButton student;
    public  RadioButton notstudent;
    public TextView mymoblenumber;
    private EditText editText;
    private EditText birthday;

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


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(editText.getText().length() == 0 ){
                    Toast.makeText(ActivitySign.this, "请填写真实姓名", Toast.LENGTH_LONG).show();
                }else if(!(man.isChecked() || woman.isChecked())) {
                    Toast.makeText(ActivitySign.this, "请选择性别", Toast.LENGTH_LONG).show();
                }else if( birthday.getText().length()==0){
                    Toast.makeText(ActivitySign.this, "请填写年龄", Toast.LENGTH_LONG).show();
                }else if (!(student.isChecked() || notstudent.isChecked())){
                    Toast.makeText(ActivitySign.this, "请选择身份", Toast.LENGTH_LONG).show();
                }else if( mymoblenumber.getText().length()!=11 ){
                    Toast.makeText(ActivitySign.this, "请填写真实手机号", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent();
                    intent.setClass(ActivitySign.this, Activityinformsuccessful.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void setView() {
        back = (ImageView) findViewById(R.id.back);
        man=(RadioButton)findViewById(R.id.id_radio1);
        woman=(RadioButton)findViewById(R.id.id_radio2);
        student=(RadioButton)findViewById(R.id.id_radio3);
        notstudent=(RadioButton)findViewById(R.id.id_radio4);
        mymoblenumber=(EditText)findViewById(R.id.mymoblenumber);
        editText=(EditText)findViewById(R.id.truename) ;
        birthday=(EditText)findViewById(R.id.year) ;
        button=(Button)findViewById(R.id.id_btn);
    }
}

