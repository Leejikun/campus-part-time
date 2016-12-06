package com.example.administrator.practicaltraining;

 import java.util.List;
 import java.util.Map;

 import android.app.ActionBar.LayoutParams;
 import android.content.Context;
 import android.media.audiofx.LoudnessEnhancer;
 import android.view.Gravity;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.BaseAdapter;
 import android.widget.LinearLayout;
 import android.widget.RelativeLayout;
 import android.widget.TextView;

public class SmsContentAdapter extends BaseAdapter {
    /**
     * 存放数据的data
     * Map中包含:
     * key=content,内容
     * key=isReceive, true 为接收短信,false为发送短信
     * key=time,接收和发送短信的时间
     */
    private List<Map<String,Object>> data;
    private Context context;
    public SmsContentAdapter(Context context,List<Map<String,Object>> data){
        this.data = data;
        this.context = context;
    }
    @Override
    public int getCount() {
        if(data==null){
            return 0 ;
        }else{
            return data.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView!=null){
            view  = convertView;
        }else{
            view  = LayoutInflater.from(context).inflate(R.layout.sms_content_item, parent,false);
        }
        LinearLayout linearLayout  = (LinearLayout) view.findViewById(R.id.sms_content_linearlayout);
        RelativeLayout relativeLayout  =  (RelativeLayout) view.findViewById(R.id.sms_content_relativelayout);
        TextView textView  = (TextView) view.findViewById(R.id.sms_content_item_textview2);
        Map<String,Object> itemData  = data.get(position);
        boolean isReceive  = (Boolean) itemData.get("isReceive");//获取是否为接收到的短信
        if(isReceive){
            //接收短信中
            linearLayout.setGravity(Gravity.LEFT);
            relativeLayout.setLeft(40);
            relativeLayout.setBackground(context.getResources().getDrawable(R.drawable.sms_receive));
        }else{
            //发送短信中
            linearLayout.setGravity(Gravity.RIGHT);
            relativeLayout.setRight(40);
            relativeLayout.setBackground(context.getResources().getDrawable(R.drawable.sms_send));
        }
        textView.setText((String)itemData.get("content"));
        return view;
    }

}

