package com.havelisolutions.genericapplication.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration: RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        parent.adapter?.itemCount?.let {
            if(it>2)
            if (parent.getChildAdapterPosition(view) == it-1) {
                outRect.top = 120
            }
        }
        // only for the last one

    }
}