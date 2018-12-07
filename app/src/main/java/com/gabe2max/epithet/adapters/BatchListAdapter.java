package com.gabe2max.epithet.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gabe2max.epithet.R;

import java.util.ArrayList;
import java.util.List;

public class BatchListAdapter extends BaseAdapter {
    private final Context context;
    private final List<BatchItem> values;
    public BatchListAdapter(@NonNull Context context, List<BatchItem> values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int position) {
        return values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return values.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.fragment_list_item, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.BatchImage);
        TextView titleView = (TextView) rowView.findViewById(R.id.BatchText);
        TextView pointView = (TextView) rowView.findViewById(R.id.PointText);

        BatchItem item = (BatchItem) values.get(position);
        titleView.setText(item.getTitle()+": "+item.getSize()+" Items");
        pointView.setText("Value: "+item.getPointValue()+" points");
        imageView.setImageBitmap(item.getImage());
        return rowView;
    }
}
