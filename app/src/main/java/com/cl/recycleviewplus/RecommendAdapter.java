package com.cl.recycleviewplus;

import android.content.Context;

public class RecommendAdapter extends MultiItemTypeAdapter{
    public RecommendAdapter(Context context) {
        super(context);
        addDelegate(new SingleColumnPostDelegate());
        addDelegate(new TwoColumnPostDelegate());
        addNoItemDelegate();
    }
}
