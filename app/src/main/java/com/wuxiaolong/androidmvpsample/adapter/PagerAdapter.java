package com.wuxiaolong.androidmvpsample.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.wuxiaolong.androidmvpsample.fargment.OneFragment;
import com.wuxiaolong.androidmvpsample.fargment.TwoFragment;

/**
 * Created by LZZ on 2017/8/29.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int nNumOfTabs;
    public PagerAdapter(FragmentManager fm, int nNumOfTabs)
    {
        super(fm);
        this.nNumOfTabs=nNumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                OneFragment tab1=new OneFragment();
                return tab1;
            case 1:
                TwoFragment tab2=new TwoFragment();
                return tab2;

        }
        return null;
    }

    @Override
    public int getCount() {
        return nNumOfTabs;
    }
}
