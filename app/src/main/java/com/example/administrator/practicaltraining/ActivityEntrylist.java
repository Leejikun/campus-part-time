package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.baidu.mapapi.map.Text;

/**
 * Created by Administrator on 2016/12/13.
 */

public class ActivityEntrylist extends Activity {
    private TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrylist);

        final RefreshableView refreshableView = (RefreshableView) findViewById(R.id.refreshable_view1);
        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshableView.finishRefreshing();
            }
        }, 0);

        name=(TextView)findViewById(R.id.name);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        String name1=bundle.getString("name");
        name.setText(name1);
    }
}
