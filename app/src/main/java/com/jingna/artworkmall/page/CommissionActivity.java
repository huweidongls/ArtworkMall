package com.jingna.artworkmall.page;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jingna.artworkmall.R;
import com.jingna.artworkmall.base.BaseActivity;
import com.jingna.artworkmall.bean.BankCardListBean;
import com.jingna.artworkmall.util.SpUtils;
import com.jingna.artworkmall.util.StatusBarUtil;
import com.jingna.artworkmall.util.ToastUtil;
import com.vise.xsnow.http.ViseHttp;
import com.vise.xsnow.http.callback.ACallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommissionActivity extends BaseActivity {

    private Context context = CommissionActivity.this;

    private List<String> mList;
    @BindView(R.id.money)
    EditText money;
    @BindView(R.id.btn_mone)
    Button btn_mone;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_bank_name)
    TextView tvBankName;
    @BindView(R.id.tv_select)
    TextView tvSelect;

//    private RecyclerView recyclerView;
//
//    private PopupWindow popupWindow;
//    private BackCardListAdapter adapter;

    private String bankId = "";
    private double allMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commission);


        StatusBarUtil.setStatusBarColor(CommissionActivity.this, getResources().getColor(R.color.line));
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(CommissionActivity.this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(CommissionActivity.this,0x55000000);
        }
        ButterKnife.bind(CommissionActivity.this);
        initData();

    }

    private void initData() {

        ViseHttp.GET("")
                .addParam("memberId", SpUtils.getUserId(context))
                .request(new ACallback<String>() {
                    @Override
                    public void onSuccess(String data) {
                        try {
                            JSONObject jsonObject = new JSONObject(data);
                            if (jsonObject.optString("status").equals("200")) {
                                allMoney = jsonObject.optDouble("data");
                                tvMoney.setText("佣金余额¥" + allMoney + "，");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFail(int errCode, String errMsg) {

                    }
                });

        money.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String message = s.toString();
                if (TextUtils.isEmpty(message)) {
                    btn_mone.setBackgroundColor(Color.parseColor("#CF9297"));
                    ToastUtil.showShort(CommissionActivity.this, "请填写提现金额");
                } else {
                    btn_mone.setBackgroundColor(Color.parseColor("#A02630"));
                }

            }
        });
    }

//    private void init_back() {
//        mList = new ArrayList<>();
//        mList.add("");
//        mList.add("");
//        mList.add("");
//        adapter = new BackCardListAdapter(mList);
//        LinearLayoutManager manager = new LinearLayoutManager(CommissionActivity.this);
//        manager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(adapter);
//    }

    @OnClick({R.id.rl_back, R.id.btn_mone, R.id.all, R.id.ll_bank})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.btn_mone:
                String msg = money.getText().toString();
                if (TextUtils.isEmpty(msg)) {
                    ToastUtil.showShort(CommissionActivity.this, "请填写提现金额");
                } else if(TextUtils.isEmpty(bankId)){
                    ToastUtil.showShort(CommissionActivity.this, "请选择提现银行卡");
                }else {
                    ViseHttp.POST("")
                            .addParam("memberId", SpUtils.getUserId(context))
                            .addParam("auditMoney", msg)
                            .addParam("bankCardId", bankId)
                            .request(new ACallback<String>() {
                                @Override
                                public void onSuccess(String data) {
                                    try {
                                        JSONObject jsonObject = new JSONObject(data);
                                        if(jsonObject.optString("status").equals("200")){
                                            ToastUtil.showShort(context, "提现成功");
                                            finish();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onFail(int errCode, String errMsg) {

                                }
                            });
                }
                break;
            case R.id.all:
                money.setText(allMoney+"");
                money.setSelection(money.getText().toString().length());
                break;
            case R.id.ll_bank:
                intent.setClass(context, MyBankCardActivity.class);
                intent.putExtra("type", "tixian");
                startActivityForResult(intent, 1003);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1003 && data != null) {
            BankCardListBean.DataBean bean = (BankCardListBean.DataBean) data.getSerializableExtra("bean");
            bankId = bean.getId() + "";
            tvBankName.setText(bean.getCardType() + "(" + bean.getBankCardNum().substring(bean.getBankCardNum().length() - 4, bean.getBankCardNum().length()) + ")");
            tvSelect.setVisibility(View.GONE);
        }
    }

//    private void showBankPop() {
//        View view = LayoutInflater.from(CommissionActivity.this).inflate(R.layout.popupwindow_bankcardlist, null);
//
//        recyclerView = view.findViewById(R.id.rv_bankcard);
//        init_back();
//        popupWindow = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
//        popupWindow.setTouchable(true);
//        popupWindow.setFocusable(true);
//        // 设置点击窗口外边窗口消失
//        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        popupWindow.setOutsideTouchable(true);
//        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
////        popupWindow.showAsDropDown(rlPro);
//        // 设置popWindow的显示和消失动画
//        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style_bottom);
//        WindowManager.LayoutParams params = getWindow().getAttributes();
//        params.alpha = 0.5f;
//        getWindow().setAttributes(params);
//        popupWindow.update();
//
//        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//
//            // 在dismiss中恢复透明度
//            public void onDismiss() {
//                WindowManager.LayoutParams params = getWindow().getAttributes();
//                params.alpha = 1f;
//                getWindow().setAttributes(params);
//            }
//        });
//    }

}
