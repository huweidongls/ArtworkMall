package com.jingna.artworkmall.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jingna.artworkmall.R;
import com.jingna.artworkmall.util.StringUtils;

/**
 * Created by Administrator on 2020/1/17.
 */

public class DialogZhifu extends Dialog {

    private Context context;
    private TextView tvYue;
    private TextView tvCancel;
    private TextView tvSure;
    private double yue;
    private ClickListener listener;

    public DialogZhifu(@NonNull Context context, double yue, ClickListener listener) {
        super(context, R.style.RoundCornerDialog);
        this.context = context;
        this.yue = yue;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {

        View view = LayoutInflater.from(context).inflate(R.layout.dialog_zhifu, null);
        setContentView(view);

        tvYue = view.findViewById(R.id.tv_yue);
        tvCancel = view.findViewById(R.id.tv_cancel);
        tvSure = view.findViewById(R.id.tv_sure);

        tvYue.setText("平台币余额¥"+ StringUtils.roundByScale(yue, 2));
        tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onYes();
            }
        });
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onNo();
            }
        });

    }

    public interface ClickListener{
        void onYes();
        void onNo();
    }

}
