package com.example.drive;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView tv_name;
    private CircleImageView iv_avatar;
    private boolean isLogin=false;


    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_me, container, false);
        initView(view);

        return view;
    }

    private void initView(View view) {

        tv_name=view.findViewById(R.id.tv_name);
        iv_avatar=view.findViewById(R.id.ib_avatar);
        iv_avatar.setImageResource(R.drawable.tu_biao);
        iv_avatar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_avatar:
                Intent intent=new Intent(getContext(), LoginActivity.class);

                startActivityForResult(intent,1);

                break;

        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null) {
            boolean idLogin = data.getBooleanExtra("isLogin", false);
            String userName = data.getStringExtra("loginUserName");
            tv_name.setText(userName);
            this.isLogin = isLogin;
        }

    }


}
