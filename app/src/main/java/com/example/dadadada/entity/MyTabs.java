package com.example.dadadada.entity;

import com.flyco.tablayout.listener.CustomTabEntity;

public class MyTabs implements CustomTabEntity {
    private String title;
    private int selectIcon;
    private int unSelectIcon;

    public MyTabs(String title, int selectIcon, int unSelectIcon) {
        this.title = title;
        this.selectIcon = selectIcon;
        this.unSelectIcon = unSelectIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unSelectIcon;
    }
}
