package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private String[] itemList;
    private int[] itemIcons;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, String[] itemList, int[] itemIcons) {
        this.context = context;
        this.itemList = itemList;
        this.itemIcons = itemIcons;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.length;
    }

    @Override
    public Object getItem(int position) {
        return itemList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView name;
        ImageView item;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.level_name);
            holder.item = convertView.findViewById(R.id.level_image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(itemList[position]);
        holder.item.setImageResource(itemIcons[position]);

        return convertView;
    }
}
