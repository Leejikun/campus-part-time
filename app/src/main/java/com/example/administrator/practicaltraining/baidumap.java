package com.example.administrator.practicaltraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
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
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.radar.RadarNearbyResult;
import com.baidu.mapapi.radar.RadarNearbySearchOption;
import com.baidu.mapapi.radar.RadarSearchError;
import com.baidu.mapapi.radar.RadarSearchListener;
import com.baidu.mapapi.radar.RadarSearchManager;
import com.baidu.mapapi.radar.RadarUploadInfo;
import com.baidu.mapapi.radar.RadarUploadInfoCallback;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class baidumap extends AppCompatActivity {

    TextureMapView mMapView = null;
    /*  地图实例 */
    private BaiduMap mBaiduMap;
    /*  定位的客户端 */
    private LocationClient mLocationClient;
    /*  定位的监听器 */
    public MyLocationListener mMyLocationListener;
    /* 当前定位的模式 */
    private MyLocationConfiguration.LocationMode mCurrentMode
            = MyLocationConfiguration.LocationMode.NORMAL;

    /*  周边雷达管理器 */
    private RadarSearchManager mRadarSearchManager = null;

    /*  周边雷达的监听器 */
    MyRadarSearchListener mRadarSerchListener = null;


    /*  是否是第一次定位 */
    private volatile boolean isFristLocation = true;
    /*  最新一次的经纬度 */
    private double mCurrentLantitude;
    private double mCurrentLongitude;
    /*  地图定位的模式 */
    private String[] mStyles
            = new String[]{" 地图模式【正常】",
            " 地图模式【跟随】",
            " 地图模式【罗盘】"};
    private int mCurrentStyle = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    /* UserID */
    private String mUserID = " 钢铁侠 侠";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  在使用SDK 各组件之前初始化context 信息，传入ApplicationContext
        //  注意该方法要再setContentView 方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_baidumap);
        //  获取地图控件引用
//----------------------1.软件能够正常价在Baidu地图并进行显示。--------------------------------
//----------------------2.河北师范大学在地图上的区域范围需用多边形标示出来。-------------------
        mMapView = (TextureMapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
//----------------------4.地图比例尺调整到500m进行显示。---------------------------------------
        MapStatusUpdate msu =
                MapStatusUpdateFactory.zoomTo(15.0f);
        mBaiduMap.setMapStatus(msu);

        initMyLocation();
        center2myLoc();
        //  初始化周边雷达
        initRadarSearch();

        // 定义多边形的五个顶点
        LatLng pt1 = new LatLng(38.006872, 114.519624);
        LatLng pt2 = new LatLng(38.0069, 114.535362);
        LatLng pt3 = new LatLng(37.999792, 114.53547);
        LatLng pt4 = new LatLng(37.999877, 114.519839);
        List<LatLng> pts = new ArrayList<LatLng>();
        pts.add(pt1);
        pts.add(pt2);
        pts.add(pt3);
        pts.add(pt4);
        // 构建用户绘制多边形的Option对象
        OverlayOptions polygonOption = new PolygonOptions()
                .points(pts).stroke(new Stroke(5, 0xAA00FF00))
                .fillColor(0xAAFFFFFF);
        // 在地图上添加多边形Option，用于显示
        mBaiduMap.addOverlay(polygonOption);
//----------------------3.对主要建筑物需要添加文字显示。--------------------------
        // 定义文字所显示的坐标点
        LatLng llText = new LatLng(38.003127, 114.52442);
        LatLng llText2 = new LatLng(38.001908, 114.527053);
        LatLng llText3 = new LatLng(38.004396, 114.524897);
        LatLng llText4 = new LatLng(38.000611, 114.522327);
        LatLng llText5 = new LatLng(38.000532, 114.52716);
        LatLng llText6 = new LatLng(38.005011, 114.530125);
        LatLng llText7 = new LatLng(38.00055, 114.52522);
        LatLng llText8 = new LatLng(38.004119, 114.52177);
        LatLng llText9 = new LatLng(38.003688, 114.529438);
        LatLng llText10 = new LatLng(38.003119, 114.527057);
        // 构建文字Option对象，用于在地图上添加文字
        OverlayOptions textOption = new TextOptions()
                .fontColor(0xDD222255)
                .fontSize(14)
                .text("图书馆")
                .position(llText);
        OverlayOptions textOption2 = new TextOptions()
                .fontSize(14)
                .fontColor(0xDD222255)
                .text("公教楼A-E")
                .position(llText2);
        OverlayOptions textOption3 = new TextOptions()
                .fontSize(14)
                .fontColor(0xDD222255)
                .text("博物馆")
                .position(llText3);
        OverlayOptions textOption4 = new TextOptions()
                .fontSize(14)
                .fontColor(0xDD222255)
                .text("田径场")
                .position(llText4);
        OverlayOptions textOption5 = new TextOptions()
                .fontSize(14)
                .fontColor(0xDD222255)
                .text("第一餐厅")
                .position(llText5);
        OverlayOptions textOption6 = new TextOptions()
                .fontSize(14)
                .fontColor(0xDD222255)
                .text("理科群")
                .position(llText6);
        OverlayOptions textOption7 = new TextOptions()
                .fontSize(14)
                .fontColor(0xDD222255)
                .text("一期宿舍楼群")
                .position(llText7);
        OverlayOptions textOption8 = new TextOptions()
                .fontSize(14)
                .fontColor(0xDD222255)
                .text("二期宿舍楼群")
                .position(llText8);
        OverlayOptions textOption9 = new TextOptions()
                .fontSize(18)
                .fontColor(0xDD222255)
                .text("大软件学院")
                .position(llText9);
        OverlayOptions textOption10 = new TextOptions()
                .fontSize(18)
                .fontColor(0xDD222255)
                .text("时光塔")
                .position(llText10);

        // 在地图上添加该文字对象并显示
        mBaiduMap.addOverlay(textOption);
        mBaiduMap.addOverlay(textOption2);
        mBaiduMap.addOverlay(textOption3);
        mBaiduMap.addOverlay(textOption4);
        mBaiduMap.addOverlay(textOption5);
        mBaiduMap.addOverlay(textOption6);
        mBaiduMap.addOverlay(textOption7);
        mBaiduMap.addOverlay(textOption8);
        mBaiduMap.addOverlay(textOption9);
        mBaiduMap.addOverlay(textOption10);

//----------------7.对河北师范大学地标性建筑（时光塔、软件学院）需在地图上添加图片显示（标注覆盖物）
        // 定义Maker坐标点
        LatLng point = new LatLng(38.003688, 114.529438);
        LatLng point2 = new LatLng(38.003119, 114.527057);

        // 构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.marker);
        BitmapDescriptor bitmap2 = BitmapDescriptorFactory
                .fromResource(R.drawable.marker);
        // 构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point)// 设置marker的位置
                .icon(bitmap)
                .title("软件学院");// 必须设置marker图标

        OverlayOptions option2 = new MarkerOptions()
                .position(point2)// 设置marker的位置
                .icon(bitmap2)
                .title("时光塔");// 必须设置marker图标
        //在地图上添加Marker，并显示
        Marker marker = (Marker) mBaiduMap.addOverlay(option);
        Marker marker2 = (Marker) mBaiduMap.addOverlay(option2);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


    }

//-----------------6.能够在地图上显示使用本App的其他用户的位置信息。（20分）---------------

    private void initRadarSearch() {
//  获取周边雷达实例
        mRadarSearchManager =
                RadarSearchManager.getInstance();
//  周边雷达设置监听， RadarSearchListener 接口实现
        mRadarSerchListener = new MyRadarSearchListener();
        mRadarSearchManager.addNearbyInfoListener(mRadarSerchListener);
//  周边雷达设置用户身份标识， id 为 null 是设备标识，必须设置
        mRadarSearchManager.setUserID(mUserID);
    }

//----------------------5.能够获取实时定位信息，并在地图上对实时位置进行显示。--------------------

    private void initMyLocation() {
//  定位 SDK 初始化
        mLocationClient = new
                LocationClient(getApplicationContext());
//  设置定位的相关配置
        LocationClientOption option = new
                LocationClientOption();
        option.setOpenGps(true); //  打开 gps
        option.setCoorType("bd09ll"); //  设置坐标类型
        option.setScanSpan(1000); //  自动定位间隔
        option.setIsNeedAddress(true);//  是否需要地址
        option.setIsNeedLocationPoiList(true);
//  定位模式
        option.setLocationMode(LocationClientOption.LocationMode.
                Hight_Accuracy);
//  根据配置信息对定位客户端进行设置
        mLocationClient.setLocOption(option);
//  注册定位监听
        mMyLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(mMyLocationListener);

        //  构建 Marker 图标
        int n;
        if(mUserID.equals(" 钢铁侠"))
            n = R.drawable.gangtiexia;
        else if(mUserID.equals(" 蝙蝠侠"))
            n = R.drawable.bianfuxia;
        else if(mUserID.equals(" 闪电侠"))
            n = R.drawable.shandianxia;
        else
            n = R.drawable.sishen;
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(n);

//  设置定位图标

        MyLocationConfiguration config = new
                MyLocationConfiguration(
                MyLocationConfiguration.LocationMode.NORMAL,
                true,
                bitmap);
        mBaiduMap.setMyLocationConfigeration(config);
    }
    /**
     *  实现实位回调监听
     */
    public class MyLocationListener implements
            BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
// mapView  销毁后不在处理新接收的位置
            if (location == null || mMapView == null)
                return;
//  构造定位数据
            MyLocationData locData = new
                    MyLocationData.Builder()
//  此处设置开发者获取到的方向信息，顺时针 0-360
                    .latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build
                            ();
//  设置 BaiduMap 的定位数据
            mBaiduMap.setMyLocationData(locData);
//  记录位置信息
            mCurrentLantitude = location.getLatitude();
            mCurrentLongitude = location.getLongitude();
//  第一次定位时，将地图位置移动到当前位置
            if (isFristLocation) {
                isFristLocation = false;
                center2myLoc();
            }
// Log 记录位置信息
            StringBuffer sb = new StringBuffer(256);
            sb.append("\nlatitude : ");
            sb.append(location.getLatitude());
            sb.append("\nlontitude : ");
            sb.append(location.getLongitude());
            sb.append("\naddress : ");
            sb.append(location.getAddrStr());
            for(int i=0; i<location.getPoiList().size(); i++)
            {
                Poi p = location.getPoiList().get(i);
                sb.append("\nPoi NO.");
                sb.append(i);
                sb.append(" : ");
                sb.append(p.getId());
                sb.append("-");
                sb.append(p.getName());
                sb.append("-");
                sb.append(p.getRank());
            }
            Log.i("BaiduLocationInfo", sb.toString());
        }
    }

    //-----------------------8.提供把地图中心移动到当前定位功能。------------
    private void center2myLoc() {
        LatLng ll = new LatLng(mCurrentLantitude,
                mCurrentLongitude);
//  设置当前定位位置为 BaiduMap 的中心点，并移动到定位位置
        MapStatusUpdate u =
                MapStatusUpdateFactory.newLatLng(ll);
        mBaiduMap.animateMapStatus(u);
    }

    /**
     *  设置周边雷达监听
     */
    public class MyRadarSearchListener
            implements RadarSearchListener,
            RadarUploadInfoCallback {
        /*  上传位置时自动调用的回调接口 */
        @Override
        public RadarUploadInfo onUploadInfoCallback() {
//  将要上传的 Info
            RadarUploadInfo info = new RadarUploadInfo();
// Info 的备注信息
            SimpleDateFormat simpleDateFormat = new
                    SimpleDateFormat("hhmmss");
            Date curDate = new
                    Date(System.currentTimeMillis());
            String str = simpleDateFormat.format(curDate);
            info.comments = str;
// Info 的点信息
            LatLng pt = new LatLng(mCurrentLantitude,
                    mCurrentLongitude);
            info.pt = pt;
//  返回要上传的信息，即上传信息
            return info;
        }
        /*  上传状态监听 */
        @Override
        public void onGetUploadState(RadarSearchError
                                             radarSearchError) {
            SimpleDateFormat simpleDateFormat = new
                    SimpleDateFormat("hh:mm:ss :");
            Date curDate = new
                    Date(System.currentTimeMillis());
            String strTime =
                    simpleDateFormat.format(curDate);
            if (radarSearchError ==
                    RadarSearchError.RADAR_NO_ERROR) {
// 上传成功
                Log.i("RadarUpload", strTime + " 上传成功");
            } else {
// 上传失败
                Log.i("RadarUpload", strTime + " 上传错误：" +
                        radarSearchError.toString());
            }
        }
        /*  查询周边的人监听 */
        @Override
        public void onGetNearbyInfoList(RadarNearbyResult
                                                radarNearbyResult,
                                        RadarSearchError
                                                radarSearchError) {
            if (radarSearchError ==
                    RadarSearchError.RADAR_NO_ERROR) {
                Log.i("RadarUpload", " 查询周边成功");
//  清理覆盖物
                mBaiduMap.clear();
                for (int i=0; i<
                        radarNearbyResult.infoList.size(); i++) {
                    Log.i("RadarUpload", "NO." + i + " : " +
                            radarNearbyResult.infoList.get(i).userID + "\n" +
                            radarNearbyResult.infoList.get(i).comments + "\n" +
                            radarNearbyResult.infoList.get(i).distance + "\n" +
                            radarNearbyResult.infoList.get(i).pt + "\n" +
                            radarNearbyResult.infoList.get(i).timeStamp);
                    addMarker(radarNearbyResult.infoList.get(i).userID,
                            radarNearbyResult.infoList.get(i).pt);
                }
            } else {
                Log.i("RadarUpload", " 查询周边错误：" +
                        radarSearchError.toString());
            }
        }
        /*  清除位置信息监听 */
        @Override
        public void onGetClearInfoState(RadarSearchError radarSearchError) {
            if (radarSearchError ==
                    RadarSearchError.RADAR_NO_ERROR) {
// 清除成功
                Log.i("RadarUpload", " 清除位置成功");
            } else {
// 清除失败
                Log.i("RadarUpload", " 清除位置失败");
            }
        }
    }
    /**
     *  添加标注覆盖物
     */
    private void addMarker(String userID, LatLng pt) {
        int n;
        if(userID.equals(" 钢铁侠"))
            n = R.drawable.gangtiexia;
        else if(userID.equals(" 蝙蝠侠"))
            n = R.drawable.bianfuxia;
        else if(userID.equals(" 闪电侠"))
            n = R.drawable.shandianxia;
        else
            n = R.drawable.sishen;
//  构建 Marker 图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(n);
//  构建 MarkerOption ，用于在地图上添加 Marker
        OverlayOptions option = new MarkerOptions()
                .position(pt)//  设置 marker 的位置
                .icon(bitmap); //  必须设置 marker 图标
// 在地图上添加 Marker ，并显示
        Marker marker =
                (Marker)mBaiduMap.addOverlay(option);
    }
    @Override
    protected void onStart()
    {
//  开启图层定位
        mBaiduMap.setMyLocationEnabled(true);
        if (!mLocationClient.isStarted())
        {
            mLocationClient.start();
        }
        super.onStart();
    }
    @Override
    protected void onStop()
    {
//  关闭图层定位
        mBaiduMap.setMyLocationEnabled(false);
        mLocationClient.stop();
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
//  在 activity 执行 onDestroy 时执行
        mMapView.onDestroy();
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
//  在 activity 执行 onResume 时执行 mMapView. onResume () ，
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
//  在 activity 执行 onPause 时执行 mMapView. onPause () ，
        mMapView.onPause();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_menu_map_myloc: //  我的位置
                center2myLoc();
                break;
            case R.id.id_menu_map_upload: //  上传位置
                mRadarSearchManager.startUploadAuto(mRadarSerchListener,
                        5000);
                break;
            case R.id.id_menu_map_destory: //  销毁位置
//  停止上传位置信息
                mRadarSearchManager.stopUploadAuto();
//  清除用户信息
                mRadarSearchManager.clearUserInfo();
                break;
            case R.id.id_menu_map_search: //  查询周边
//  构造请求参数，其中 centerPt 是自己的位置坐标
                LatLng ll = new LatLng(mCurrentLantitude,
                        mCurrentLongitude);
                RadarNearbySearchOption option
                        = new RadarNearbySearchOption()
                        .centerPt(ll) //  搜索中心点
                        .pageNum(0) //  分页编号
                        .pageCapacity(50) //  每页容量
                        .radius(2000); //  检索半径
//  发起查询请求
                mRadarSearchManager.nearbyInfoRequest(option);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}

