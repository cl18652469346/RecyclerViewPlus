package com.cl.recycleviewplus;

public interface IItemDelegate<T> {
    boolean isForViewType(T data, int position);

    int getItemViewLayoutId();

    void parse(ViewHolder holder, T data, int position);
}
