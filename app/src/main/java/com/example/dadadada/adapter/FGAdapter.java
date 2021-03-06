package com.example.dadadada.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class FGAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mList;

    public FGAdapter(@NonNull FragmentManager fm, List<Fragment> mList) {
        super(fm);
        this.mList = mList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
