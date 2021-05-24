package com.example.dadadada.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.dadadada.R;
import com.example.dadadada.mvvm.model.entity.Trace;

import java.util.ArrayList;
import java.util.List;


public class TraceListAdapter extends BaseAdapter {
    private Context context;
    private List<Trace> traceList = new ArrayList<>(1);
    private static final int TYPE_TOP = 0;
    private static final int TYPE_NORMAL= 1;

    public TraceListAdapter(Context context, List<Trace> traceList) {
        this.context = context;
        this.traceList = traceList;
    }

    @Override
    public int getCount() {
        return traceList.size();
    }

    @Override
    public Trace getItem(int position) {
        return traceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        final Trace trace = getItem(position);
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_time, parent, false);
            holder.tvAcceptTime = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tvAcceptStation = (TextView) convertView.findViewById(R.id.tv_activity);
            holder.tvTopLine = (TextView) convertView.findViewById(R.id.tvTopLine);
            holder.tvDot = (TextView) convertView.findViewById(R.id.tvDot);
            convertView.setTag(holder);
        }

        if (getItemViewType(position) == TYPE_TOP) {
            holder.tvTopLine.setVisibility(View.INVISIBLE);
            holder.tvAcceptTime.setTextColor(0xff555555);
            holder.tvAcceptStation.setTextColor(0xff555555);

        } else if (getItemViewType(position) == TYPE_NORMAL) {
            holder.tvTopLine.setVisibility(View.VISIBLE);
            holder.tvAcceptTime.setTextColor(0xff999999);
            holder.tvAcceptStation.setTextColor(0xff999999);

        }

        holder.tvAcceptTime.setText(trace.getAcceptTime());
        holder.tvAcceptStation.setText(trace.getAcceptStation());
        return convertView;
    }

    @Override
    public int getItemViewType(int id) {
        if (id == 0) {
            return TYPE_TOP;
        }
        return TYPE_NORMAL;
    }

    static class ViewHolder {
        public TextView tvAcceptTime, tvAcceptStation;
        public TextView tvTopLine, tvDot;
    }
}
