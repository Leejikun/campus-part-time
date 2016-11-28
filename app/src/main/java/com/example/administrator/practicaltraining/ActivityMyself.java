package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;

/**
 * Created by Administrator on 2016/11/22.
 */
public class ActivityMyself extends Activity {
    private Button button;
    private TextView textView;
    private RelativeLayout relativeLayout;
    private RelativeLayout relativeLayout1;
    private RelativeLayout relativeLayout2;
    private RelativeLayout relativeLayout3;
    private File file;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_myself);
        textView = (TextView) findViewById(R.id.TextView02);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityMyself.this, ActivityLogin.class);
                startActivity(intent);

            }
        });
        relativeLayout = (RelativeLayout) findViewById(R.id.forus);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(ActivityMyself.this, ActivityAppintorduce.class);
                startActivity(i);
            }
        });
        relativeLayout1 = (RelativeLayout) findViewById(R.id.yijianfankui);
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent();
                a.setClass(ActivityMyself.this, ActivityFeedback.class);
                startActivity(a);
            }
        });
        relativeLayout2 = (RelativeLayout) findViewById(R.id.callme);
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:15231115833"));
                startActivity(i);
            }
        });
        button = (Button) findViewById(R.id.id_myself_tcbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder AdBuilder = new AlertDialog.Builder(ActivityMyself.this);
                AdBuilder.setTitle("温馨提示");
                AdBuilder.setMessage("您确定退出校园兼职吗？");
                AdBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityMyself.this.finish();
                    }
                });
                AdBuilder.setNegativeButton("取消", null);
                AdBuilder.create();
                AdBuilder.show();
            }
        });
        final RelativeLayout moreMenu =(RelativeLayout)findViewById(R.id.share);
     moreMenu.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             PopupMenu popup=new PopupMenu(ActivityMyself.this,moreMenu);
             popup.getMenuInflater().inflate(R.menu.menu,popup.getMenu());
             popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                 public boolean onMenuItemClick(MenuItem item) {

                     return true;
                 }
             });
             popup.show();
         }
     });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ActivityMyself Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.administrator.practicaltraining/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ActivityMyself Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.administrator.practicaltraining/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}