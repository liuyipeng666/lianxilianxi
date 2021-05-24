package com.example.dadadada.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.dadadada.R;
import com.example.dadadada.adapter.FGAdapter;
import com.example.dadadada.adapter.FriendsTokenAdapter;
import com.example.dadadada.fragment.FriendsFragment;
import com.example.dadadada.fragment.GroupChatFragment;
import com.example.dadadada.fragment.GroupFragment;
import com.example.dadadada.mvvm.model.entity.ConfigDemo;
import com.example.dadadada.mvvm.model.entity.FriendsEntity;
import com.example.dadadada.mvvm.model.entity.MyTabs;
import com.example.dadadada.mvvm.viewmodel.FriendsTokenViewModel;
import com.example.net.retrofit.BaseRespEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class LianXiRenActivity extends AppCompatActivity {


    private RecyclerView rv;
    private FriendsTokenAdapter friendsTokenAdapter;
    private CommonTabLayout common;
    private ViewPager vp;
    private List<Fragment> list = new ArrayList<>();
    private FGAdapter fgAdapter;
    private ArrayList<CustomTabEntity> tabs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lian_xi_ren);

        initView();
        initData();
    }

    private void initData() {
//        FriendsEntity friendsEntity = new FriendsEntity();
        FriendsTokenViewModel friendsTokenViewModel = new FriendsTokenViewModel(this);
        friendsTokenViewModel.getFriendsToken(1).observe(this, new Observer<BaseRespEntity<List<FriendsEntity>>>() {
            @Override
            public void onChanged(BaseRespEntity<List<FriendsEntity>> listBaseRespEntity) {
                List<FriendsEntity> data = listBaseRespEntity.getData(FriendsEntity.class);
                friendsTokenAdapter = new FriendsTokenAdapter(R.layout.item_friendstoken, data);
                rv.setAdapter(friendsTokenAdapter);
                rv.setLayoutManager(new LinearLayoutManager(LianXiRenActivity.this));
            }
        });
    }


    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        common = (CommonTabLayout) findViewById(R.id.common);
        vp = (ViewPager) findViewById(R.id.vp);
        list.add(new FriendsFragment());
        list.add(new GroupFragment());
        list.add(new GroupChatFragment());
        fgAdapter = new FGAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(fgAdapter);
        tabs.add(new MyTabs(ConfigDemo.FRIENDS, ConfigDemo.SELECT_ICON, ConfigDemo.UNSELECT_ICON));
        tabs.add(new MyTabs(ConfigDemo.GROUP, ConfigDemo.SELECT_ICON, ConfigDemo.UNSELECT_ICON));
        tabs.add(new MyTabs(ConfigDemo.FRIENDSGROUP, ConfigDemo.SELECT_ICON, ConfigDemo.UNSELECT_ICON));
        common.setTabData(tabs);
        common.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                common.setCurrentTab(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}