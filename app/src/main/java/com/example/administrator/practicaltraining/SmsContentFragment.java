package com.example.administrator.practicaltraining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class SmsContentFragment extends Fragment {
    private ListView listView;
    private SmsContentAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
        boolean tag  = false;
        for(int i=0;i<10;i++){
            Map<String, Object> map  = new HashMap<String, Object>();
            map.put("content", "欢迎加入"+i);
            map.put("isReceive", tag);
            data.add(map);
            tag=tag==false?true:false;
        }
        adapter = new SmsContentAdapter(getActivity(), data);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_main, container,false);
        listView  = (ListView) view.findViewById(R.id.sms_content_listview);
        listView.setAdapter(adapter);
        listView.setDivider(null);
        adapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
    }
}
