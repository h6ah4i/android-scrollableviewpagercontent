package com.h6ah4i.android.example.scrollableviewpagercontent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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
