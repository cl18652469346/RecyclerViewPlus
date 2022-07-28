package com.cl.recycleviewplus;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MultiItemTypeAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    private List<T> mDateList;
    private ItemDelegateManger<T> mDelegateManager = new ItemDelegateManger<>();

    private void setDataList(List<T> dateList) {
        mDateList = dateList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        IItemDelegate itemViewDelegate = mDelegateManager.getItemViewDelegate(viewType);
        ViewHolder holder = ViewHolder.createViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(itemViewDelegate.getItemViewLayoutId(), parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mDelegateManager == null) {
            return;
        }
        mDelegateManager.parseData(holder, mDateList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mDateList == null ? 0 : mDateList.size();
    }
}
