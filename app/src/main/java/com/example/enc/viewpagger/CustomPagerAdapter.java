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

import com.example.enc.viewpagger.models.Item;

import java.util.ArrayList;
import java.util.List;


public class CustomPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Item> retrievedData;
    List<Fragment> fragments = new ArrayList<>();
    List<Fragment> namesList = new ArrayList<>();

    public CustomPagerAdapter(FragmentManager supportFragmentManager, List<Item> retrievedData) {
        super(supportFragmentManager);
        this.retrievedData = retrievedData;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment item = null;
        switch (retrievedData.get(i).getTag()) {
            case "vp":
//                item = FragmentA.newInstance(retrievedData.get(i).getName());
                item = new FragmentA();
                break;
            case "ep":
                item = new FragmentB();
                break;
            case "cu":
                item = new FragmentC();
                break;
            default:
                break;
        }
        fragments.add(item);
        return item;
    }

    public Fragment getCurrentItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return retrievedData.size();
    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        Fragment fragmentName = null;
//        switch (retrievedData.get(position).getName()) {
//            case "View Profile":
//                fragmentName = FragmentA.newInstance((retrievedData.get(position).getName()));
//                break;
//            case  "Edit Profile":
//                fragmentName =FragmentB.newInstance((retrievedData.get(position).getName()));
//                break;
//            case "Contact":
//                fragmentName = FragmentC.newInstance((retrievedData.get(position).getName()));;
//                break;
//            default:
//                break;
//        }
//        namesList.add(fragmentName);
//        return (CharSequence) fragmentName;
//    }
}


