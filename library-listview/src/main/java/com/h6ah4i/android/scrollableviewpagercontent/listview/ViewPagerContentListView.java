package com.h6ah4i.android.scrollableviewpagercontent.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

import com.h6ah4i.android.scrollableviewpagercontent.ScrollableViewPagerContentTouchEventDelegator;

/**
 * Created by hasegawa on 2018/03/04.
 */

public class ViewPagerContentListView extends ListView {
    ScrollableViewPagerContentTouchEventDelegator mPagerContentTouchEventDelegator;

    public ViewPagerContentListView(Context context) {
        super(context);
    }

    public ViewPagerContentListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPagerContentListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ScrollableViewPagerContentTouchEventDelegator ensureDelegator() {
        if (mPagerContentTouchEventDelegator == null) {
            mPagerContentTouchEventDelegator = new ScrollableViewPagerContentTouchEventDelegator(getContext());
        }
        return mPagerContentTouchEventDelegator;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ensureDelegator().onInterceptTouchEvent(this, ev)) {
            return true;
        }

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouchEvent(MotionEvent ev) {
        if (ensureDelegator().onTouchEvent(this, ev)) {
            return true;
        }

        return super.onTouchEvent(ev);
    }
}
