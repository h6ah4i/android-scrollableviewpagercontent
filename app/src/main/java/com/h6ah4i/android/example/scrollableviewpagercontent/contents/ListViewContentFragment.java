package com.h6ah4i.android.example.scrollableviewpagercontent.contents;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.h6ah4i.android.example.scrollableviewpagercontent.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewContentFragment extends Fragment {
    public static ListViewContentFragment newInstance(boolean enabled) {
        Bundle args = new Bundle();
        args.putBoolean("SVPC_ENABLED", enabled);

        ListViewContentFragment fragment = new ListViewContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int resId = getArguments().getBoolean("SVPC_ENABLED")
                ? R.layout.page_fragment_list_view
                : R.layout.page_fragment_normal_list_view;

        return inflater.inflate(resId, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = view.findViewById(R.id.list_view);

        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(Integer.toString(i));
        }
        listView.setAdapter(new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, android.R.id.text1, items));
    }
}
