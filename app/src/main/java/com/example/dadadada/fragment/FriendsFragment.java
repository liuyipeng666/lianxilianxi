package com.example.dadadada.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dadadada.R;
import com.example.dadadada.adapter.CharAdapter;
import com.example.dadadada.adapter.FriendListAdapter;
import com.example.dadadada.mvvm.model.entity.FriendListEntity;
import com.example.dadadada.mvvm.viewmodel.FriendListViewModel;
import com.example.net.retrofit.BaseRespEntity;

import java.util.ArrayList;
import java.util.List;


public class FriendsFragment extends Fragment {

    private RecyclerView rv2;
    private RecyclerView rv1;
    private List<String> list = new ArrayList<>();
    private CharAdapter charAdapter;
    private FriendListAdapter friendListAdapter;

    public FriendsFragment() {
    }

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_friends, container, false);
        initView();
        initData();
        return view;
    }

    private void initData() {
        for (char i = 'A'; i <= 'Z'; i++) {
            list.add(i + "");
        }

        FriendListViewModel friendListViewModel = new FriendListViewModel(getActivity());
        friendListViewModel.list(1).observe(getActivity(), new Observer<BaseRespEntity<List<FriendListEntity>>>() {
            @Override
            public void onChanged(BaseRespEntity<List<FriendListEntity>> listBaseRespEntity) {
                List<FriendListEntity> data = listBaseRespEntity.getData(FriendListEntity.class);

                friendListAdapter = new FriendListAdapter(R.layout.item_list, data);
                rv2.setAdapter(friendListAdapter);
                rv2.setLayoutManager(new LinearLayoutManager(getActivity()));
            }
        });
    }

    private void initView() {
        rv2 = (RecyclerView) view.findViewById(R.id.rv2);
        rv1 = (RecyclerView) view.findViewById(R.id.rv1);
        charAdapter = new CharAdapter(R.layout.item_char, list);
        rv1.setAdapter(charAdapter);
        rv1.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}