package com.h6ah4i.android.example.scrollableviewpagercontent;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.core.util.Pair;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.h6ah4i.android.example.scrollableviewpagercontent.contents.ListViewContentFragment;
import com.h6ah4i.android.example.scrollableviewpagercontent.contents.NestedScrollViewContentFragment;
import com.h6ah4i.android.example.scrollableviewpagercontent.contents.RecyclerViewContentFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        TabLayout tabs = findViewById(R.id.tabs);
        ViewPager pager = findViewById(R.id.viewpager);
        pager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(pager);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {
        List<Pair<Fragment, String>> fragments;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
            fragments.add(new Pair(new RecyclerViewContentFragment(), "RecyclerView"));
            fragments.add(new Pair(new NestedScrollViewContentFragment(), "ScrollView"));
            fragments.add(new Pair(new ListViewContentFragment(), "ListView"));
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position).first;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragments.get(position).second;
        }
    }
}
