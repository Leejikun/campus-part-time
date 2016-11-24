package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/11/22.
 */
public class ActivityMyself extends Activity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_myself);
        Button bn=(Button)findViewById(R.id.id_myself_tcbtn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setClass(ActivityMyself.this,ActivityLogin.class);
                startActivity(intent);
    }
});
    }
}