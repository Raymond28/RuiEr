package com.example.fox28.ruier.patient.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fox28.ruier.R;
import com.example.fox28.ruier.patient.model.bean.PSinglePatientEntity;
import com.example.fox28.ruier.utils.Constants;
import com.example.fox28.ruier.utils.MFGT;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @Description: 患者列表的adapter，使用场景————分组添加成员时
 * @Author: Scorpion
 * @Date: 2018/10/1 01:19
 * @Tags:
 */
public class PatientListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private ArrayList<PSinglePatientEntity> mList;

    /**
     * RecyclerView列表项的类型：分别对应页脚和其他列表项
     */
    public static final int TYPE_FOOTER = 910;
    public static final int TYPE_ITEM = 909;

    private boolean isMore;     // 标识符，数据是否加载完毕

    public PatientListAdapter(Context context, ArrayList<PSinglePatientEntity> list) {
        mContext = context;
        if (list != null) {
            mList = (ArrayList<PSinglePatientEntity>) list.clone();
        }
    }

    /**
     * 设置和刷新数据
     *
     * @param list
     */
    public void setList(ArrayList<PSinglePatientEntity> list) {
        if (list != null) {
            mList = (ArrayList<PSinglePatientEntity>) list.clone();
            notifyDataSetChanged();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.p_recyc_item_p_list_item, null);
        return new ItemHolder(contentView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder parentHolder, int position) {
        ItemHolder holder = (ItemHolder) parentHolder;
        holder.refreshUI(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size() ;
    }


    class ItemHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_select)
        ImageView mIvSelect;
        @BindView(R.id.civ_avatar_p_l)
        CircleImageView mCivAvatarPL;
        @BindView(R.id.tv_name_p_l)
        TextView mTvNamePL;
        @BindView(R.id.tv_note)
        TextView mTvNote;
        @BindView(R.id.tv_startTime)
        TextView mTvStartTime;

        ItemHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void refreshUI(final PSinglePatientEntity entity) {
            if(entity==null) return;
            mIvSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIvSelect.setImageResource(R.mipmap.patient_select_s);
                    //  返回添加分组界面，并且传递实体类
                    Intent intent = new Intent();
                    intent.putExtra(Constants.KEY_ADD_PATIENT_INTENT_RESULT, entity);
                    ((Activity)mContext).setResult(Activity.RESULT_OK, intent);
                    MFGT.finish((Activity) mContext);

                }
            });
            mTvNamePL.setText(entity.getName());
            mTvNote.setText(entity.getNote());
            mTvStartTime.setText(entity.getStartTime());
            Glide.with(mContext)
                    .load(entity.getUrl())
                    .centerCrop()
                    .dontAnimate()      //防止设置placeholder导致第一次不显示网络图片,只显示默认图片的问题
                    .error(R.mipmap.patient_member_head)
                    .placeholder(R.mipmap.patient_member_head)
                    .into(mCivAvatarPL);


        }
    }
}
