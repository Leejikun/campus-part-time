package com.example.administrator.practicaltraining;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.radar.RadarNearbySearchOption;
import com.baidu.mapapi.radar.RadarSearchManager;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class map extends AppCompatActivity {
    private BaiduMap mBaiduMap;
    private UiSettings mUiSettings;
    private float mCurrentRadius;
    private float mCurrentDirection;
    private double mCurrentLatitude;
    private double mCurrentLongitude;
    private boolean mIsFirstLoc = true;
    private LocationClient mLocationClient;
    private TextureMapView mTextureMapView;
    private RadarSearchManager mManager;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_map2);
        getWidgetsReferences();//在该方法中获取所有成员的引用
        initView();//在该方法中初始化app界面
        setLocAlloc();
        setListenersOnWidgets();//为组件设置监听者
        MyLocationConfiguration mlc = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.COMPASS, true, null);
        mBaiduMap.setMyLocationConfigeration(mlc);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void setListenersOnWidgets() {
        mLocationClient.registerLocationListener(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                mCurrentLatitude = bdLocation.getLatitude();
                mCurrentLongitude = bdLocation.getLongitude();
                mCurrentDirection = bdLocation.getDirection();
                mCurrentRadius = bdLocation.getRadius();

                if (mIsFirstLoc) {
                    mIsFirstLoc = false;
                    moveToCurrentPosition();

                    //请求显示附近使用相同应用的人
                    RadarNearbySearchOption option = new RadarNearbySearchOption()
                            .centerPt(new LatLng(mCurrentLatitude, mCurrentLongitude))
                            .pageNum(00)
                            .pageCapacity(50)
                            .radius(2000);
                    mManager.nearbyInfoRequest(option);
                }//if
            }
        });
        mManager.addNearbyInfoListener(this);
    }//setListenersOnWidgets


    private void moveToCurrentPosition() {
        MyLocationData locData = new MyLocationData.Builder()
                .accuracy(mCurrentRadius)
                .direction(mCurrentDirection)
                .latitude(mCurrentLatitude)
                .longitude(mCurrentLongitude)
                .build();
        mBaiduMap.setMyLocationData(locData);

        LatLng ll = new LatLng(mCurrentLatitude, mCurrentLongitude);
        MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
        mBaiduMap.animateMapStatus(u);
    }


    //设置定位相关配置
    private void setLocAlloc() {
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true);
        option.setCoorType("bd09ll");
        option.setScanSpan(2000);
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        mLocationClient.setLocOption(option);
    }//setLocAlloc


    private void initView() {
        //1、去掉百度地图logo
        View child = mTextureMapView.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)) {
            child.setVisibility(View.INVISIBLE);
        }//if

        //2、设置比例尺为500m
        MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(15.0f);
        mBaiduMap.setMapStatus(msu);

        //3、添加标注覆盖物
        //时光塔
        LatLng point = new LatLng(38.003265, 114.527259);//114.527259,38.003265
        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.drawable.shiguangta);
        OverlayOptions option = new MarkerOptions().position(point).icon(bitmap).perspective(true);
        Marker marker = (Marker) mBaiduMap.addOverlay(option);

        //软件学院
        point = new LatLng(38.003588, 114.529195);//114.529195,38.003588
        bitmap = BitmapDescriptorFactory.fromResource(R.drawable.ruanjianxueyuan);
        option = new MarkerOptions().position(point).icon(bitmap).perspective(true);
        marker = (Marker) mBaiduMap.addOverlay(option);

        //4、创建多边形覆盖物
        List<LatLng> pts = new ArrayList<>();
        pts.add(new LatLng(38.00635, 114.5333457));
        pts.add(new LatLng(38.004395, 114.533417));
        pts.add(new LatLng(38.004395, 114.530219));
        pts.add(new LatLng(37.999916, 114.530417));
        pts.add(new LatLng(37.999888, 114.519781));
        pts.add(new LatLng(38.006925, 114.519529));
        pts.add(new LatLng(38.00694, 114.533399));
        pts.add(new LatLng(38.00635, 114.5333457));

        OverlayOptions polygonOption = new PolygonOptions().points(pts).stroke(new Stroke(5, 0xAA00FF00)).fillColor(0xAAFFFF00);
        mBaiduMap.addOverlay(polygonOption);

        //5、创建文字覆盖物
        //软件学院
        LatLng llText = new LatLng(38.003407, 114.529262);
        OverlayOptions textOption = new TextOptions()
                .bgColor(0xAAFFFF00)
                .fontSize(16)
                .fontColor(0xFFFF00FF)
                .text("河北师范大学软件学院")
                .rotate(-30)
                .position(llText);
        // 在地图上添加该文字对象并显示
        mBaiduMap.addOverlay(textOption);

        //时光塔
        llText = new LatLng(38.003257, 114.527255);
        textOption = new TextOptions()
                .bgColor(0xAAFFFF00)
                .fontSize(16)
                .fontColor(0xFFFF00FF)
                .text("河北师范大学时光塔")
                .rotate(-30)
                .position(llText);
        // 在地图上添加该文字对象并显示
        mBaiduMap.addOverlay(textOption);

        //图书馆
        llText = new LatLng(38.003041, 114.524376);
        textOption = new TextOptions()
                .bgColor(0xAAFFFF00)
                .fontSize(16)
                .fontColor(0xFFFF00FF)
                .text("河北师范大学图书馆")
                .rotate(-30)
                .position(llText);
        // 在地图上添加该文字对象并显示
        mBaiduMap.addOverlay(textOption);

    }//initView


    public void getWidgetsReferences() {
        mTextureMapView = (TextureMapView) findViewById(R.id.bmapView);
        mBaiduMap = mTextureMapView.getMap();
        mUiSettings = mBaiduMap.getUiSettings();
        mLocationClient = new LocationClient(getApplicationContext());
        mManager = RadarSearchManager.getInstance();
        mManager.setUserID(null);
        mManager.startUploadAuto(this, 5000);
    }//getWidgetsReferences


    @Override
    protected void onStart() {
        mBaiduMap.setMyLocationEnabled(true);
        if (!mLocationClient.isStarted()) {
            mLocationClient.start();
        }
        super.onStart();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "map Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.administrator.practicaltraining/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }//onStart


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_move_to_current_position:
                moveToCurrentPosition();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }//onOptionsItemSelected

    @Override
    protected void onStop() {
        mBaiduMap.setMyLocationEnabled(false);
        mLocationClient.stop();
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "map Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.administrator.practicaltraining/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }//onStop

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTextureMapView.onDestroy();
        mManager.removeNearbyInfoListener(this);
        // 清除用户信息
        mManager.clearUserInfo();
        // 释放资源
        mManager.destroy();
        mManager = null;
    }//onDestroy


    @Override
    protected void onPause() {
        super.onPause();
        mTextureMapView.onPause();
    }
}