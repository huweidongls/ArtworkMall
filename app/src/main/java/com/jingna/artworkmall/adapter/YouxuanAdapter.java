package com.jingna.artworkmall.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jingna.artworkmall.R;
import com.jingna.artworkmall.bean.AppGoodsShopqueryListBean;
import com.jingna.artworkmall.net.NetUrl;
import com.jingna.artworkmall.page.TijianDetailsActivity;
import com.jingna.artworkmall.util.GlideUtils;
import com.jingna.artworkmall.util.StringUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/12/29.
 */

public class YouxuanAdapter extends RecyclerView.Adapter<YouxuanAdapter.ViewHolder> {

    private Context context;
    private List<AppGoodsShopqueryListBean.DataBean> data;

    public YouxuanAdapter(List<AppGoodsShopqueryListBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_youxuan, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        GlideUtils.into(context, NetUrl.BASE_URL+data.get(position).getAppPic(), holder.iv);
        holder.tvName.setText(data.get(position).getGoodsName());
        holder.tvPrice.setText("¥"+StringUtils.roundByScale(data.get(position).getPrice(), 2));
        String label = data.get(position).getLabel();
        if(!StringUtils.isEmpty(label)){
            String[] s = label.split(",");
            YouxuanItemAdapter itemAdapter = new YouxuanItemAdapter(s);
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            holder.rv.setLayoutManager(manager);
            holder.rv.setAdapter(itemAdapter);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, TijianDetailsActivity.class);
                intent.putExtra("id", data.get(position).getId()+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        private TextView tvName;
        private TextView tvPrice;
        private RecyclerView rv;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            rv = itemView.findViewById(R.id.rv);
        }
    }

}
