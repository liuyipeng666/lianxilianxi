package com.example.dadadada.amessage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dadadada.R;
import com.example.dadadada.amessage.entity.MessageUserEntity;
import com.example.dadadada.amessage.entity.ReceiveMsgEntity;

import java.util.List;

public class MsgUserAdapter extends RecyclerView.Adapter<MsgUserAdapter.ViewHolder> {

    private Context context;
    private List<ReceiveMsgEntity> list;

    public MsgUserAdapter(Context context, List<ReceiveMsgEntity> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.msguser, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv.setText(list.get(position)+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.msguser_tv);
        }
    }
}
