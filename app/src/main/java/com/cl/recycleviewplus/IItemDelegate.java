package com.cl.recycleviewplus;

public interface IItemDelegate<T> {
    int getItemViewLayoutId();

    boolean isForViewType(T data, int position);

    void parse(ViewHolder holder, T data, int position);
}
