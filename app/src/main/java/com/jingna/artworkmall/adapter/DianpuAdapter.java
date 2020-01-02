package com.jingna.artworkmall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jingna.artworkmall.R;
import com.jingna.artworkmall.bean.MemUserfindByTeamBean;
import com.jingna.artworkmall.net.NetUrl;
import com.jingna.artworkmall.util.GlideUtils;

import java.util.List;

/**
 * Created by Administrator on 2019/12/27.
 */

public class DianpuAdapter extends RecyclerView.Adapter<DianpuAdapter.ViewHolder> {

    private Context context;
    private List<MemUserfindByTeamBean.DataBean> data;

    public DianpuAdapter(List<MemUserfindByTeamBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_dianpu, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GlideUtils.into(context, NetUrl.BASE_URL+data.get(position).getHeadPhoto(), holder.ivAvatar);
        holder.tvName.setText(data.get(position).getMemName());
        String sex = data.get(position).getGender();
        if(sex.equals("1")){
            Glide.with(context).load(R.mipmap.nan).into(holder.ivAvatar);
        }else if(sex.equals("2")){
            Glide.with(context).load(R.mipmap.nv).into(holder.ivAvatar);
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivAvatar;
        private TextView tvName;
        private ImageView ivSex;

        public ViewHolder(View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
            ivSex = itemView.findViewById(R.id.iv_sex);
        }
    }

}
