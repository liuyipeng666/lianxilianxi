package com.example.dadadada.amessage.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baweigame.xmpplibrary.entity.MsgEntity;
import com.example.dadadada.R;
import com.example.dadadada.amessage.entity.MessageUserEntity;
import com.example.dadadada.amessage.entity.ReceiveMsgEntity;
import com.example.dadadada.common.SpUtils;

import java.util.List;

public class MsgUserAdapter extends RecyclerView.Adapter<MsgUserAdapter.ViewHolder> {

    private Context context;
    private List<MsgEntity> list;

    public MsgUserAdapter(Context context, List<MsgEntity> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = null;

        if (viewType == 1){
            inflate = LayoutInflater.from(context).inflate(R.layout.msguser2, parent, false);
        }else if (viewType == 2){
            inflate = LayoutInflater.from(context).inflate(R.layout.msguser, parent, false);
        }
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (list.size()==0){
            Log.d("适配器","暂无数据");
            return;
        }
        MsgEntity msgEntity = list.get(position);
        holder.user.setText(msgEntity.getFrom());
        holder.msg.setText(msgEntity.getMsg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.size() == 0){
            return -1;
        }
        MsgEntity msgEntity = list.get(position);
        String name = SpUtils.name(context);
        if (msgEntity.getFrom().equals(name)){
            return 1;
        }else{
            return 2;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView user;
        TextView msg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.user_tv);
            msg = itemView.findViewById(R.id.msg_tv);
        }
    }
}
