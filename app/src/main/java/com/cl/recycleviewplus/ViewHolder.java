package com.cl.recycleviewplus;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    private SparseArrayCompat<View> mViewArray = new SparseArrayCompat<>();
    private View mItemView;

    private ViewHolder(@NonNull View itemView) {
        super(itemView);
        mItemView = itemView;
    }

    private ViewHolder(Context context, @NonNull View itemView) {
        super(itemView);
        mContext = context;
        mItemView = itemView;
    }

    public static ViewHolder createViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    public static ViewHolder createViewHolder(Context context, View itemView) {
        return new ViewHolder(context, itemView);
    }

    public View getView(int viewId) {
        View view = mViewArray.get(viewId);
        if (null == view) {
            view = mItemView.findViewById(viewId);
            mViewArray.put(viewId, view);
        }
        return view;
    }
}
