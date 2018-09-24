package com.h6ah4i.android.example.scrollableviewpagercontent.contents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.h6ah4i.android.example.scrollableviewpagercontent.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NestedScrollViewContentFragment extends Fragment {
    public static NestedScrollViewContentFragment newInstance(boolean enabled) {
        Bundle args = new Bundle();
        args.putBoolean("SVPC_ENABLED", enabled);

        NestedScrollViewContentFragment fragment = new NestedScrollViewContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int resId = getArguments().getBoolean("SVPC_ENABLED")
                ? R.layout.page_fragment_nested_scroll_view
                : R.layout.page_fragment_normal_nested_scroll_view;

        return inflater.inflate(resId, container, false);
    }
}
