package com.example.yydkj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.yydkj.bean.FragmentInfo;

import java.util.ArrayList;
import java.util.List;

//ViewPager内的Fragment填充器

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private List<FragmentInfo> mShowItems = new ArrayList<>();

    public FragmentAdapter(FragmentManager fm, List<FragmentInfo> showItems) {
        super(fm);
        mShowItems = showItems;
    }


    @Override
    public Fragment getItem(int position) {
        return mShowItems.get(position).fragment;
    }

    @Override
    public int getCount() {
        return mShowItems.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mShowItems.get(position).title;
    }
}
