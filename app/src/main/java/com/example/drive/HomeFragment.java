package com.example.drive;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private View homeView;
    private Banner banner;
    private ImageView iv_start;
    List<String> imgs = new ArrayList<>();
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeView = inflater.inflate(R.layout.fragment_home, container, false);

        initView();
        return homeView;
    }

    private void initView() {
        banner = homeView.findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Accordion);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);

            }
        });
        imgs.add("https://www.jiakaobaodian.com/core-assets/static/images/common/home_banner_new1.png");
        imgs.add("https://www.jiakaobaodian.com/core-assets/static/images/common/home_banner_jiaxiaobang.jpg");
        imgs.add("https://www.jiakaobaodian.com/core-assets/static/images/common/home_banner_jiaolian.jpg");
        banner.setImages(imgs);
        banner.start();


        iv_start = homeView.findViewById(R.id.iv_start);
        iv_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
