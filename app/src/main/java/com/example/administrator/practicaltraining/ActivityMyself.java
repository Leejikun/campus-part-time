package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
    private TextView Entrylist;
    private RelativeLayout mypt;
    private RelativeLayout publish;
    private RelativeLayout entrylist;
    private RelativeLayout resume;
    private RelativeLayout relativeLayout;
    private RelativeLayout relativeLayout1;
    private RelativeLayout relativeLayout2;
    private RelativeLayout relativeLayout3;
    private File file;
    private CircleImageView imageView;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myself);
        textView= (TextView) findViewById(R.id.dlzc);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityMyself.this, ActivityLogin.class);
                startActivity(intent);

            }
        });
        mypt = (RelativeLayout) findViewById(R.id.mypt);
        mypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(ActivityMyself.this,ActivityMyparttime.class);
                startActivity(intent);
            }
        });
        publish = (RelativeLayout)findViewById(R.id.id_myself_publish);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityMyself.this,ActivityPublish.class);
                startActivity(intent);
            }
        });
        entrylist = (RelativeLayout)findViewById(R.id.entrylist);
        Entrylist = (TextView)findViewById(R.id.Entrylist);
        entrylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityMyself.this,ActivityParttimelist.class);
                Bundle bundle=new Bundle();
                String service=Entrylist.getText().toString();
                bundle.putString("name",service);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        resume = (RelativeLayout)findViewById(R.id.resume);
        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityMyself.this,ActivityResume.class);
                startActivity(intent);
            }
        });
        relativeLayout = (RelativeLayout) findViewById(R.id.forus);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(ActivityMyself.this, ActivityApp.class);
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
                AlertDialog.Builder AdBuilder = new AlertDialog.Builder(ActivityMyself.this);
                AdBuilder.setTitle("<(＾－＾)>");
                AdBuilder.setMessage("您将要拨打电话至15231115833");
                AdBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent();
                        i.setAction(Intent.ACTION_CALL);
                        i.setData(Uri.parse("tel:15231115833"));
                        startActivity(i);
                    }
                });
                AdBuilder.setNegativeButton("取消", null);
                AdBuilder.create();
                AdBuilder.show();

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
                     switch (item.getItemId()){
                         case R.id.menu_1:
                             Intent intent = new Intent();
                             ComponentName comp = new ComponentName("com.tencent.mm",
                                     "com.tencent.mm.ui.tools.ShareImgUI");
                             intent.setComponent(comp);
                             intent.setAction("android.intent.action.SEND");
                             intent.setType("image/*");
                             intent.putExtra(Intent.EXTRA_TEXT,"校园兼职APP火爆上线了啦，再也不用担心找不到合适的工作！方便你我他");
                             startActivity(intent);
                     }
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