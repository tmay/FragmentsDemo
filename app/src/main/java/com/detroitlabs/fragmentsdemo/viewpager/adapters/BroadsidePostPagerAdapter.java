package com.detroitlabs.fragmentsdemo.viewpager.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.detroitlabs.fragmentsdemo.basic.fragments.BroadsidePostFragment;
import com.detroitlabs.fragmentsdemo.models.BroadsideItem;

import java.util.ArrayList;

/**
 * Created by Terry on 10/28/14.
 */
public class BroadsidePostPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<BroadsideItem> items;

    public BroadsidePostPagerAdapter(FragmentManager fm, ArrayList<BroadsideItem> items) {
        super(fm);
        this.items = items;
    }

    @Override
    public Fragment getItem(int i) {
        return BroadsidePostFragment.newInstance(items.get(i));
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
