package com.jingna.artworkmall.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jingna.artworkmall.R;
import com.jingna.artworkmall.adapter.PifaAdapter;
import com.jingna.artworkmall.base.BaseFragment;
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

    private PifaAdapter adapter;
    private List<String> mList;

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
                refreshLayout.finishRefresh(500);
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                List<String> list = new ArrayList<>();
                list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124684803&di=b2955f5c7f53d25a2a66942ae32d992d&imgtype=0&src=http%3A%2F%2Fww2.sinaimg.cn%2Flarge%2F00667u01jw1erufiv0fd1j30k00b9q48.jpg");
                list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124684802&di=d75ad5b4e7d8b79100f9a520ecf5362a&imgtype=0&src=http%3A%2F%2Fzjnews.zjol.com.cn%2Fgdxw%2Fycxw_zxtf%2F201611%2FW020161116816118043260.jpg");
                list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124704707&di=509a494541450addeee6532972bad420&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D2637673594%2C2560483073%26fm%3D214%26gp%3D0.jpg");
                list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124712771&di=972c90108393a191c7ba19a3719c0a34&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D3011731684%2C1303327354%26fm%3D214%26gp%3D0.jpg");
                list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124684800&di=c16a4a9ff8ced70464fe924aca6ef57c&imgtype=0&src=http%3A%2F%2Fstatic.chayuqing.com%2F65cbb7e0729bb0ea9be3f26a0b6ec5c6.jpg");
                int pos = mList.size();
                mList.addAll(list);
                adapter.notifyItemInserted(pos);
                refreshLayout.finishLoadMore(500);
            }
        });

        mList = new ArrayList<>();
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124684803&di=b2955f5c7f53d25a2a66942ae32d992d&imgtype=0&src=http%3A%2F%2Fww2.sinaimg.cn%2Flarge%2F00667u01jw1erufiv0fd1j30k00b9q48.jpg");
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124684802&di=d75ad5b4e7d8b79100f9a520ecf5362a&imgtype=0&src=http%3A%2F%2Fzjnews.zjol.com.cn%2Fgdxw%2Fycxw_zxtf%2F201611%2FW020161116816118043260.jpg");
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124704707&di=509a494541450addeee6532972bad420&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D2637673594%2C2560483073%26fm%3D214%26gp%3D0.jpg");
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124712771&di=972c90108393a191c7ba19a3719c0a34&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D3011731684%2C1303327354%26fm%3D214%26gp%3D0.jpg");
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124684800&di=c16a4a9ff8ced70464fe924aca6ef57c&imgtype=0&src=http%3A%2F%2Fstatic.chayuqing.com%2F65cbb7e0729bb0ea9be3f26a0b6ec5c6.jpg");
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124684803&di=b2955f5c7f53d25a2a66942ae32d992d&imgtype=0&src=http%3A%2F%2Fww2.sinaimg.cn%2Flarge%2F00667u01jw1erufiv0fd1j30k00b9q48.jpg");
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124684802&di=d75ad5b4e7d8b79100f9a520ecf5362a&imgtype=0&src=http%3A%2F%2Fzjnews.zjol.com.cn%2Fgdxw%2Fycxw_zxtf%2F201611%2FW020161116816118043260.jpg");
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124704707&di=509a494541450addeee6532972bad420&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D2637673594%2C2560483073%26fm%3D214%26gp%3D0.jpg");
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124712771&di=972c90108393a191c7ba19a3719c0a34&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D3011731684%2C1303327354%26fm%3D214%26gp%3D0.jpg");
        mList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124684800&di=c16a4a9ff8ced70464fe924aca6ef57c&imgtype=0&src=http%3A%2F%2Fstatic.chayuqing.com%2F65cbb7e0729bb0ea9be3f26a0b6ec5c6.jpg");
        adapter = new PifaAdapter(mList);
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

    }

}
