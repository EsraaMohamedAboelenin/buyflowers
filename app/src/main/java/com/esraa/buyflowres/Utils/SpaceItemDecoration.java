package com.esraa.buyflowres.Utils;

/**
 * Created by kcs-pc on 12/06/2017.
 */

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by kcs-pc on 18/04/2017.
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private final int mSpace;

    public SpaceItemDecoration(int space) {
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = mSpace;
        outRect.right = mSpace;
        outRect.bottom = mSpace;
        outRect.top=mSpace;


    }}