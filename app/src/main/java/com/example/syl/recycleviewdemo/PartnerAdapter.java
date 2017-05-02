package com.example.syl.recycleviewdemo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by syl on 2017/4/27.
 */

public class PartnerAdapter extends RecyclerView.Adapter<PartnerAdapter.ViewHolder> {
    private  List<Partner> mPartnerList;
    private Context mContext;

    public PartnerAdapter(List<Partner> partnerList) {
        mPartnerList=partnerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();

        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.partner_item,parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Partner partner = mPartnerList.get(position);
        holder.partnerName.setText(partner.getName());
        Glide.with(mContext).load(partner.getImageId()).into(holder.partnerImage);
    }

    @Override
    public int getItemCount() {
        return mPartnerList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView partnerImage;
        TextView partnerName;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView;
            partnerImage= (ImageView) itemView.findViewById(R.id.parter_image);
            partnerName = (TextView) itemView.findViewById(R.id.parter_name);

        }
    }


}
