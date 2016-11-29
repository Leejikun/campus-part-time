package com.example.administrator.practicaltraining;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ActivityHometeacher extends Activity {
    private TextView name;
    private ListView listView;
    private List<Map<String, Object>> mData;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hometeacher);
        name=(TextView)findViewById(R.id.name);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        String name1=bundle.getString("name");
        name.setText(name1);

        listView = (ListView) findViewById(R.id.lv_fl);
        mData = getData();
        MyAdapter adapter2 = new MyAdapter(this);
        listView.setAdapter(adapter2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                intent.setClass(getBaseContext(),Activitydetails.class);
                Bundle bundle = new Bundle();
                bundle.putInt("image", (Integer) mData.get(position).get("img"));
                bundle.putString("title", (String)mData.get(position).get("title"));
                bundle.putString("info", (String)mData.get(position).get("info"));
                bundle.putString("address", (String)mData.get(position).get("address"));
                bundle.putString("workTime", (String)mData.get(position).get("workTime"));
                bundle.putString("howPay", (String)mData.get(position).get("howPay"));
                bundle.putString("wages", (String)mData.get(position).get("wages"));
                //  bundle.putString("title1", titles1[i]);
                intent.putExtras(bundle);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), (String)mData.get(position).get("title"), Toast.LENGTH_LONG).show();
            }
        });
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

    public final static class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView info;
        public TextView address;
        public TextView workTime;
        public TextView howPay;
        public TextView wages;
    }

    public class MyAdapter extends BaseAdapter {

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

                convertView = mInflater.inflate(R.layout.item_parttime, null);
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

}
