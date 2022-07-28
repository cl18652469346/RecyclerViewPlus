package com.cl.recycleviewplus;

public class NoItemDelegate implements IItemDelegate<Object> {
    @Override
    public boolean isForViewType(Object data, int position) {
        return true;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_no_content;
    }

    @Override
    public void parse(ViewHolder holder, Object data, int position) {
        // do nothing.
    }
}
