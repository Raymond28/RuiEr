package com.example.fox28.ruier.patient.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import com.example.fox28.base.BaseActivity;
import com.example.fox28.ruier.R;

import butterknife.BindView;

/**
 * @Description:
 * @Author: Scorpion
 * @Date: 2018/10/1 10:12
 * @Tags:
 */
public class NoticeUpdateInfoActivity extends BaseActivity {

    @BindView(R.id.tv_content)
    TextView mTvContent;                // 提醒的内容
    @BindView(R.id.btn_notice)
    Button mBtnNotice;                  // 一键提醒按钮

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar("提醒完善信息");
    }

    @Override
    protected void setContentLayout() {
        super.setContentLayout();
        setContentView(R.layout.p_activity_notice_update_info);
    }
}
