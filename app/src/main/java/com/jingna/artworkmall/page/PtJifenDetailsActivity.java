package com.jingna.artworkmall.page;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import com.jingna.artworkmall.R;
import com.jingna.artworkmall.base.BaseActivity;
import com.jingna.artworkmall.util.StatusBarUtil;

import butterknife.ButterKnife;

public class PtJifenDetailsActivity extends BaseActivity {

    private Context context = PtJifenDetailsActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt_jifen_details);

        StatusBarUtil.setStatusBarColor(PtJifenDetailsActivity.this, Color.parseColor("#EFEFEF"));
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(PtJifenDetailsActivity.this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(PtJifenDetailsActivity.this,0x55000000);
        }
        ButterKnife.bind(PtJifenDetailsActivity.this);

    }
}
