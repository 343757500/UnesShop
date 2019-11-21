package com.unes.shopp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.unes.shopp.ui.fragment.ConfirmationFragment;

public class ConfirmationAdapter extends FragmentStatePagerAdapter {
    private String[] titles;


    public ConfirmationAdapter(FragmentManager fm, String[] titles) {
        super(fm);
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment f = new ConfirmationFragment();
        /*Bundle bundle = new Bundle();
        bundle.putString("courseCategory", i+1+"");
        f.setArguments(bundle);*/
        return f;

    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
