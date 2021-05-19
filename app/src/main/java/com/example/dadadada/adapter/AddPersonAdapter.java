package com.example.dadadada.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class AddPersonAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private List<String> title;

    public AddPersonAdapter(@NonNull FragmentManager fm, List<Fragment> list, List<String> title) {
        super(fm);
        this.list = list;
        this.title = title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

}
