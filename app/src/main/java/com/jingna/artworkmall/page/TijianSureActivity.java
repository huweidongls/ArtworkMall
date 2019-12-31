package com.jingna.artworkmall.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jingna.artworkmall.R;
import com.jingna.artworkmall.adapter.AddressAdapter;
import com.jingna.artworkmall.base.BaseActivity;
import com.jingna.artworkmall.bean.AddressListBean;
import com.jingna.artworkmall.bean.MarketingCouponUserfindByCouponsBean;
import com.jingna.artworkmall.net.NetUrl;
import com.jingna.artworkmall.util.SpUtils;
import com.jingna.artworkmall.util.StatusBarUtil;
import com.jingna.artworkmall.util.StringUtils;
import com.jingna.artworkmall.util.ToastUtil;
import com.jingna.artworkmall.util.ViseUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TijianSureActivity extends BaseActivity {

    private Context context = TijianSureActivity.this;

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phonenum)
    TextView tvPhoneNum;
    @BindView(R.id.tv_moren)
    TextView tvMoren;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.tv_shouhuo)
    TextView tvShouhuo;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.tv_coupons)
    TextView tvCoupons;

    private String id = "";
    private String addressId = "";
    private String couponsId = "";
    private int goodsNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tijian_sure);

        id = getIntent().getStringExtra("id");
        StatusBarUtil.setStatusBarColor(TijianSureActivity.this, getResources().getColor(R.color.line));
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(TijianSureActivity.this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(TijianSureActivity.this,0x55000000);
        }
        ButterKnife.bind(TijianSureActivity.this);
        initData();

    }

    private void initData() {

        Map<String,String> map = new LinkedHashMap<>();
        map.put("memberId", SpUtils.getUserId(context));
        ViseUtil.Get(context, NetUrl.MemAdressqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                AddressListBean bean = gson.fromJson(s, AddressListBean.class);
                List<AddressListBean.DataBean> list = bean.getData();
                for (int i = 0; i < list.size(); i++){
                    if(list.get(i).getAcquiescentAdress().equals("1")){
                        addressId = list.get(i).getId()+"";
                        tvName.setText(list.get(i).getConsignee());
                        tvPhoneNum.setText(list.get(i).getConsigneeTel());
                        tvAddress.setText(list.get(i).getLocation()+"-"+list.get(i).getAdress());
                        tvMoren.setVisibility(View.VISIBLE);
                        rlAddress.setVisibility(View.VISIBLE);
                    }
                }
                if(rlAddress.getVisibility() == View.GONE){
                    tvShouhuo.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @OnClick({R.id.rl_back, R.id.rl_coupons, R.id.rl_address, R.id.tv_shouhuo, R.id.tv_jian, R.id.tv_jia, R.id.tv_zhifu})
    public void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_coupons:
                intent.setClass(context, CouponsActivity.class);
                startActivityForResult(intent, 1005);
                break;
            case R.id.rl_address:
                intent.setClass(context, AddressActivity.class);
                intent.putExtra("order", "1");
                startActivityForResult(intent, 1001);
                break;
            case R.id.tv_shouhuo:
                intent.setClass(context, AddressActivity.class);
                intent.putExtra("order", "1");
                startActivityForResult(intent, 1001);
                break;
            case R.id.tv_jian:
                if(goodsNum>1){
                    goodsNum = goodsNum - 1;
                    tvNum.setText(goodsNum+"");
                }
                break;
            case R.id.tv_jia:
                goodsNum = goodsNum + 1;
                tvNum.setText(goodsNum+"");
                break;
            case R.id.tv_zhifu:
                tijiao();
                break;
        }
    }

    private void tijiao() {

        if(StringUtils.isEmpty(addressId)){
            ToastUtil.showShort(context, "请选择收货地址");
        }else {
            Map<String, String> map = new LinkedHashMap<>();
            map.put("member", SpUtils.getUserId(context));
            map.put("addressId", addressId);
            map.put("goodsId", id);
            map.put("num", goodsNum+"");
            if(!StringUtils.isEmpty(couponsId)){
                map.put("couponId", couponsId);
            }
            ViseUtil.Get(context, NetUrl.AppOrderordersSubmitted, map, new ViseUtil.ViseListener() {
                @Override
                public void onReturn(String s) {
                    ToastUtil.showShort(context, "提交成功");
                    finish();
                }
            });
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1001&&resultCode == 1002&&data != null){
            AddressListBean.DataBean dataBean = (AddressListBean.DataBean) data.getSerializableExtra("bean");
            addressId = dataBean.getId()+"";
            tvName.setText(dataBean.getConsignee());
            tvPhoneNum.setText(dataBean.getConsigneeTel());
            tvAddress.setText(dataBean.getLocation()+"-"+dataBean.getAdress());
            if(dataBean.getAcquiescentAdress().equals("0")){
                tvMoren.setVisibility(View.GONE);
            }else{
                tvMoren.setVisibility(View.VISIBLE);
            }
            rlAddress.setVisibility(View.VISIBLE);
            tvShouhuo.setVisibility(View.GONE);
        }
        if(requestCode == 1005&&resultCode == 1006&&data != null){
            MarketingCouponUserfindByCouponsBean.DataBean dataBean = (MarketingCouponUserfindByCouponsBean.DataBean) data.getSerializableExtra("bean");
            couponsId = dataBean.getId()+"";
            tvCoupons.setText("已选择");
        }
    }
}