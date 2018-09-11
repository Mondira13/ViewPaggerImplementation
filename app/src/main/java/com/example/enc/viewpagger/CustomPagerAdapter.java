package com.example.enc.viewpagger;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CustomPagerAdapter extends FragmentStatePagerAdapter {

    int noOfTabs;

    public CustomPagerAdapter(FragmentManager fm, int noOfTabs) {
        super(fm);
        this.noOfTabs = noOfTabs;
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                FragmentA fragmentA = new FragmentA();
                return fragmentA;
            case 1:
                FragmentB fragmentB = new FragmentB();
                return fragmentB;
            case 2:
                FragmentC fragmentC = new FragmentC();
                return fragmentC;
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
//
//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position){
//            case 0:
//                return "View Profile";
//            case 1:
//                return "Edit Profile";
//            case 2:
//                return "Contact";
//                default:
//                    return null;
//        }
//
//    }
}


