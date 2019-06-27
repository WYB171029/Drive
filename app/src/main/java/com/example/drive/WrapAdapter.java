package com.example.drive;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class WrapAdapter<T extends RecyclerView.Adapter> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //头部基本位置
    private static final int BASE_HEADER_VIEW_TYPE=-1<<10;
    private final T mRealAdapter;//本自定义控件对应的适配器
    private ArrayList<FixeViewInfo> mHeaderViewInfos= new ArrayList<>();

    public class FixeViewInfo{
        public View view;
        public int viewType;
    }
    //adapter RecyclerView 的数据适配器
    public WrapAdapter(T adapter) {
        super();
        mRealAdapter=adapter;

    }


    //数据 集合类

    //添加头部方法
    public void addHeaderView(View view){
        if (null ==view){
            throw new IllegalArgumentException("the view to add must not be null!");
        }
            final FixeViewInfo info=new FixeViewInfo();
            info.view=view;
            info.viewType=BASE_HEADER_VIEW_TYPE+mHeaderViewInfos.size();

            mHeaderViewInfos.add(info);
            notifyDataSetChanged();


    }
    public boolean isHeader(int viewType){
       return viewType>=BASE_HEADER_VIEW_TYPE && viewType<(BASE_HEADER_VIEW_TYPE+mHeaderViewInfos.size());
    }
    private boolean isHeadrPosition(int position){
        return position < mHeaderViewInfos.size();
    }

    @NonNull
    @Override//负责加载每个子项(头部，在这只负责头部)的布局，样式
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        //首先判断是不是为头部
        if (isHeader(viewType)){
            int whichHeader=Math.abs(viewType - BASE_HEADER_VIEW_TYPE);
            View headerView=mHeaderViewInfos.get(whichHeader).view;//1个头部试图
            return new RecyclerView.ViewHolder(headerView){};
        }else {
            return mRealAdapter.onCreateViewHolder(viewGroup,viewType);
        }

    }

    @Override//负责加载数据
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (position < mHeaderViewInfos.size()){

        }else if (position < mHeaderViewInfos.size() + mRealAdapter.getItemCount()){
            mRealAdapter.onBindViewHolder(viewHolder,
                    position - mHeaderViewInfos.size());
        }

    }

    @Override//数据条数
    public int getItemCount() {
        //头部数据量 mHeaderViewInfos.size()+数据列表数据量mRealAdapter.getItemCount（）
        return mHeaderViewInfos.size()+mRealAdapter.getItemCount();
    }
    @Override
    public int getItemViewType(int position){
        if (isHeadrPosition(position)){
            return mHeaderViewInfos.get(position).viewType;
        }else {
            return mRealAdapter.getItemViewType(position - mHeaderViewInfos.size());
        }
    }
}
