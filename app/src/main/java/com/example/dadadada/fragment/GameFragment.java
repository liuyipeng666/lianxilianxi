package com.example.dadadada.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dadadada.R;

public class GameFragment extends Fragment {

    private RecyclerView gameRecycle;
   // private List<> list=new ArrayList();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_game, container, false);
        gameRecycle = (RecyclerView)inflate.findViewById(R.id.game_recycle);











        return inflate;
    }

}