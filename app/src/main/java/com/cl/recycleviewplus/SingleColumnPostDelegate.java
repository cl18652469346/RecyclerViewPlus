package com.cl.recycleviewplus;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.cl.recycleviewplus.bean.HomeData;

public class SingleColumnPostDelegate implements IItemDelegate<HomeData> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.single_column_post;
    }

    @Override
    public boolean isForViewType(HomeData data, int position) {
        return data.getPicList().size() == 1;
    }

    @Override
    public void parse(ViewHolder holder, HomeData data, int position) {
        TextView userName = (TextView) holder.getView(R.id.user_name);
        TextView postContext = (TextView) holder.getView(R.id.post_content);
        ImageView postImage = (ImageView) holder.getView(R.id.post_image);
        userName.setText(data.getUserName());
        postContext.setText(data.getContext());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) postImage.getLayoutParams();
        layoutParams.height = ScreenUtil.getScreenWidth(holder.itemView.getContext()) / 21 * 9;
        postImage.setLayoutParams(layoutParams);
        Glide.with(holder.itemView.getContext()).load(data.getPicList().get(0)).into(postImage);
    }
}
