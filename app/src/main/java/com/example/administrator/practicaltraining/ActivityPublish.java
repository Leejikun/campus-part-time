package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.net.URLEncoder;

import static cn.smssdk.SMSSDK.getSupportedCountries;
import static cn.smssdk.SMSSDK.getVerificationCode;
import static com.example.administrator.practicaltraining.R.id.bt_getCode;
import static com.example.administrator.practicaltraining.R.id.workTime;

/**
 * Created by Administrator on 2016/11/30.
 */

public class ActivityPublish extends Activity {
    public ImageView back;
    public EditText worktime;
    public EditText workspace;
    public EditText number;
    public EditText miaoshu;
    public RadioButton radio1;
    public RadioButton radio2;
    public RadioButton radio3;
    public RadioButton radio4;
    public RadioButton radio5;
    public RadioButton radio6;
    public RadioButton radio;
    public EditText money;
    public Button btn;
    public TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publishparttime);
        back = (ImageView) findViewById(R.id.back);
        worktime = (EditText) findViewById(R.id.id_publish_worktime);
        workspace = (EditText) findViewById(R.id.id_publish_workspace);
        number = (EditText) findViewById(R.id.id_publish_number);
        miaoshu = (EditText) findViewById(R.id.id_public_miaoshu);
        money = (EditText) findViewById(R.id.money);
        radio = (RadioButton) findViewById(R.id.id_radio);
        radio1 = (RadioButton) findViewById(R.id.id_radio1);
        radio2 = (RadioButton) findViewById(R.id.id_radio2);
        radio3 = (RadioButton) findViewById(R.id.id_radio3);
        radio4 = (RadioButton) findViewById(R.id.id_radio4);
        radio5 = (RadioButton) findViewById(R.id.id_radio5);
        radio6 = (RadioButton) findViewById(R.id.id_radio6);
        tv = (TextView)findViewById(R.id.tv);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn = (Button) findViewById(R.id.id_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String serch_text1 = worktime.getText().toString().trim();
                if (serch_text1.length() == 0) {
                    Toast.makeText(ActivityPublish.this, "请输入工作时间", Toast.LENGTH_SHORT).show();
                } else {
                    String serch_text2 = workspace.getText().toString().trim();
                    if (serch_text2.length() == 0) {
                        Toast.makeText(ActivityPublish.this, "请输入工作地点", Toast.LENGTH_SHORT).show();
                    } else {
                        if (radio1.isChecked()) {
                            if (radio3.isChecked()) {
                                String serch_money = money.getText().toString().trim();
                                if (serch_money.length() == 0) {
                                    Toast.makeText(ActivityPublish.this, "请输入每日工资", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (radio5.isChecked()) {
                                        String serch_text3 = number.getText().toString().trim();
                                        if (serch_text3.length() == 0) {
                                            Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                        } else {
                                            if (isMobileNO(serch_text3)) {
                                                String serch_text4 = miaoshu.getText().toString().trim();
                                                if (serch_text4.length() == 0) {
                                                    Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                    builder.setTitle("发布提示：");
                                                    builder.setMessage("确定要发布兼职吗？");
                                                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                        public void onClick(DialogInterface dialog, int which) {
//                                                            Toast toast = Toast.makeText(ActivityPublish.this, "信息已成功提交，请您注意查收通知。", Toast.LENGTH_LONG);
//                                                            toast.setGravity(Gravity.CENTER, 0, 0);
//                                                            toast.show();
//                                                            ActivityPublish.this.finish();
                                                            String serch_text1 = worktime.getText().toString();
                                                            String serch_text2 = workspace.getText().toString();
                                                            String serch_text3 = number.getText().toString();
                                                            String serch_text4 = miaoshu.getText().toString();
                                                            String moner = money.getText().toString();
                                                            com.loopj.android.http.AsyncHttpClient client = new com.loopj.android.http.AsyncHttpClient();
                                                            String url = "http://10.7.88.89:8181/addjob?name=liu&token=55b0b9f6-cd4b-4ad5-b3b0-bd50042ee857&job.name=王宇航&job.type=1";
                                                            //获取参数
                                                            RequestParams params = new RequestParams();
                                                            params.add("stoptime", serch_text1);
                                                            params.add("address", serch_text2);
                                                            params.add("num", serch_text3);
                                                            params.add("miaoshu", serch_text4);
                                                            params.add("money","money");
                                                            //服务器获取参数
                                                            client.post(getApplicationContext(), url, params, new JsonHttpResponseHandler() {
                                                                public void onSuccess(int statusCode, Header[] headers, JSONArray[] response) {

                                                                }
                                                            });
                                                        }
                                                    });
                                                    builder.setNegativeButton("取消", null);
                                                    builder.create();
                                                    builder.show();
                                                }
                                            } else {
                                                //手机号格式有误
                                                Toast.makeText(ActivityPublish.this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    } else {
                                        if (radio6.isChecked()) {
                                            String serch_text3 = number.getText().toString().trim();
                                            if (serch_text3.length() == 0) {
                                                Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                            } else {
                                                if (isMobileNO(serch_text3)) {
                                                    String serch_text4 = miaoshu.getText().toString().trim();
                                                    if (serch_text4.length() == 0) {
                                                        Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                        builder.setTitle("发布提示：");
                                                        builder.setMessage("确定要发布兼职吗？");
                                                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Toast toast = Toast.makeText(ActivityPublish.this, "信息已成功提交，请您注意查收通知。", Toast.LENGTH_LONG);
                                                                toast.setGravity(Gravity.CENTER, 0, 0);
                                                                toast.show();
                                                                ActivityPublish.this.finish();
                                                            }
                                                        });
                                                        builder.setNegativeButton("取消", null);
                                                        builder.create();
                                                        builder.show();
                                                    }
                                                } else {
                                                    //手机号格式有误
                                                    Toast.makeText(ActivityPublish.this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        } else {
                                            Toast.makeText(ActivityPublish.this, "请选择身份要求", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            } else {
                                if (radio4.isChecked()) {
                                    String serch_money = money.getText().toString().trim();
                                    if (serch_money.length() == 0) {
                                        Toast.makeText(ActivityPublish.this, "请输入每日工资", Toast.LENGTH_SHORT).show();
                                    } else {
                                        if (radio5.isChecked()) {
                                            String serch_text3 = number.getText().toString().trim();
                                            if (serch_text3.length() == 0) {
                                                Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                            } else {
                                                if (isMobileNO(serch_text3)) {
                                                    String serch_text4 = miaoshu.getText().toString().trim();
                                                    if (serch_text4.length() == 0) {
                                                        Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                        builder.setTitle("发布提示：");
                                                        builder.setMessage("确定要发布兼职吗？");
                                                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Toast toast = Toast.makeText(ActivityPublish.this, "信息已成功提交，请您注意查收通知。", Toast.LENGTH_LONG);
                                                                toast.setGravity(Gravity.CENTER, 0, 0);
                                                                toast.show();
                                                                ActivityPublish.this.finish();
                                                            }
                                                        });
                                                        builder.setNegativeButton("取消", null);
                                                        builder.create();
                                                        builder.show();
                                                    }
                                                } else {
                                                    //手机号格式有误
                                                    Toast.makeText(ActivityPublish.this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        } else {
                                            if (radio6.isChecked()) {
                                                String serch_text3 = number.getText().toString().trim();
                                                if (serch_text3.length() == 0) {
                                                    Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    if (isMobileNO(serch_text3)) {
                                                        String serch_text4 = miaoshu.getText().toString().trim();
                                                        if (serch_text4.length() == 0) {
                                                            Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                        } else {
                                                            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                            builder.setTitle("发布提示：");
                                                            builder.setMessage("确定要发布兼职吗？");
                                                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Toast toast = Toast.makeText(ActivityPublish.this, "信息已成功提交，请您注意查收通知。", Toast.LENGTH_LONG);
                                                                    toast.setGravity(Gravity.CENTER, 0, 0);
                                                                    toast.show();
                                                                    ActivityPublish.this.finish();
                                                                }
                                                            });
                                                            builder.setNegativeButton("取消", null);
                                                            builder.create();
                                                            builder.show();
                                                        }
                                                    } else {
                                                        //手机号格式有误
                                                        Toast.makeText(ActivityPublish.this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            } else {
                                                Toast.makeText(ActivityPublish.this, "请选择身份要求", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                } else {
                                    Toast.makeText(ActivityPublish.this, "请选择结算方式", Toast.LENGTH_SHORT).show();
                                }
                            }
                        } else {
                            if (radio2.isChecked()) {
                                if (radio3.isChecked()) {
                                    String serch_money = money.getText().toString().trim();
                                    if (serch_money.length() == 0) {
                                        Toast.makeText(ActivityPublish.this, "请输入每日工资", Toast.LENGTH_SHORT).show();
                                    } else {
                                        if (radio5.isChecked()) {
                                            String serch_text3 = number.getText().toString().trim();
                                            if (serch_text3.length() == 0) {
                                                Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                            } else {
                                                if (isMobileNO(serch_text3)) {
                                                    String serch_text4 = miaoshu.getText().toString().trim();
                                                    if (serch_text4.length() == 0) {
                                                        Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                        builder.setTitle("发布提示：");
                                                        builder.setMessage("确定要发布兼职吗？");
                                                        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                Toast toast = Toast.makeText(ActivityPublish.this, "信息已成功提交，请您注意查收通知。", Toast.LENGTH_LONG);
                                                                toast.setGravity(Gravity.CENTER, 0, 0);
                                                                toast.show();
                                                                ActivityPublish.this.finish();
                                                            }
                                                        });
                                                        builder.setNegativeButton("取消", null);
                                                        builder.create();
                                                        builder.show();
                                                    }
                                                } else {
                                                    //手机号格式有误
                                                    Toast.makeText(ActivityPublish.this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        } else {
                                            if (radio6.isChecked()) {
                                                String serch_text3 = number.getText().toString().trim();
                                                if (serch_text3.length() == 0) {
                                                    Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    if (isMobileNO(serch_text3)) {
                                                        String serch_text4 = miaoshu.getText().toString().trim();
                                                        if (serch_text4.length() == 0) {
                                                            Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                        } else {
                                                            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                            builder.setTitle("发布提示：");
                                                            builder.setMessage("确定要发布兼职吗？");
                                                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Toast toast = Toast.makeText(ActivityPublish.this, "信息已成功提交，请您注意查收通知。", Toast.LENGTH_LONG);
                                                                    toast.setGravity(Gravity.CENTER, 0, 0);
                                                                    toast.show();
                                                                    ActivityPublish.this.finish();
                                                                }
                                                            });
                                                            builder.setNegativeButton("取消", null);
                                                            builder.create();
                                                            builder.show();
                                                        }
                                                    } else {
                                                        //手机号格式有误
                                                        Toast.makeText(ActivityPublish.this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            } else {
                                                Toast.makeText(ActivityPublish.this, "请选择身份要求", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                } else {
                                    if (radio4.isChecked()) {
                                        String serch_money = money.getText().toString().trim();
                                        if (serch_money.length() == 0) {
                                            Toast.makeText(ActivityPublish.this, "请输入每日工资", Toast.LENGTH_SHORT).show();
                                        } else {
                                            if (radio5.isChecked()) {
                                                String serch_text3 = number.getText().toString().trim();
                                                if (serch_text3.length() == 0) {
                                                    Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    if (isMobileNO(serch_text3)) {
                                                        String serch_text4 = miaoshu.getText().toString().trim();
                                                        if (serch_text4.length() == 0) {
                                                            Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                        } else {
                                                            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                            builder.setTitle("发布提示：");
                                                            builder.setMessage("确定要发布兼职吗？");
                                                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Toast toast = Toast.makeText(ActivityPublish.this, "信息已成功提交，请您注意查收通知。", Toast.LENGTH_LONG);
                                                                    toast.setGravity(Gravity.CENTER, 0, 0);
                                                                    toast.show();
                                                                    ActivityPublish.this.finish();
                                                                }
                                                            });
                                                            builder.setNegativeButton("取消", null);
                                                            builder.create();
                                                            builder.show();
                                                        }
                                                    } else {
                                                        //手机号格式有误
                                                        Toast.makeText(ActivityPublish.this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            } else {
                                                if (radio6.isChecked()) {
                                                    String serch_text3 = number.getText().toString().trim();
                                                    if (serch_text3.length() == 0) {
                                                        Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        if (isMobileNO(serch_text3)) {
                                                            String serch_text4 = miaoshu.getText().toString().trim();
                                                            if (serch_text4.length() == 0) {
                                                                Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                            } else {
                                                                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                                builder.setTitle("发布提示：");
                                                                builder.setMessage("确定要发布兼职吗？");
                                                                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        Toast toast = Toast.makeText(ActivityPublish.this, "信息已成功提交，请您注意查收通知。", Toast.LENGTH_LONG);
                                                                        toast.setGravity(Gravity.CENTER, 0, 0);
                                                                        toast.show();
                                                                        ActivityPublish.this.finish();
                                                                    }
                                                                });
                                                                builder.setNegativeButton("取消", null);
                                                                builder.create();
                                                                builder.show();
                                                            }
                                                        } else {
                                                            //手机号格式有误
                                                            Toast.makeText(ActivityPublish.this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                } else {
                                                    Toast.makeText(ActivityPublish.this, "请选择身份要求", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                    } else {
                                        Toast.makeText(ActivityPublish.this, "请选择结算方式", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            } else {
                                if (radio.isChecked()) {
                                    if (radio3.isChecked()) {
                                        String serch_money = money.getText().toString().trim();
                                        if (serch_money.length() == 0) {
                                            Toast.makeText(ActivityPublish.this, "请输入每日工资", Toast.LENGTH_SHORT).show();
                                        } else {
                                            if (radio5.isChecked()) {
                                                String serch_text3 = number.getText().toString().trim();
                                                if (serch_text3.length() == 0) {
                                                    Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                } else {
                                                    if (isMobileNO(serch_text3)) {
                                                        String serch_text4 = miaoshu.getText().toString().trim();
                                                        if (serch_text4.length() == 0) {
                                                            Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                        } else {
                                                            AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                            builder.setTitle("发布提示：");
                                                            builder.setMessage("确定要发布兼职吗？");
                                                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                public void onClick(DialogInterface dialog, int which) {
                                                                    Toast toast = Toast.makeText(ActivityPublish.this, "信息已成功提交，请您注意查收通知。", Toast.LENGTH_LONG);
                                                                    toast.setGravity(Gravity.CENTER, 0, 0);
                                                                    toast.show();
                                                                    ActivityPublish.this.finish();
                                                                }
                                                            });
                                                            builder.setNegativeButton("取消", null);
                                                            builder.create();
                                                            builder.show();
                                                        }
                                                    } else {
                                                        //手机号格式有误
                                                        Toast.makeText(ActivityPublish.this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            } else {
                                                if (radio6.isChecked()) {
                                                    String serch_text3 = number.getText().toString().trim();
                                                    if (serch_text3.length() == 0) {
                                                        Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        if (isMobileNO(serch_text3)) {
                                                            String serch_text4 = miaoshu.getText().toString().trim();
                                                            if (serch_text4.length() == 0) {
                                                                Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                            } else {
                                                                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                                builder.setTitle("发布提示：");
                                                                builder.setMessage("确定要发布兼职吗？");
                                                                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        Toast toast = Toast.makeText(ActivityPublish.this, "信息已成功提交，请您注意查收通知。", Toast.LENGTH_LONG);
                                                                        toast.setGravity(Gravity.CENTER, 0, 0);
                                                                        toast.show();
                                                                        ActivityPublish.this.finish();
                                                                    }
                                                                });
                                                                builder.setNegativeButton("取消", null);
                                                                builder.create();
                                                                builder.show();
                                                            }
                                                        } else {
                                                            //手机号格式有误
                                                            Toast.makeText(ActivityPublish.this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                } else {
                                                    Toast.makeText(ActivityPublish.this, "请选择身份要求", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        }
                                    } else {
                                        if (radio4.isChecked()) {
                                            String serch_money = money.getText().toString().trim();
                                            if (serch_money.length() == 0) {
                                                Toast.makeText(ActivityPublish.this, "请输入每日工资", Toast.LENGTH_SHORT).show();
                                            } else {
                                                if (radio5.isChecked()) {
                                                    String serch_text3 = number.getText().toString().trim();
                                                    if (serch_text3.length() == 0) {
                                                        Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        if (isMobileNO(serch_text3)) {
                                                            String serch_text4 = miaoshu.getText().toString().trim();
                                                            if (serch_text4.length() == 0) {
                                                                Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                            } else {
                                                                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                                builder.setTitle("发布提示：");
                                                                builder.setMessage("确定要发布兼职吗？");
                                                                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        Toast toast = Toast.makeText(ActivityPublish.this, "信息已成功提交，请您注意查收通知。", Toast.LENGTH_LONG);
                                                                        toast.setGravity(Gravity.CENTER, 0, 0);
                                                                        toast.show();
                                                                        ActivityPublish.this.finish();
                                                                    }
                                                                });
                                                                builder.setNegativeButton("取消", null);
                                                                builder.create();
                                                                builder.show();
                                                            }
                                                        } else {
                                                            //手机号格式有误
                                                            Toast.makeText(ActivityPublish.this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                                                        }
                                                    }
                                                } else {
                                                    if (radio6.isChecked()) {
                                                        String serch_text3 = number.getText().toString().trim();
                                                        if (serch_text3.length() == 0) {
                                                            Toast.makeText(ActivityPublish.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                                                        } else {
                                                            if (isMobileNO(serch_text3)) {
                                                                String serch_text4 = miaoshu.getText().toString().trim();
                                                                if (serch_text4.length() == 0) {
                                                                    Toast.makeText(ActivityPublish.this, "请输入工作描述", Toast.LENGTH_SHORT).show();
                                                                } else {
                                                                    AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPublish.this);
                                                                    builder.setTitle("发布提示：");
                                                                    builder.setMessage("确定要发布兼职吗？");
                                                                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                                        public void onClick(DialogInterface dialog, int which) {
                                                                            Toast toast = Toast.makeText(ActivityPublish.this, "信息已成功提交，请您注意查收通知。", Toast.LENGTH_LONG);
                                                                            toast.setGravity(Gravity.CENTER, 0, 0);
                                                                            toast.show();
                                                                            ActivityPublish.this.finish();
                                                                        }
                                                                    });
                                                                    builder.setNegativeButton("取消", null);
                                                                    builder.create();
                                                                    builder.show();
                                                                }
                                                            } else {
                                                                //手机号格式有误
                                                                Toast.makeText(ActivityPublish.this, "手机号格式错误，请检查", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    } else {
                                                        Toast.makeText(ActivityPublish.this, "请选择身份要求", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            }
                                        } else {
                                            Toast.makeText(ActivityPublish.this, "请选择结算方式", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                } else {
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

//    public void getDataFormServer() {
//        com.loopj.android.http.AsyncHttpClient client = new com.loopj.android.http.AsyncHttpClient();
//        String url = "http://10.7.88.45:8080/qq/login";
//        //获取参数
//        RequestParams params = new RequestParams();
//        params.add("qqid", "input_qqid");
//        params.add("qqname", "input_qqname");
//        params.add("qqgender", "input_qqgender");
//        //服务器获取参数
//        client.get(getApplicationContext(), url, params, new JsonHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
//            }
//        });
//    }
}
