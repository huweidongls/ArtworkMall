package com.jingna.artworkmall.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.google.gson.Gson;
import com.jingna.artworkmall.R;
import com.jingna.artworkmall.base.BaseFragment;
import com.jingna.artworkmall.bean.AliBean;
import com.jingna.artworkmall.page.AddressActivity;
import com.jingna.artworkmall.page.CouponsActivity;
import com.jingna.artworkmall.page.JifenOrderActivity;
import com.jingna.artworkmall.page.LoginActivity;
import com.jingna.artworkmall.page.MyBankCardActivity;
import com.jingna.artworkmall.page.MyDianpuActivity;
import com.jingna.artworkmall.page.PersonInformationActivity;
import com.jingna.artworkmall.page.PtJifenActivity;
import com.jingna.artworkmall.util.SpUtils;
import com.jingna.artworkmall.util.ViseUtil;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/12/10.
 */

public class Fragment5 extends BaseFragment {

    private static final int SDK_PAY_FLAG = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment5, null);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.rl_address, R.id.ll_pt_jifen, R.id.rl_jifen_order, R.id.ll_head, R.id.rl_bank, R.id.rl_dianpu,
    R.id.ll_coupons})
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
            case R.id.ll_head:
                intent.setClass(getContext(), PersonInformationActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_bank:
                intent.setClass(getContext(), MyBankCardActivity.class);
                intent.putExtra("type", "my");
                startActivity(intent);
                break;
            case R.id.rl_dianpu:
                intent.setClass(getContext(), MyDianpuActivity.class);
                startActivity(intent);
//                Map<String, String> map = new LinkedHashMap<>();
//                map.put("id", SpUtils.getUserId(getContext()));
//                map.put("ptb", "1");
//                ViseUtil.Get(getContext(), "AppRechargeExtract/rechargePtb", map, new ViseUtil.ViseListener() {
//                    @Override
//                    public void onReturn(String s) {
//                        Gson gson = new Gson();
//                        AliBean aliBean = gson.fromJson(s, AliBean.class);
//                        aliPay(aliBean.getData().getData());
//                    }
//                });
                break;
            case R.id.ll_coupons:
                intent.setClass(getContext(), CouponsActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void aliPay(String info) {
        final String orderInfo = info;   // 订单信息

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(getActivity());
                Map<String, String> result = alipay.payV2(orderInfo,true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG:
                    Map<String, String> result = (Map<String, String>) msg.obj;
                    if(result.get("resultStatus").equals("9000")){
                        Toast.makeText(getContext(), "支付成功", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }

    };

}
