package com.h6ah4i.android.scrollableviewpagercontent;

import android.content.Context;
import androidx.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class ScrollableViewPagerContentTouchEventDelegator {
    final int mPagingTouchSlop;
    final int mTouchSlop;
    float mInitialMotionX;
    float mInitialMotionY;
    float mLastMotionX;
    float mLastMotionY;
    boolean mCheck;

    public ScrollableViewPagerContentTouchEventDelegator(@NonNull Context context) {
        ViewConfiguration vc = ViewConfiguration.get(context);
        mPagingTouchSlop = vc.getScaledPagingTouchSlop();
        mTouchSlop = vc.getScaledTouchSlop();
    }

    public boolean onInterceptTouchEvent(@NonNull View scrollableView, @NonNull MotionEvent ev) {
        return onHandleTouchEvent(scrollableView, ev, true);
    }

    public boolean onTouchEvent(@NonNull View scrollableView, @NonNull MotionEvent ev) {
        return onHandleTouchEvent(scrollableView, ev, false);
    }

    protected boolean onHandleTouchEvent(View scrollableView, MotionEvent ev, boolean intercept) {
        final int action = ev.getActionMasked();
        boolean handled = false;

        if (action == MotionEvent.ACTION_DOWN) {
            mCheck = true;
            mInitialMotionX = ev.getX();
            mInitialMotionY = ev.getY();
        } else if (action == MotionEvent.ACTION_MOVE && mCheck) {
            final float xDiff = Math.abs(ev.getX() - mLastMotionX);
            final float yDiff = Math.abs(ev.getY() - mLastMotionY);

            if (Math.abs(ev.getY() - mInitialMotionY) > mTouchSlop) {
                mCheck = false;
            } else if ((Math.abs(ev.getX() - mInitialMotionX) > mPagingTouchSlop) && (xDiff > yDiff)) {
                scrollableView.getParent().requestDisallowInterceptTouchEvent(false);
                handled = true;
            }
        } else {
            mCheck = false;
        }

        mLastMotionX = ev.getX();
        mLastMotionY = ev.getY();

        return handled;
    }
}
