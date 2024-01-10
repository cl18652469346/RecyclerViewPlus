package com.cl.recycleviewplus;

import android.util.Log;

import androidx.collection.SparseArrayCompat;

public class ItemDelegateManger<T> {
    private static final String TAG = "ItemDelegateManger";

    private static final int NO_ITEM_VIEW_TYPE = -1;

    private SparseArrayCompat<IItemDelegate<T>> mDelegates = new SparseArrayCompat<>();

    public ItemDelegateManger addDelegate(IItemDelegate<T> delegate) {
        mDelegates.put(mDelegates.size(), delegate);
        return this;
    }

    public ItemDelegateManger addDelegate(int viewType, IItemDelegate<T> delegate) {
        if (getItemViewDelegate(viewType) != null) {
            Log.i(TAG, "delegate has contains." + delegate);
        }
        mDelegates.put(viewType, delegate);
        return this;
    }

    public ItemDelegateManger addNoItemDelegate() {
        mDelegates.put(NO_ITEM_VIEW_TYPE, new NoItemDelegate());
        return this;
    }

    public IItemDelegate<T> getItemViewDelegate(int viewType) {
        return mDelegates.get(viewType);
    }

    public int getItemViewType(T data, int position) {
        // 逆序遍历,因为mDelegates会从-1开始.
        for (int i = mDelegates.size() - 1; i >= 0; i--) {
            IItemDelegate<T> delegate = mDelegates.valueAt(i);
            if (delegate.isForViewType(data, position)) {
                return mDelegates.keyAt(i);
            }
        }
        return NO_ITEM_VIEW_TYPE;
    }

    public void parseData(ViewHolder holder, T data, int position) {
        for (int i = mDelegates.size() - 1; i >= 0; i--) {
            IItemDelegate<T> delegate = mDelegates.valueAt(i);
            if (delegate instanceof NoItemDelegate) {
                continue;
            }
            if (delegate.isForViewType(data, position)) {
                delegate.parse(holder, data, position);
            }
        }
    }

    public SparseArrayCompat<IItemDelegate<T>> getDelegates() {
        return mDelegates;
    }
}
