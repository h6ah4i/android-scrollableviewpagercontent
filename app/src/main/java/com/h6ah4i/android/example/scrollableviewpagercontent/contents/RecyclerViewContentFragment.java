package com.h6ah4i.android.example.scrollableviewpagercontent.contents;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.h6ah4i.android.example.scrollableviewpagercontent.R;
import com.h6ah4i.android.scrollableviewpagercontent.recyclerview.ViewPagerContentRecyclerViewTouchEventInterceptor;

public class RecyclerViewContentFragment extends Fragment {
    public static RecyclerViewContentFragment newInstance(boolean enabled) {
        Bundle args = new Bundle();
        args.putBoolean("SVPC_ENABLED", enabled);

        RecyclerViewContentFragment fragment = new RecyclerViewContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.page_fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        if (getArguments().getBoolean("SVPC_ENABLED")) {
            recyclerView.addOnItemTouchListener(new ViewPagerContentRecyclerViewTouchEventInterceptor());
        }
        recyclerView.setAdapter(new MyRecyclerViewAdapter());
    }

    private static class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            final View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.textView.setText(Integer.toString(position));
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
