package com.jingna.artworkmall.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jingna.artworkmall.R;
import com.jingna.artworkmall.adapter.Fragment1RvAdapter;
import com.jingna.artworkmall.base.BaseFragment;
import com.jingna.artworkmall.bean.IndexPageApifindBannerCategoryBean;
import com.jingna.artworkmall.card.CardFragmentPagerAdapter;
import com.jingna.artworkmall.card.CardFxPagerAdapter;
import com.jingna.artworkmall.net.NetUrl;
import com.jingna.artworkmall.util.DensityTool;
import com.jingna.artworkmall.util.ViseUtil;
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

public class Fragment1 extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.vp)
    ViewPager viewPager;
    @BindView(R.id.banner)
    Banner banner;

    private CardFxPagerAdapter mCardAdapter;
    private CardFragmentPagerAdapter mFragmentCardAdapter;

    private List<String> data;

    private Fragment1RvAdapter adapter;
    private List<String> mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, null);

        ButterKnife.bind(this, view);
        initData();

        return view;
    }

    public void setCardView(List<String> data) {

        mCardAdapter = new CardFxPagerAdapter();
        for (int i = 0; i < data.size(); i++) {
            mCardAdapter.addCardItem(data.get(i));
        }
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getActivity().getSupportFragmentManager(),
                DensityTool.dp2px(getContext(), 1));

        viewPager.setAdapter(mCardAdapter);
        viewPager.setOffscreenPageLimit(3);

    }

    private void initData() {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("type", "0");
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

        data = new ArrayList<>();
        data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124684803&di=b2955f5c7f53d25a2a66942ae32d992d&imgtype=0&src=http%3A%2F%2Fww2.sinaimg.cn%2Flarge%2F00667u01jw1erufiv0fd1j30k00b9q48.jpg");
        data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124684802&di=d75ad5b4e7d8b79100f9a520ecf5362a&imgtype=0&src=http%3A%2F%2Fzjnews.zjol.com.cn%2Fgdxw%2Fycxw_zxtf%2F201611%2FW020161116816118043260.jpg");
        data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124704707&di=509a494541450addeee6532972bad420&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D2637673594%2C2560483073%26fm%3D214%26gp%3D0.jpg");
        data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124712771&di=972c90108393a191c7ba19a3719c0a34&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D3011731684%2C1303327354%26fm%3D214%26gp%3D0.jpg");
        data.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1576124684800&di=c16a4a9ff8ced70464fe924aca6ef57c&imgtype=0&src=http%3A%2F%2Fstatic.chayuqing.com%2F65cbb7e0729bb0ea9be3f26a0b6ec5c6.jpg");
        setCardView(data);

        mList = new ArrayList<>();
        mList.add("");
        mList.add("");
        mList.add("");
        adapter = new Fragment1RvAdapter(mList);
        LinearLayoutManager manager = new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }

}
