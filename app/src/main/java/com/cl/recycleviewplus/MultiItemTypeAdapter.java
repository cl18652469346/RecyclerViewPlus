package com.cl.recycleviewplus;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MultiItemTypeAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List mDateList = new ArrayList();

    protected Context mContext;

    private ItemDelegateManger mDelegateManager = new ItemDelegateManger<>();

    public void setDataList(List dateList) {
        mDateList = dateList;
        notifyDataSetChanged();
    }

    public MultiItemTypeAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        IItemDelegate itemViewDelegate = mDelegateManager.getItemViewDelegate(viewType);
        ViewHolder holder = ViewHolder.createViewHolder(itemViewDelegate.getItemViewLayoutId(), parent);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        mDelegateManager.parseData(holder, mDateList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mDateList == null ? 0 : mDateList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (useDelegateManager()) {
            return mDelegateManager.getItemViewType(mDateList.get(position), position);
        } else {
            return super.getItemViewType(position);
        }
    }

    private boolean useDelegateManager() {
        return mDelegateManager.getDelegates().size() > 0;
    }

    public void addDelegate(IItemDelegate delegate) {
        mDelegateManager.addDelegate(delegate);
    }

    public void addNoItemDelegate() {
        mDelegateManager.addNoItemDelegate();
    }
}
