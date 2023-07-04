package com.example.glowlane;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {

    private int[] imageResources;
    private String[] imageTexts;
    private Context context;
    private LayoutInflater inflater;

    public ImageAdapter(Context context, int[] imageResources, String[] imageTexts) {
        this.context = context;
        this.imageResources = imageResources;
        this.imageTexts = imageTexts;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imageResources.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            view = inflater.inflate(R.layout.grid_item, parent, false);

            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.imageView);
            holder.textView = view.findViewById(R.id.textView);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.imageView.setImageResource(imageResources[position]);
        holder.textView.setText(imageTexts[position]);

        return view;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
