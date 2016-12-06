package com.example.wlw.weixing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wlw on 2016/12/6.
 */
public class MsgAdapter extends ArrayAdapter<Msg>{
    public MsgAdapter(Context context, int resource, List<Msg>odjects){
        super(context,resource,odjects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Msg msg=getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item_msg,parent,false);
        }
        TextView leftTextView,rightTextView;
        leftTextView=(TextView)convertView.findViewById(R.id.list_item_right_textview);
        rightTextView=(TextView)convertView.findViewById(R.id.list_item_right_textview);
        if(msg.getmType()==msg.TYPE_RECEIVED){
            rightTextView.setVisibility(View.GONE);
            leftTextView.setVisibility(View.VISIBLE);
            leftTextView.setText(msg.getmContent());
        }else {
            leftTextView.setVisibility(View.GONE);
            rightTextView.setVisibility(View.VISIBLE);
            rightTextView.setText(msg.getmContent());
        }
        return convertView;
    }

}
