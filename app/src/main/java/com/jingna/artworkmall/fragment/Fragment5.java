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
import com.jingna.artworkmall.page.JifenOrderActivity;
import com.jingna.artworkmall.page.LoginActivity;
import com.jingna.artworkmall.page.PtJifenActivity;
import com.jingna.artworkmall.util.SpUtils;

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

    @OnClick({R.id.rl_address, R.id.ll_pt_jifen, R.id.rl_jifen_order})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_address:
                if(SpUtils.getUserId(getContext()).equals("0")){
                    intent.setClass(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    intent.setClass(getContext(), AddressActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.ll_pt_jifen:
                if(SpUtils.getUserId(getContext()).equals("0")){
                    intent.setClass(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    intent.setClass(getContext(), PtJifenActivity.class);
                    startActivity(intent);
                }
                break;
            case R.id.rl_jifen_order:
                if(SpUtils.getUserId(getContext()).equals("0")){
                    intent.setClass(getContext(), LoginActivity.class);
                    startActivity(intent);
                }else {
                    intent.setClass(getContext(), JifenOrderActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

}
