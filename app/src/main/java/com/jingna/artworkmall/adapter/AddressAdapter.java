package com.jingna.artworkmall.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jingna.artworkmall.R;
import com.jingna.artworkmall.bean.AddressListBean;

import java.util.List;

/**
 * Created by Administrator on 2019/12/12.
 */

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {

    private Context context;
    private List<AddressListBean.DataBean> data;

    public AddressAdapter(List<AddressListBean.DataBean> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_address_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_name.setText(data.get(position).getConsignee());
        holder.tv_phonenum.setText(data.get(position).getConsigneeTel());
        if(data.get(position).getAcquiescentAdress().equals("0")){
            holder.tv_moren.setVisibility(View.GONE);
        }else{
            holder.tv_moren.setVisibility(View.VISIBLE);
        }
        holder.tv_address.setText(data.get(position).getAdress());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        private TextView tv_phonenum;
        private TextView tv_moren;
        private TextView tv_address;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_phonenum = itemView.findViewById(R.id.tv_phonenum);
            tv_moren = itemView.findViewById(R.id.tv_moren);
            tv_address = itemView.findViewById(R.id.tv_address);
        }
    }

}
