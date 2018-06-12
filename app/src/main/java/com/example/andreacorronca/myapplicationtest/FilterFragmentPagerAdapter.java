package com.example.andreacorronca.myapplicationtest;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class FilterFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public FilterFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new GenreFilterFragment();
        } else if (position == 1){
            return new SettingFilterFragment();
        /*} else if (position == 2){
            return new GameModeFragment();*/
        } else{
            return new InfoFilterFragment();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 3;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "Genere";
            case 1:
                return "Ambientazione";
            /*case 2:
                return "Modalità";*/
            case 2:
                return "Altro";
            default:
                return null;
        }
    }

}
