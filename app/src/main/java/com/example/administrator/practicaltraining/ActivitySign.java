package com.example.administrator.practicaltraining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivitySign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //为“完成并报名”按钮绑定单击事件
        Button BtChange = (Button)findViewById(R.id.id_btn);
        BtChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建Toast
                Toast toastTip = Toast.makeText(ActivitySign.this, "完成报名", 1000);
                //设置Toast属性
                toastTip.setGravity(Gravity.CENTER, 0, 0);
                //显示Toast
                toastTip.show();
            }
        });
    }
}
