package com.example.administrator.practicaltraining;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityEntrylist_2 extends AppCompatActivity {

    private ListView listView;
    private List<Map<String, Object>> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrylist_2);

        findViewById(R.id.bmlb_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView = (ListView) findViewById(R.id.lv_bmlb);
        mData = getData();
        MyAdapter adapter2 = new MyAdapter(this);
        listView.setAdapter(adapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                intent.setClass(getBaseContext(),ActivityEnteylist_3.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", (String)mData.get(position).get("title"));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "快乐柠檬前台饮料调制");
        map.put("number", "36");
        map.put("img", R.drawable.icon_2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "麦当劳服务生");
        map.put("number", "12");
        map.put("img", R.drawable.icon_6);
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("title", "外卖送餐员");
        map.put("number", "62");
        map.put("img", R.drawable.icon_7);
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("title", "起航动力教育发单员");
        map.put("number", "77");
        map.put("img", R.drawable.icon_3);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "代取快递");
        map.put("number", "68");
        map.put("img", R.drawable.icon_8);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "贝小芬少儿小提琴教师");
        map.put("number", "45");
        map.put("img", R.drawable.icon_4);

        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "中国农民工协会校园负责人");
        map.put("number", "5");
        map.put("img", R.drawable.icon_5);
        list.add(map);
        return list;
    }

    public final static class ViewHolder {
        public ImageView img;
        public TextView title;
        public TextView info;
        public TextView address;
        public TextView workTime;
        public TextView howPay;
        public TextView wages;
        public TextView number;
    }

    public class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;


        public MyAdapter(Context context) {
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

                holder = new ViewHolder();

                convertView = mInflater.inflate(R.layout.item_bmlb, null);
                holder.img = (ImageView) convertView.findViewById(R.id.img);
                holder.title = (TextView) convertView.findViewById(R.id.title);
                holder.number = (TextView) convertView.findViewById(R.id.number);
                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }


            holder.img.setBackgroundResource((Integer) mData.get(position).get("img"));
            holder.title.setText((String) mData.get(position).get("title"));
            holder.number.setText((String) mData.get(position).get("number"));

            return convertView;
        }

    }
}
