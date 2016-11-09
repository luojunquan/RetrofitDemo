package com.example.retrofitdemo.Demo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitdemo.R;

import java.util.Collection;
import java.util.List;

/**
 * Created by：赖上罗小贱 on 2016/10/28
 * 邮箱：ljq@luojunquan.top
 * 个人博客：www.luojunquan.top
 * CSDN:http://blog.csdn.net/u012990171
 */
public class TngouAdapter extends BaseAdapter{
    private Context context;
    private List<Cook> list;
    private LayoutInflater inflater;
    public TngouAdapter(Context context, List<Cook> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
//            convertView = inflater.inflate(R.layout.list_item,null);//用这个报空指针
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            holder.item_title = (TextView) convertView.findViewById(R.id.item_title);
            holder.item_info = (TextView) convertView.findViewById(R.id.item_info);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();
        Cook cook = list.get(position);
        holder.item_title.setText(cook.getName());
        holder.item_info.setText(cook.getDescription());
//        Picasso.with(context).load("http://tnfs.tngou.net/image"
//        + cook.getImg()).into(holder.image);
        Glide.with(context).load("http://tnfs.tngou.net/image"
                + cook.getImg()).into(holder.image);//picasso和glide的用法一样
        return convertView;
    }
    public void addAll(Collection<? extends Cook> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }
    public static class ViewHolder{
        public ImageView image;
        public TextView item_title;
        public TextView item_info;
//        public ViewHolder(View item){
//            image = (ImageView) item.findViewById(R.id.image);
//            item_title = (TextView) item.findViewById(R.id.item_title);
//            item_info = (TextView) item.findViewById(R.id.item_info);
//        }
    }
}

//-------------
/*另外一种写法
@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
            convertView.setTag(new ViewHolder(convertView));
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        Cook cook = list.get(position);
        holder.item_title.setText(cook.getName());
        holder.item_info.setText(cook.getDescription());
//        Picasso.with(context).load("http://tnfs.tngou.net/image"
//        + cook.getImg()).into(holder.image);
        Glide.with(context).load("http://tnfs.tngou.net/image"
                + cook.getImg()).into(holder.image);//picasso和glide的用法一样
        return convertView;
    }
    public void addAll(Collection<? extends Cook> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }
    public static class ViewHolder{
        public ImageView image;
        public TextView item_title;
        public TextView item_info;
        public ViewHolder(View item){
            image = (ImageView) item.findViewById(R.id.image);
            item_title = (TextView) item.findViewById(R.id.item_title);
            item_info = (TextView) item.findViewById(R.id.item_info);
        }
    }
}
 */