package com.example.administrator.practicaltraining;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class MainActivity extends TabActivity implements RadioGroup.OnCheckedChangeListener {
    private TabHost mHost;
    private RadioGroup radioderGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mHost = this.getTabHost();

        mHost.addTab(mHost.newTabSpec("ONE").setIndicator("ONE").setContent(new Intent(this,ActivityMain.class)));
        mHost.addTab(mHost.newTabSpec("TWO").setIndicator("TWO").setContent(new Intent(this,ActivityApply.class)));
        mHost.addTab(mHost.newTabSpec("THREE").setIndicator("THREE").setContent(new Intent(this,Message .class)));
        mHost.addTab(mHost.newTabSpec("FOUR").setIndicator("FOUR").setContent(new Intent(this,Myself.class)));

        radioderGroup = (RadioGroup) findViewById(R.id.tabhost_radiogroup);
        radioderGroup.setOnCheckedChangeListener(this);
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
            case R.id.tabhost_radio_button2:
                mHost.setCurrentTabByTag("THREE");
                break;
            case R.id.tabhost_radio_button3:
                mHost.setCurrentTabByTag("FOUR");
                break;
        }
    }
}
