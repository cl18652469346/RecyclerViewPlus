package com.cl.recycleviewplus;

import androidx.collection.SparseArrayCompat;

public class ItemDelegateManger<T> {
    private static final int NO_ITEM_VIEW_TYPE = -1;
    private SparseArrayCompat<IItemDelegate> mDelegates = new SparseArrayCompat<>();

    public ItemDelegateManger addDelegate(IItemDelegate<T> delegate) {
        if (null == mDelegates) {
            mDelegates = new SparseArrayCompat<>();
        }
        mDelegates.put(mDelegates.size(), delegate);
        return this;
    }

    public ItemDelegateManger addDelegate(int viewType, IItemDelegate<T> delegate) {
        if (null == mDelegates) {
            mDelegates = new SparseArrayCompat<>();
        }
        mDelegates.put(viewType, delegate);
        return this;
    }

    public ItemDelegateManger addNoItemDelegate() {
        if (null == mDelegates) {
            mDelegates = new SparseArrayCompat<>();
        }
        mDelegates.put(NO_ITEM_VIEW_TYPE, new NoItemDelegate());
        return this;
    }

    public IItemDelegate getItemViewDelegate(int viewType) {
        return mDelegates.get(viewType);
    }

    public int getItemViewType(T data, int position) {
        for (int i = mDelegates.size() - 1; i >= 0; i--) {
            IItemDelegate delegate = mDelegates.valueAt(i);
            if (delegate.isForViewType(data, position)) {
                return mDelegates.keyAt(position);
            }
        }
        return NO_ITEM_VIEW_TYPE;
    }

    public void parseData(ViewHolder holder, T data, int position) {
        for (int i = mDelegates.size() - 1; i >= 0; i--) {
            IItemDelegate delegate = mDelegates.valueAt(i);
            if (delegate.isForViewType(data, position)) {
                delegate.parse(holder, data, position);
            }
        }
    }
}
