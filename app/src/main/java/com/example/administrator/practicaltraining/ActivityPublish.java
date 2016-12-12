package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import static cn.smssdk.SMSSDK.getSupportedCountries;
import static cn.smssdk.SMSSDK.getVerificationCode;
import static com.example.administrator.practicaltraining.R.id.bt_getCode;

/**
 * Created by Administrator on 2016/11/30.
 */

public class ActivityPublish extends Activity {
    public ImageView back;
    public EditText edt1;
    public EditText edt2;
    public EditText edt3;
    public EditText edt4;
    public RadioButton radio1;
    public RadioButton radio2;
    public RadioButton radio3;
    public RadioButton radio4;
    public RadioButton radio5;
    public RadioButton radio6;
    public RadioButton radio;
    public EditText money;
    public Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publishparttime);
        back = (ImageView)findViewById(R.id.back);
        edt1 = (EditText)findViewById(R.id.id_publish_worktime);
        edt2 = (EditText)findViewById(R.id.id_publish_workspace);
        edt3 = (EditText)findViewById(R.id.id_publish_number);
        edt4 = (EditText)findViewById(R.id.id_public_miaoshu);
        money = (EditText)findViewById(R.id.money) ;
        radio = (RadioButton)findViewById(R.id.id_radio);
        radio1 = (RadioButton)findViewById(R.id.id_radio1);
        radio2 = (RadioButton)findViewById(R.id.id_radio2);
        radio3 = (RadioButton)findViewById(R.id.id_radio3);
        radio4 = (RadioButton)findViewById(R.id.id_radio4);
        radio5 = (RadioButton)findViewById(R.id.id_radio5);
        radio6 = (RadioButton)findViewById(R.id.id_radio6);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn = (Button)findViewById(R.id.id_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String serch_text1 = edt1.getText().toString().trim();
                if (serch_text1.length() == 0){
                    Toast.makeText(ActivityPublish.this, "请输入工作时间", Toast.LENGTH_SHORT).show();
                }
                else{
                    String serch_text2 = edt2.getText().toString().trim();
                    if (serch_text2.length() ==0){
                        Toast.makeText(ActivityPublish.this, "请输入工作地点", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if (radio1.isChecked()){
                            if(radio3.isChecked()){
                                String serch_money = money.getText().toString().trim();
                                if (serch_money.length()==0){
                                    Toast.makeText(ActivityPublish.this, "请输入每日工资", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    if (radio5.isChecked()){
                                        String serch_text3 = edt3.getText().toString().trim();
                                        if (serch_text3.length() ==0){
                                            Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            if(isMobileNO(serch_text3)){
                                                String serch_text4 = edt4.getText().toString().trim();
                                                if (serch_text4.length() ==0){
                                                    Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                }
                                                else{
                                                    AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                    builder.setTitle("发布提示：");
                                                    builder.setMessage("确定要发布兼职吗？");
                                                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            Toast toast = Toast.makeText(ActivityPublish.this,"信息已成功提交，请您注意查收通知。",Toast.LENGTH_LONG);
                                                            toast.setGravity(Gravity.CENTER,0,0);
                                                            toast.show();
                                                            ActivityPublish.this.finish();
                                                        }
                                                    });
                                                    builder.setNegativeButton("取消",null);
                                                    builder.create();
                                                    builder.show();
                                                }
                                            }else{
                                                //手机号格式有误
                                                Toast.makeText(ActivityPublish.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                    else {
                                        if(radio6.isChecked()){
                                            String serch_text3 = edt3.getText().toString().trim();
                                            if (serch_text3.length() ==0){
                                                Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                            }
                                            else{
                                                if(isMobileNO(serch_text3)){
                                                    String serch_text4 = edt4.getText().toString().trim();
                                                    if (serch_text4.length() ==0){
                                                        Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                    }
                                                    else{
                                                        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                        builder.setTitle("发布提示：");
                                                        builder.setMessage("确定要发布兼职吗？");
                                                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Toast toast = Toast.makeText(ActivityPublish.this,"信息已成功提交，请您注意查收通知。",Toast.LENGTH_LONG);
                                                                toast.setGravity(Gravity.CENTER,0,0);
                                                                toast.show();
                                                                ActivityPublish.this.finish();
                                                            }
                                                        });
                                                        builder.setNegativeButton("取消",null);
                                                        builder.create();
                                                        builder.show();
                                                    }
                                                }else{
                                                    //手机号格式有误
                                                    Toast.makeText(ActivityPublish.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                        else {
                                            Toast.makeText(ActivityPublish.this, "请选择身份要求", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                            else {
                                if (radio4.isChecked()){
                                    String serch_money = money.getText().toString().trim();
                                    if (serch_money.length()==0){
                                        Toast.makeText(ActivityPublish.this, "请输入每日工资", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        if (radio5.isChecked()){
                                            String serch_text3 = edt3.getText().toString().trim();
                                            if (serch_text3.length() ==0){
                                                Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                            }
                                            else{
                                                if(isMobileNO(serch_text3)){
                                                    String serch_text4 = edt4.getText().toString().trim();
                                                    if (serch_text4.length() ==0){
                                                        Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                    }
                                                    else{
                                                        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                        builder.setTitle("发布提示：");
                                                        builder.setMessage("确定要发布兼职吗？");
                                                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Toast toast = Toast.makeText(ActivityPublish.this,"信息已成功提交，请您注意查收通知。",Toast.LENGTH_LONG);
                                                                toast.setGravity(Gravity.CENTER,0,0);
                                                                toast.show();
                                                                ActivityPublish.this.finish();
                                                            }
                                                        });
                                                        builder.setNegativeButton("取消",null);
                                                        builder.create();
                                                        builder.show();
                                                    }
                                                }else{
                                                    //手机号格式有误
                                                    Toast.makeText(ActivityPublish.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                        else {
                                            if(radio6.isChecked()){
                                                String serch_text3 = edt3.getText().toString().trim();
                                                if (serch_text3.length() ==0){
                                                    Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                }
                                                else{
                                                    if(isMobileNO(serch_text3)){
                                                        String serch_text4 = edt4.getText().toString().trim();
                                                        if (serch_text4.length() ==0){
                                                            Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                        }
                                                        else{
                                                            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                            builder.setTitle("发布提示：");
                                                            builder.setMessage("确定要发布兼职吗？");
                                                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Toast toast = Toast.makeText(ActivityPublish.this,"信息已成功提交，请您注意查收通知。",Toast.LENGTH_LONG);
                                                                    toast.setGravity(Gravity.CENTER,0,0);
                                                                    toast.show();
                                                                    ActivityPublish.this.finish();
                                                                }
                                                            });
                                                            builder.setNegativeButton("取消",null);
                                                            builder.create();
                                                            builder.show();
                                                        }
                                                    }else{
                                                        //手机号格式有误
                                                        Toast.makeText(ActivityPublish.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }
                                            else {
                                                Toast.makeText(ActivityPublish.this, "请选择身份要求", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                }
                                else {
                                    Toast.makeText(ActivityPublish.this, "请选择结算方式", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        else {
                            if (radio2.isChecked()){
                                if(radio3.isChecked()){
                                    String serch_money = money.getText().toString().trim();
                                    if (serch_money.length()==0){
                                        Toast.makeText(ActivityPublish.this, "请输入每日工资", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                        if (radio5.isChecked()){
                                            String serch_text3 = edt3.getText().toString().trim();
                                            if (serch_text3.length() ==0){
                                                Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                            }
                                            else{
                                                if(isMobileNO(serch_text3)){
                                                    String serch_text4 = edt4.getText().toString().trim();
                                                    if (serch_text4.length() ==0){
                                                        Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                    }
                                                    else{
                                                        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                        builder.setTitle("发布提示：");
                                                        builder.setMessage("确定要发布兼职吗？");
                                                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Toast toast = Toast.makeText(ActivityPublish.this,"信息已成功提交，请您注意查收通知。",Toast.LENGTH_LONG);
                                                                toast.setGravity(Gravity.CENTER,0,0);
                                                                toast.show();
                                                                ActivityPublish.this.finish();
                                                            }
                                                        });
                                                        builder.setNegativeButton("取消",null);
                                                        builder.create();
                                                        builder.show();
                                                    }
                                                }else{
                                                    //手机号格式有误
                                                    Toast.makeText(ActivityPublish.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                        else {
                                            if(radio6.isChecked()){
                                                String serch_text3 = edt3.getText().toString().trim();
                                                if (serch_text3.length() ==0){
                                                    Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                }
                                                else{
                                                    if(isMobileNO(serch_text3)){
                                                        String serch_text4 = edt4.getText().toString().trim();
                                                        if (serch_text4.length() ==0){
                                                            Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                        }
                                                        else{
                                                            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                            builder.setTitle("发布提示：");
                                                            builder.setMessage("确定要发布兼职吗？");
                                                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Toast toast = Toast.makeText(ActivityPublish.this,"信息已成功提交，请您注意查收通知。",Toast.LENGTH_LONG);
                                                                    toast.setGravity(Gravity.CENTER,0,0);
                                                                    toast.show();
                                                                    ActivityPublish.this.finish();
                                                                }
                                                            });
                                                            builder.setNegativeButton("取消",null);
                                                            builder.create();
                                                            builder.show();
                                                        }
                                                    }else{
                                                        //手机号格式有误
                                                        Toast.makeText(ActivityPublish.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }
                                            else {
                                                Toast.makeText(ActivityPublish.this, "请选择身份要求", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                }
                                else {
                                    if (radio4.isChecked()){
                                        String serch_money = money.getText().toString().trim();
                                        if (serch_money.length()==0){
                                            Toast.makeText(ActivityPublish.this, "请输入每日工资", Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            if (radio5.isChecked()){
                                                String serch_text3 = edt3.getText().toString().trim();
                                                if (serch_text3.length() ==0){
                                                    Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                }
                                                else{
                                                    if(isMobileNO(serch_text3)){
                                                        String serch_text4 = edt4.getText().toString().trim();
                                                        if (serch_text4.length() ==0){
                                                            Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                        }
                                                        else{
                                                            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                            builder.setTitle("发布提示：");
                                                            builder.setMessage("确定要发布兼职吗？");
                                                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Toast toast = Toast.makeText(ActivityPublish.this,"信息已成功提交，请您注意查收通知。",Toast.LENGTH_LONG);
                                                                    toast.setGravity(Gravity.CENTER,0,0);
                                                                    toast.show();
                                                                    ActivityPublish.this.finish();
                                                                }
                                                            });
                                                            builder.setNegativeButton("取消",null);
                                                            builder.create();
                                                            builder.show();
                                                        }
                                                    }else{
                                                        //手机号格式有误
                                                        Toast.makeText(ActivityPublish.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }
                                            else {
                                                if(radio6.isChecked()){
                                                    String serch_text3 = edt3.getText().toString().trim();
                                                    if (serch_text3.length() ==0){
                                                        Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                    }
                                                    else{
                                                        if(isMobileNO(serch_text3)){
                                                            String serch_text4 = edt4.getText().toString().trim();
                                                            if (serch_text4.length() ==0){
                                                                Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                            }
                                                            else{
                                                                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                                builder.setTitle("发布提示：");
                                                                builder.setMessage("确定要发布兼职吗？");
                                                                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        Toast toast = Toast.makeText(ActivityPublish.this,"信息已成功提交，请您注意查收通知。",Toast.LENGTH_LONG);
                                                                        toast.setGravity(Gravity.CENTER,0,0);
                                                                        toast.show();
                                                                        ActivityPublish.this.finish();
                                                                    }
                                                                });
                                                                builder.setNegativeButton("取消",null);
                                                                builder.create();
                                                                builder.show();
                                                            }
                                                        }else{
                                                            //手机号格式有误
                                                            Toast.makeText(ActivityPublish.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                }
                                                else {
                                                    Toast.makeText(ActivityPublish.this, "请选择身份要求", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        Toast.makeText(ActivityPublish.this, "请选择结算方式", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            else {
                                if (radio.isChecked()){
                                    if(radio3.isChecked()){
                                        String serch_money = money.getText().toString().trim();
                                        if (serch_money.length()==0){
                                            Toast.makeText(ActivityPublish.this, "请输入每日工资", Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            if (radio5.isChecked()){
                                                String serch_text3 = edt3.getText().toString().trim();
                                                if (serch_text3.length() ==0){
                                                    Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                }
                                                else{
                                                    if(isMobileNO(serch_text3)){
                                                        String serch_text4 = edt4.getText().toString().trim();
                                                        if (serch_text4.length() ==0){
                                                            Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                        }
                                                        else{
                                                            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                            builder.setTitle("发布提示：");
                                                            builder.setMessage("确定要发布兼职吗？");
                                                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Toast toast = Toast.makeText(ActivityPublish.this,"信息已成功提交，请您注意查收通知。",Toast.LENGTH_LONG);
                                                                    toast.setGravity(Gravity.CENTER,0,0);
                                                                    toast.show();
                                                                    ActivityPublish.this.finish();
                                                                }
                                                            });
                                                            builder.setNegativeButton("取消",null);
                                                            builder.create();
                                                            builder.show();
                                                        }
                                                    }else{
                                                        //手机号格式有误
                                                        Toast.makeText(ActivityPublish.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }
                                            else {
                                                if(radio6.isChecked()){
                                                    String serch_text3 = edt3.getText().toString().trim();
                                                    if (serch_text3.length() ==0){
                                                        Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                    }
                                                    else{
                                                        if(isMobileNO(serch_text3)){
                                                            String serch_text4 = edt4.getText().toString().trim();
                                                            if (serch_text4.length() ==0){
                                                                Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                            }
                                                            else{
                                                                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                                builder.setTitle("发布提示：");
                                                                builder.setMessage("确定要发布兼职吗？");
                                                                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        Toast toast = Toast.makeText(ActivityPublish.this,"信息已成功提交，请您注意查收通知。",Toast.LENGTH_LONG);
                                                                        toast.setGravity(Gravity.CENTER,0,0);
                                                                        toast.show();
                                                                        ActivityPublish.this.finish();
                                                                    }
                                                                });
                                                                builder.setNegativeButton("取消",null);
                                                                builder.create();
                                                                builder.show();
                                                            }
                                                        }else{
                                                            //手机号格式有误
                                                            Toast.makeText(ActivityPublish.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                }
                                                else {
                                                    Toast.makeText(ActivityPublish.this, "请选择身份要求", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                    }
                                    else {
                                        if (radio4.isChecked()){
                                            String serch_money = money.getText().toString().trim();
                                            if (serch_money.length()==0){
                                                Toast.makeText(ActivityPublish.this, "请输入每日工资", Toast.LENGTH_SHORT).show();
                                            }
                                            else {
                                                if (radio5.isChecked()){
                                                    String serch_text3 = edt3.getText().toString().trim();
                                                    if (serch_text3.length() ==0){
                                                        Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                    }
                                                    else{
                                                        if(isMobileNO(serch_text3)){
                                                            String serch_text4 = edt4.getText().toString().trim();
                                                            if (serch_text4.length() ==0){
                                                                Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                            }
                                                            else{
                                                                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                                builder.setTitle("发布提示：");
                                                                builder.setMessage("确定要发布兼职吗？");
                                                                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        Toast toast = Toast.makeText(ActivityPublish.this,"信息已成功提交，请您注意查收通知。",Toast.LENGTH_LONG);
                                                                        toast.setGravity(Gravity.CENTER,0,0);
                                                                        toast.show();
                                                                        ActivityPublish.this.finish();
                                                                    }
                                                                });
                                                                builder.setNegativeButton("取消",null);
                                                                builder.create();
                                                                builder.show();
                                                            }
                                                        }else{
                                                            //手机号格式有误
                                                            Toast.makeText(ActivityPublish.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                }
                                                else {
                                                    if(radio6.isChecked()){
                                                        String serch_text3 = edt3.getText().toString().trim();
                                                        if (serch_text3.length() ==0){
                                                            Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                        }
                                                        else{
                                                            if(isMobileNO(serch_text3)){
                                                                String serch_text4 = edt4.getText().toString().trim();
                                                                if (serch_text4.length() ==0){
                                                                    Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                                }
                                                                else{
                                                                    AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                                    builder.setTitle("发布提示：");
                                                                    builder.setMessage("确定要发布兼职吗？");
                                                                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            Toast toast = Toast.makeText(ActivityPublish.this,"信息已成功提交，请您注意查收通知。",Toast.LENGTH_LONG);
                                                                            toast.setGravity(Gravity.CENTER,0,0);
                                                                            toast.show();
                                                                            ActivityPublish.this.finish();
                                                                        }
                                                                    });
                                                                    builder.setNegativeButton("取消",null);
                                                                    builder.create();
                                                                    builder.show();
                                                                }
                                                            }else{
                                                                //手机号格式有误
                                                                Toast.makeText(ActivityPublish.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    }
                                                    else {
                                                        Toast.makeText(ActivityPublish.this, "请选择身份要求", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }
                                        }
                                        else {
                                            Toast.makeText(ActivityPublish.this, "请选择结算方式", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                                else {
                                    Toast.makeText(ActivityPublish.this, "请选择性别要求", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
            }
        });
    }
    private boolean isMobileNO(String phone) {
       /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String telRegex = "[1][3578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(phone)) return false;
        else return phone.matches(telRegex);
    }
}
