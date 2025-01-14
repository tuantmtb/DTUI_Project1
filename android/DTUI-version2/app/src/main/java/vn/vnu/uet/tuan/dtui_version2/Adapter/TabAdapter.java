package vn.vnu.uet.tuan.dtui_version2.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Admin on 27/11/2016.
 */

public class TabAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mArray_Fragments;
    private ArrayList<String> mName_Fragment;
    public TabAdapter(FragmentManager fm) {
        super(fm);
        mArray_Fragments=new ArrayList<>();
        mName_Fragment=new ArrayList<>();
    }

    public void addFragment(Fragment fragment, String name){
        mArray_Fragments.add(fragment);
        mName_Fragment.add(name);
    }
    @Override
    public Fragment getItem(int position) {
        return mArray_Fragments.get(position);
    }

    @Override
    public int getCount() {
        return mArray_Fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return new String(mName_Fragment.get(position));
    }
    public Fragment getFrament(int position){
        return mArray_Fragments.get(position);
    }

}