package com.example.administrator.practicaltraining;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import static cn.smssdk.SMSSDK.getSupportedCountries;
import static cn.smssdk.SMSSDK.getVerificationCode;
import static cn.smssdk.SMSSDK.submitVerificationCode;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;


public class ActivityLogin extends AppCompatActivity {
    private EditText editText;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private Button button;
    private EditText editText4;
    private String string;
    public ActivityLogin() {
    }
    private final String TAG="--MainActivity--";
    //app key和app secret 需要填自己应用的对应的！这里只是我自己创建的应用。
    private final String appKey="19a9661bb0a92";
    private final String appSecret="49d2b52eb984805af686bd6b6b5a9c9b";
    private EventHandler eh;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.arg1) {
                case 0:
                    //客户端验证成功，可以进行注册,返回校验的手机和国家代码phone/country
                    Toast.makeText(ActivityLogin.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    //获取验证码成功
                    Toast.makeText(ActivityLogin.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    //返回支持发送验证码的国家列表
                    Toast.makeText(ActivityLogin.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
    //View控件
    private Button bt_getCode;
    private Button bt_vertify;
    //手机号码
    private String phone;
    //验证码
    private String code;

    private boolean isChange;
    //控制按钮样式是否改变
    private boolean tag = true;
    //每次验证请求需要间隔60S
    private int i=60;

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

        editText=(EditText)findViewById(R.id.et_phone);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        editText1=(EditText)findViewById(R.id.et_code);
        editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText("");
            }
        });
        editText2=(EditText)findViewById(R.id.login_edit_account);
        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText2.setText("");
            }
        });
        editText3=(EditText)findViewById(R.id.login_edit_pwd);
        editText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText3.setText("");
            }
        });
        TextView textView = (TextView)findViewById(R.id.login_text_change_pwd);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityLogin.this,Resetpwd.class);
                startActivity(intent);

            }
        });
        TextView textView1 = (TextView)findViewById(R.id.login_btn_register);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityLogin.this,ActivityRegister.class);
                startActivity(intent);

            }
        });
        // 启动短信验证sdk
        SMSSDK.initSDK(this, appKey, appSecret);

        eh=new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        Message msg = new Message();
                        msg.arg1 = 0;
                        msg.obj = data;
                        handler.sendMessage(msg);
                        Log.d(TAG, "提交验证码成功");
                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        Message msg = new Message();
                        //获取验证码成功
                        msg.arg1 = 1;
                        msg.obj = "获取验证码成功";
                        handler.sendMessage(msg);
                        Log.d(TAG, "获取验证码成功");
                    } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                        Message msg = new Message();
                        //返回支持发送验证码的国家列表
                        msg.arg1 = 2;
                        msg.obj = "返回支持发送验证码的国家列表";
                        handler.sendMessage(msg);
                        Log.d(TAG, "返回支持发送验证码的国家列表");
                    }
                } else {
                    Message msg = new Message();
                    //返回支持发送验证码的国家列表
                    msg.arg1 = 3;
                    msg.obj = "验证失败";
                    handler.sendMessage(msg);
                    Log.d(TAG, "验证失败");
                    ((Throwable) data).printStackTrace();
                }
            }
        };

        SMSSDK.registerEventHandler(eh); //注册短信回调

        bt_getCode= (Button) findViewById(R.id.bt_getCode);
        bt_getCode.setClickable(false);
        bt_vertify= (Button) findViewById(R.id.bt_verify);
        bt_getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取验证码操作
                phone=((EditText)findViewById(R.id.et_phone)).getText().toString();
                if(phone.equals("")){
                    Toast.makeText(ActivityLogin.this,"手机号不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    //填写了手机号码
                    if(isMobileNO(phone)){
                        //如果手机号码无误，则发送验证请求
                        bt_getCode.setClickable(true);
                        changeBtnGetCode();
                        getSupportedCountries();
                        getVerificationCode("86", phone);
                    }else{
                        //手机号格式有误
                        Toast.makeText(ActivityLogin.this,"手机号格式错误，请检查",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        bt_vertify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //验证操作
                code=((EditText)findViewById(R.id.et_code)).getText().toString();
                if (code.equals("")){
                    Toast.makeText(ActivityLogin.this,"验证码不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    //填写了验证码，进行验证
                    submitVerificationCode("86", phone, code);
                }
            }
        });
    }

    /*
  * 改变按钮样式
  * */
    private void changeBtnGetCode() {

        Thread thread = new Thread() {
            @Override
            public void run() {
                if (tag) {
                    while (i > 0) {
                        i--;
                        //如果活动为空
                        if (ActivityLogin.this == null) {
                            break;
                        }

                        ActivityLogin.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                bt_getCode.setText("获取验证码(" + i + ")");
                                bt_getCode.setClickable(false);
                            }
                        });

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    tag = false;
                }
                i = 60;
                tag = true;

                if (ActivityLogin.this != null) {
                    ActivityLogin.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            bt_getCode.setText("获取验证码");
                            bt_getCode.setClickable(true);
                        }
                    });
                }
            }
        };
        thread.start();
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

