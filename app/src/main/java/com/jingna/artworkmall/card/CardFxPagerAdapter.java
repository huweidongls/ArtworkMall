package com.jingna.artworkmall.card;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jingna.artworkmall.R;
import com.jingna.artworkmall.bean.GetTopAdvBean;
import com.jingna.artworkmall.net.NetUrl;
import com.jingna.artworkmall.util.GlideUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/8 0008.
 */

public class CardFxPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<String> mData = new ArrayList<>();
    private float mBaseElevation;

    public CardFxPagerAdapter() {
        mData = new ArrayList<>();
        mViews = new ArrayList<>();
    }

    public void addCardItem(String item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter_fx, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        CardView cardView = view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        cardView.setMaxCardElevation(5);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(String item, View view) {
        ImageView img = view.findViewById(R.id.fragment_sy_fx_card_img);

        GlideUtils.into(view.getContext(), item, img);
    }

}
