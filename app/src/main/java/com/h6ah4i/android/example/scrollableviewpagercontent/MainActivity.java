package com.h6ah4i.android.example.scrollableviewpagercontent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;

import com.google.android.material.tabs.TabLayout;
import com.h6ah4i.android.example.scrollableviewpagercontent.contents.ListViewContentFragment;
import com.h6ah4i.android.example.scrollableviewpagercontent.contents.NestedScrollViewContentFragment;
import com.h6ah4i.android.example.scrollableviewpagercontent.contents.RecyclerViewContentFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        setupPager(true);
    }

    private void setupPager(boolean enabled) {
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), enabled);

        TabLayout tabs = findViewById(R.id.tabs);
        ViewPager pager = findViewById(R.id.viewpager);
        pager.setAdapter(null);
        pager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appmenu, menu);

        SwitchCompat sw = ((SwitchCompat) menu.findItem(R.id.itemSwitch).getActionView());
        sw.setChecked(true);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setupPager(isChecked);
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public class MyPagerAdapter extends FragmentStatePagerAdapter {
        List<Pair<Fragment, String>> fragments;

        public MyPagerAdapter(FragmentManager fm, boolean enabled) {
            super(fm);
            fragments = new ArrayList<>();
            fragments.add(new Pair(RecyclerViewContentFragment.newInstance(enabled), "RecyclerView"));
            fragments.add(new Pair(NestedScrollViewContentFragment.newInstance(enabled), "ScrollView"));
            fragments.add(new Pair(ListViewContentFragment.newInstance(enabled), "ListView"));
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
