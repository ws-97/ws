package com.example.recycleview;

import android.content.Context;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ws
 * @Date 2020/8/26 14:25
 * @Version 1.0
 */
public class DefaultAdapter extends RecyclerView.Adapter<DefaultAdapter.MyViewHolder> {

    private List<String> mList;
    private Context mContext;

    private List<Integer> mHeight=new ArrayList<>();
    public DefaultAdapter(Context context,List<String> list) {
        this.mContext=context;
        this.mList=list;

    }

    //继承该方法用来加载条目布局
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder holder=new MyViewHolder(LayoutInflater.from(mContext)
        .inflate(R.layout.testitem,parent,false));


        for(int i=0;i<mList.size();i++){
            mHeight.add((int)(100+Math.random()*300));
        }
        return holder;
    }

    //继承该方法用来将试图与数据进行绑定
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ViewGroup.LayoutParams layoutParams=holder.textView.getLayoutParams();
        layoutParams.height=mHeight.get(position);
        holder.textView.setLayoutParams(layoutParams);
        holder.textView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_text);
        }
    }
}
