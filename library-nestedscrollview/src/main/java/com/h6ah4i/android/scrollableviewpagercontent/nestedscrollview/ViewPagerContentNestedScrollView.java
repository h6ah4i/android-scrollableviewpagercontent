package com.h6ah4i.android.scrollableviewpagercontent.nestedscrollview;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.h6ah4i.android.scrollableviewpagercontent.ScrollableViewPagerContentTouchEventDelegator;

public class ViewPagerContentNestedScrollView extends NestedScrollView {
    private ScrollableViewPagerContentTouchEventDelegator mPagerContentTouchEventDelegator;

    public ViewPagerContentNestedScrollView(@NonNull Context context) {
        super(context);
    }

    public ViewPagerContentNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPagerContentNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
