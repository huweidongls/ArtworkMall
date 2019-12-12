package com.jingna.artworkmall.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jingna.artworkmall.R;
import com.jingna.artworkmall.base.BaseFragment;
import com.jingna.artworkmall.page.AddressActivity;
import com.jingna.artworkmall.page.PtJifenActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/12/10.
 */

public class Fragment5 extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment5, null);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.rl_address, R.id.ll_pt_jifen})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_address:
                intent.setClass(getContext(), AddressActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_pt_jifen:
                intent.setClass(getContext(), PtJifenActivity.class);
                startActivity(intent);
                break;
        }
    }

}
