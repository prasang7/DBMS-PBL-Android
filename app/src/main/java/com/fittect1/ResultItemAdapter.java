package com.fittect1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by prasang on 24/6/16.
 */
public class ResultItemAdapter extends RecyclerView.Adapter<ResultItemAdapter.MyViewHolder> {

    private Context mContext;
    private List<ResultItem> itemList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name, description, address, rate;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tv_resultItem_name);
            description = (TextView) view.findViewById(R.id.tv_resultItem_description);
            address = (TextView) view.findViewById(R.id.tv_resultItem_address);
            rate = (TextView) view.findViewById(R.id.tv_resultItem_rate);
            thumbnail = (ImageView) view.findViewById(R.id.iv_resultItem_backgImage);
        }
    }

    public ResultItemAdapter(Context mContext, List<ResultItem> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ResultItem resultItem = itemList.get(position);
        holder.name.setText(resultItem.getName());
        holder.description.setText(resultItem.getDescription());
        holder.address.setText(resultItem.getAddress());
        holder.rate.setText(resultItem.getRate());

        // loading background image using Glide library
        Glide.with(mContext).load(resultItem.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
