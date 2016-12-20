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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityEnteylist_3 extends AppCompatActivity {

    private TextView name;
    private ListView listView;
    private List<Map<String, Object>> mData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enteylist_3);

        findViewById(R.id.bmlb_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        name=(TextView)findViewById(R.id.name);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();

        String name1=bundle.getString("title");
        name.setText(name1);

        listView = (ListView) findViewById(R.id.lv_bmlb_2);
        mData = getData();
        NumberAdapter adapter2 = new NumberAdapter(this);
        listView.setAdapter(adapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent();
                intent.setClass(getBaseContext(),ActivityResume_num.class);
                Bundle bundle = new Bundle();
                bundle.putString("num_name", (String)mData.get(position).get("num_name"));
                bundle.putString("num_sex", (String)mData.get(position).get("num_sex"));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("num_name", "王行行");
        map.put("num_phone", "15231170278");
        map.put("num_sex", "男1");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("num_name", "李方方");
        map.put("num_phone", "13812345678");
        map.put("num_sex", "女2");
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("num_name", "魏松松");
        map.put("num_phone", "13100136719");
        map.put("num_sex", "男3");
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("num_name", "邱贱贱");
        map.put("num_phone", "15236987412");
        map.put("num_sex", "男4");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("num_name", "田哲哲");
        map.put("num_phone", "13784615986");
        map.put("num_sex", "男5");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("num_name", "王旺旺");
        map.put("num_phone", "15268745982");
        map.put("num_sex", "男6");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("num_name", "刘通通");
        map.put("num_phone", "13741741741");
        map.put("num_sex", "男7");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("num_name", "秦欣欣");
        map.put("num_phone", "15269842364");
        map.put("num_sex", "女8");
        list.add(map);

        return list;
    }

    public class NumberAdapter extends BaseAdapter {

        private LayoutInflater mInflater;


        public NumberAdapter(Context context){
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

            Number holder = null;
            if (convertView == null) {

                holder=new Number();

                convertView = mInflater.inflate(R.layout.item_number, null);
                holder.num_name = (TextView) convertView.findViewById(R.id.num_name);
                holder.num_phone = (TextView)convertView.findViewById(R.id.num_phone);
                convertView.setTag(holder);

            }else {

                holder = (Number) convertView.getTag();
            }


            holder.num_name.setText((String)mData.get(position).get("num_name"));
            holder.num_phone.setText((String)mData.get(position).get("num_phone"));

            return convertView;
        }

    }
}
