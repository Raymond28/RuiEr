package com.example.fox28.ruier.patient.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fox28.ruier.R;
import com.example.fox28.ruier.patient.activity.GroupManageActivity;
import com.example.fox28.ruier.patient.model.bean.PGroupEntity;
import com.example.fox28.ruier.utils.MFGT;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description:
 * @Author: Scorpion
 * @Date: 2018/10/13
 * @Tags:
 */
public class GroupListAdapter extends RecyclerView.Adapter {

    private ArrayList<PGroupEntity> mList;
    private Context mContext;

    public GroupListAdapter(Context context, ArrayList<PGroupEntity> list) {
        mList = list;
        mContext = context;
    }

    public void setList(ArrayList<PGroupEntity> list) {
        mList = list;
        notifyDataSetChanged();     // 刷新数据
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.p_recyc_item_grouplist, null);
        return new ViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder parentHolder, final int position) {
        ViewHolder holder = (ViewHolder) parentHolder;
        holder.refreshUI(mList.get(position));
        holder.mRlItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 跳转编辑分组界面
                // todo 需要传递数据 患者数据 list， 目前只传递size
                Log.e("main", "开始单击事件了 ， ， ， ， ， ， ");
                Intent intent = new Intent(mContext, GroupManageActivity.class);
                intent.putExtra(GroupManageActivity.KEY_SIZE, Integer.valueOf(mList.get(position).getNum()));
                MFGT.gotoGroupManage((Activity) mContext, intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.rl_item)
        RelativeLayout mRlItem;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void refreshUI(PGroupEntity entity) {
            if(entity == null) return;
            mTvName.setText(entity.getName()+"("+entity.getNum()+"人)");
        }
    }
}
