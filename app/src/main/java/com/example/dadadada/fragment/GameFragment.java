package com.example.dadadada.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dadadada.R;
import com.example.dadadada.adapter.GameAdapter;
import com.example.dadadada.entity.GameEntity;

import java.util.ArrayList;
import java.util.List;

public class GameFragment extends Fragment {

    private RecyclerView gameRecycle;
   private List<GameEntity> list=new ArrayList();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_game, container, false);
        gameRecycle = (RecyclerView)inflate.findViewById(R.id.game_recycle);
        list.add(new GameEntity(R.drawable.d_doge,"Android学习交流群"));
        GameAdapter gameAdapter = new GameAdapter(R.layout.item_game,list);

        gameRecycle.setAdapter(gameAdapter);
        gameRecycle.setLayoutManager(new LinearLayoutManager(getActivity()));

        return inflate;
    }

}