package com.example.drive;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

import com.example.drive.WrapAdapter;

public class WrapRecyclerView extends RecyclerView {
    private WrapAdapter mWrapAdapter;
    private ArrayList<View> mTmpHeaderView=new ArrayList<>();

    public WrapRecyclerView(@NonNull Context context) {
        super(context);
    }

    public WrapRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WrapRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(@Nullable Adapter adapter) {
        if (adapter instanceof WrapAdapter){
            mWrapAdapter=(WrapAdapter) adapter;
            super.setAdapter(mWrapAdapter);
        }else {//该设备器只包含数据，没有头部
            mWrapAdapter=new WrapAdapter(adapter);
            for (View view :mTmpHeaderView){

                mWrapAdapter.addHeaderView(view);
            }
            if (mTmpHeaderView.size()>0){
                mTmpHeaderView.clear();
            }
            super.setAdapter(mWrapAdapter);

        }

    }
    public void addHeaderView(View view){
        if (null==view){
            throw new IllegalArgumentException("the view to add must not be null!");

        }else if (mWrapAdapter==null){
            mTmpHeaderView.add(view);
        }else {
            mWrapAdapter.addHeaderView(view);
        }
    }
}
