package com.example.ea.prolink;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ea on 6/5/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> f = new ArrayList<>();
    private final List<String> t = new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return f.get(position);
    }

    @Override
    public int getCount() {
        return t.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return t.get(position);
    }

    public void AddFragment (Fragment fragment, String title){
        f.add(fragment);
        t.add(title);
    }










}
