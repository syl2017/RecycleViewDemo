package com.example.syl.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by syl on 2017/4/30.
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private Context mContext;
    private List<Partner> mPartner;

    public FruitAdapter() {


    }
    public void ChangeData(List<Partner> mPartner){
        this.mPartner = mPartner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycleview_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "TextView", Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Partner partner = mPartner.get(position);
        holder.textview.setText(partner.getName());
        Glide.with(mContext).load(partner.getImageId()).into(holder.imageview);
    }

    @Override
    public int getItemCount() {
        return mPartner.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public   ImageView imageview;
        public   TextView textview;

        public ViewHolder(View itemView) {
            super(itemView);
            imageview = (ImageView) itemView.findViewById(R.id.fruit_image);
            textview = (TextView) itemView.findViewById(R.id.fruit_textview);
        }
    }
}

