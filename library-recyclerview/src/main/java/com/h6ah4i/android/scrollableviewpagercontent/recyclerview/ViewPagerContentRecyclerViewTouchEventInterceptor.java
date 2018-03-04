package com.h6ah4i.android.scrollableviewpagercontent.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import com.h6ah4i.android.scrollableviewpagercontent.ScrollableViewPagerContentTouchEventDelegator;

public class ViewPagerContentRecyclerViewTouchEventInterceptor implements RecyclerView.OnItemTouchListener {
    private ScrollableViewPagerContentTouchEventDelegator mPagerContentTouchEventDelegator;

    private ScrollableViewPagerContentTouchEventDelegator ensureDelegator(RecyclerView recyclerView) {
        if (mPagerContentTouchEventDelegator == null) {
            mPagerContentTouchEventDelegator = new ScrollableViewPagerContentTouchEventDelegator(recyclerView.getContext());
        }
        return mPagerContentTouchEventDelegator;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return ensureDelegator(rv).onInterceptTouchEvent(rv, e);
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        ensureDelegator(rv).onTouchEvent(rv, e);
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}
