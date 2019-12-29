package com.jingna.artworkmall.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jingna.artworkmall.R;
import com.jingna.artworkmall.adapter.PifaAdapter;
import com.jingna.artworkmall.adapter.YouxuanAdapter;
import com.jingna.artworkmall.base.BaseFragment;
import com.jingna.artworkmall.bean.AppGoodsShopqueryListBean;
import com.jingna.artworkmall.bean.IndexPageApifindBannerCategoryBean;
import com.jingna.artworkmall.net.NetUrl;
import com.jingna.artworkmall.util.ViseUtil;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/12/10.
 */

public class Fragment4 extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.refresh)
    SmartRefreshLayout smartRefreshLayout;

    private YouxuanAdapter adapter;
    private List<AppGoodsShopqueryListBean.DataBean> mList;
    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, null);

        ButterKnife.bind(this, view);
        initBanner();
        initData();

        return view;
    }

    private void initBanner() {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("type", "1");
        ViseUtil.Get(getContext(), NetUrl.IndexPageApifindBannerCategory, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                IndexPageApifindBannerCategoryBean bean = gson.fromJson(s, IndexPageApifindBannerCategoryBean.class);
                List<String> list = new ArrayList<>();
                for (IndexPageApifindBannerCategoryBean.DataBean b : bean.getData()){
                    list.add(NetUrl.BASE_URL+b.getAppPic());
                }
                init(banner, list);
            }
        });

    }

    private void initData() {

        smartRefreshLayout.setRefreshHeader(new MaterialHeader(getContext()));
        smartRefreshLayout.setRefreshFooter(new ClassicsFooter(getContext()));
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageNum", "1");
                map.put("pageSize", "10");
                ViseUtil.Get(getContext(), NetUrl.AppGoodsShopqueryList, map, refreshLayout, 0, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        AppGoodsShopqueryListBean bean = gson.fromJson(s, AppGoodsShopqueryListBean.class);
                        mList.clear();
                        mList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                        page = 2;
                    }
                });
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                Map<String, String> map = new LinkedHashMap<>();
                map.put("pageNum", page+"");
                map.put("pageSize", "10");
                ViseUtil.Get(getContext(), NetUrl.AppGoodsShopqueryList, map, refreshLayout, 1, new ViseUtil.ViseListener() {
                    @Override
                    public void onReturn(String s) {
                        Gson gson = new Gson();
                        AppGoodsShopqueryListBean bean = gson.fromJson(s, AppGoodsShopqueryListBean.class);
                        mList.addAll(bean.getData());
                        adapter.notifyDataSetChanged();
                        page = page+1;
                    }
                });
            }
        });

        Map<String, String> map = new LinkedHashMap<>();
        map.put("pageNum", "1");
        map.put("pageSize", "10");
        ViseUtil.Get(getContext(), NetUrl.AppGoodsShopqueryList, map, new ViseUtil.ViseListener() {
            @Override
            public void onReturn(String s) {
                Gson gson = new Gson();
                AppGoodsShopqueryListBean bean = gson.fromJson(s, AppGoodsShopqueryListBean.class);
                mList = bean.getData();
                adapter = new YouxuanAdapter(mList);
                GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapter);
                page = 2;
            }
        });

    }

}
