package com.example.renju.a108;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by renju on 25/11/16.
 */

public class Padapter extends FragmentPagerAdapter{

    public Padapter(FragmentManager fm) {

        super(fm);
    }

    String [] title = {"Injuries","Cause","Settings"};

    @Override
    public Fragment getItem(int position) {
        Fragment fragm = null;
        if(position == 0) {
            fragm = new fragmentone();
        }
        if (position==1){
            fragm = new fragmenttwo();
        }
        if (position==2){
            fragm = new fragmentthree();
        }
        return fragm;
    }

    @Override
    public int getCount() {

        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }


}
