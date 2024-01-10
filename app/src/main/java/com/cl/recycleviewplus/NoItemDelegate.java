package com.cl.recycleviewplus;

public class NoItemDelegate<T> implements IItemDelegate<T> {
    @Override
    public boolean isForViewType(T data, int position) {
        return true;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_no_content;
    }

    @Override
    public void parse(ViewHolder holder, T data, int position) {
        // do nothing.
    }
}
