package com.jingna.artworkmall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jingna.artworkmall.R;
import com.jingna.artworkmall.adapter.Fragment3Adapter;
import com.jingna.artworkmall.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/12/10.
 */

public class Fragment3 extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView recyclerView;

    private Fragment3Adapter adapter;
    private List<String> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, null);

        ButterKnife.bind(this, view);
        initData();

        return view;
    }

    private void initData() {

        mList = new ArrayList<>();
        mList.add("");
        mList.add("");
        mList.add("");
        mList.add("");
        mList.add("");
        adapter = new Fragment3Adapter(mList);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }

}
