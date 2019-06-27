package com.example.drive;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {
    private View view;
    private RelativeLayout rl_video,rl_video1,rl_video2,rl_video3;


    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_video, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rl_video=view.findViewById(R.id.rl_video);
        rl_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),VideoPlayActivity.class);
                startActivity(intent);
            }
        });
        ImageView imageView=view.findViewById(R.id.iv_img_round);
        String imgUrl="https://toutiao.image.mucang.cn/toutiao-image/2019/06/24/10/9f3fcf50dd584d768e88fc0dcbec07ec.jpg!jpg";
        Glide.with(this).load(imgUrl).into(imageView);

        rl_video1=view.findViewById(R.id.rl_video1);
        rl_video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),VideoPlay1Activity.class);
                startActivity(intent);
            }
        });
        ImageView imageView1=view.findViewById(R.id.iv_img_round1);
        String imgUrl1="https://toutiao.image.mucang.cn/toutiao-image/2019/06/14/11/5907ee0d4d7e43d5ae4edb7f7bd9539a.jpg!jpg";
        Glide.with(this).load(imgUrl1).into(imageView1);

        rl_video2=view.findViewById(R.id.rl_video2);
        rl_video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),VideoPlay2Activity.class);
                startActivity(intent);
            }
        });
        ImageView imageView2=view.findViewById(R.id.iv_img_round2);
        String imgUrl2="https://toutiao.image.mucang.cn/toutiao-image/2019/06/21/14/85e5d1d3e5eb4a47ae4a097698ecbda9.jpg!jpg";
        Glide.with(this).load(imgUrl2).into(imageView2);

        rl_video3=view.findViewById(R.id.rl_video3);
        rl_video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),VideoPlay3Activity.class);
                startActivity(intent);
            }
        });
        ImageView imageView3=view.findViewById(R.id.iv_img_round3);
        String imgUrl3="https://toutiao.image.mucang.cn/toutiao-image/2019/06/23/20/4f44f9e0083340e9990e96e354cfa06e.jpg!jpg";
        Glide.with(this).load(imgUrl3).into(imageView3);
    }

}
