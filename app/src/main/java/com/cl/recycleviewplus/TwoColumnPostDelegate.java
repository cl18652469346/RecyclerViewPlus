package com.cl.recycleviewplus;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.cl.recycleviewplus.bean.HomeData;

public class TwoColumnPostDelegate implements IItemDelegate<HomeData> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.two_column_post;
    }

    @Override
    public boolean isForViewType(HomeData data, int position) {
        return data.getPicList().size() == 2;
    }

    @Override
    public void parse(ViewHolder holder, HomeData data, int position) {
        TextView userName = (TextView) holder.getView(R.id.user_name);
        TextView postContext = (TextView) holder.getView(R.id.post_content);
        ImageView postImage1 = (ImageView) holder.getView(R.id.post_image1);
        ImageView postImage2 = (ImageView) holder.getView(R.id.post_image2);
        userName.setText(data.getUserName());
        postContext.setText(data.getContext());
        Glide.with(holder.itemView.getContext()).load(data.getPicList().get(0)).into(postImage1);
        Glide.with(holder.itemView.getContext()).load(data.getPicList().get(1)).into(postImage2);
    }
}
