package com.gabe2max.epithet.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gabe2max.epithet.R;

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
        return 0;
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.fragment_list_item, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.BatchImage);
        TextView titleView = (TextView) rowView.findViewById(R.id.BatchText);
        TextView pointView = (TextView) rowView.findViewById(R.id.PointText);

        BatchItem item = values.get(position);
        titleView.setText(item.getTitle());
        pointView.setText(item.getPointValue());
        imageView.setImageBitmap(item.getImage());
        return rowView;
    }
}
