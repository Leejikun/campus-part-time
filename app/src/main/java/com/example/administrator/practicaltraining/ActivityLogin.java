package com.example.administrator.practicaltraining;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class ActivityLogin extends TabActivity implements RadioGroup.OnCheckedChangeListener {
    private TabHost mHost;
    private RadioGroup radioderGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mHost = this.getTabHost();

        mHost.addTab(mHost.newTabSpec("ONE").setIndicator("ONE").setContent(new Intent(this,Login_tab1.class)));
        mHost.addTab(mHost.newTabSpec("TWO").setIndicator("TWO").setContent(new Intent(this,Login_tab2.class)));

        radioderGroup = (RadioGroup) findViewById(R.id.tabhost_radiogroup);
        radioderGroup.setOnCheckedChangeListener(this);
        findViewById(R.id.fl_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.tabhost_radio_button0:
                mHost.setCurrentTabByTag("ONE");

                break;
            case R.id.tabhost_radio_button1:
                mHost.setCurrentTabByTag("TWO");
                break;
        }
    }
}