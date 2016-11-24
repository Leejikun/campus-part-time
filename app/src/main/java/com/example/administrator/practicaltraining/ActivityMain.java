package com.example.administrator.practicaltraining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class ActivityMain extends Activity {

    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e
    };
    //存放图片的标题
    private String[]  titles = new String[]{
            "青龙团队",
            "是一个具有很高的专业技能的团队",
            "为您实现梦想为己任",
            "传递有价值的信息",
            "带你飞"
    };
    private TextView title;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    private ListView listView;
    private List<Map<String, Object>> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaa);
        mViewPaper = (ViewPager) findViewById(R.id.vp);

        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.dot_0));
        dots.add(findViewById(R.id.dot_1));
        dots.add(findViewById(R.id.dot_2));
        dots.add(findViewById(R.id.dot_3));
        dots.add(findViewById(R.id.dot_4));

        title = (TextView) findViewById(R.id.title);
        title.setText(titles[0]);

        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);

        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.dot_focused);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

        listView = (ListView) findViewById(R.id.lv);
        mData = getData();
        MyAdapter adapter2 = new MyAdapter(this);
        listView.setAdapter(adapter2);

    }
    // ------------------------Listview---------------------------
    public final class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView info;
        public TextView address;
        public TextView workTime;
        public TextView howPay;
        public TextView wages;
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "快乐柠檬前台饮料调制");
        map.put("info", "快乐柠檬万达店");
        map.put("address","裕华区");
        map.put("workTime","11:00-2:00");
        map.put("howPay","月结");
        map.put("wages","40元/天");
        map.put("img", R.drawable.icon_2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "麦当劳服务生");
        map.put("info", "麦当劳中国");
        map.put("address","裕华区");
        map.put("workTime","5:00-9:00");
        map.put("howPay","月结");
        map.put("wages","50元/天");
        map.put("img", R.drawable.icon_6);
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("title", "外卖送餐员");
        map.put("info", "青龙吃得饱盒饭");
        map.put("address","师大校内");
        map.put("workTime","10:00-1:30");
        map.put("howPay","月结");
        map.put("wages","40元/天");
        map.put("img", R.drawable.icon_7);
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("title", "起航动力教育发单员");
        map.put("info", "起航动力教育");
        map.put("address","师大校内");
        map.put("workTime","11:00-1:00");
        map.put("howPay","日结");
        map.put("wages","10元/时");
        map.put("img", R.drawable.icon_3);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "代取快递");
        map.put("info", "风火轮代取快递");
        map.put("address","师大校内");
        map.put("workTime","5:00-7:00");
        map.put("howPay","日结");
        map.put("wages","20元/天");
        map.put("img", R.drawable.icon_8);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "贝小芬少儿小提琴教师");
        map.put("info", "贝小芬少儿艺术教育学校");
        map.put("address","桥东区");
        map.put("workTime","8:00-11:00");
        map.put("howPay","月结");
        map.put("wages","80元/天");
        map.put("img", R.drawable.icon_4);

        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "中国农民工协会校园负责人");
        map.put("info", "中国农民工管理协会");
        map.put("address","师大校内");
        map.put("workTime","全天");
        map.put("howPay","月结");
        map.put("wages","40元/天");
        map.put("img", R.drawable.icon_5);
        list.add(map);
        return list;
    }



    public class MyAdapter extends BaseAdapter{

        private LayoutInflater mInflater;


        public MyAdapter(Context context){
            this.mInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mData.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            if (convertView == null) {

                holder=new ViewHolder();

                convertView = mInflater.inflate(R.layout.bbb, null);
                holder.img = (ImageView)convertView.findViewById(R.id.img);
                holder.title = (TextView)convertView.findViewById(R.id.title);
                holder.info = (TextView)convertView.findViewById(R.id.info);
                holder.address = (TextView)convertView.findViewById(R.id.address);
                holder.workTime = (TextView)convertView.findViewById(R.id.workTime);
                holder.howPay = (TextView)convertView.findViewById(R.id.howPay);
                holder.wages = (TextView)convertView.findViewById(R.id.wages);
                convertView.setTag(holder);

            }else {

                holder = (ViewHolder)convertView.getTag();
            }


            holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
            holder.title.setText((String)mData.get(position).get("title"));
            holder.info.setText((String)mData.get(position).get("info"));
            holder.address.setText((String)mData.get(position).get("address"));
            holder.workTime.setText((String)mData.get(position).get("workTime"));
            holder.howPay.setText((String)mData.get(position).get("howPay"));
            holder.wages.setText((String)mData.get(position).get("wages"));

            return convertView;
        }

    }



    private class ViewPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
//			super.destroyItem(container, position, object);
//			view.removeView(view.getChildAt(position));
//			view.removeViewAt(position);
            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            return images.get(position);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }


    private class ViewPageTask implements Runnable{

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler =  new Handler(){
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        };
    };
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }

}
