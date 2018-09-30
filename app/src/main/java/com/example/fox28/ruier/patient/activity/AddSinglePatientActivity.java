package com.example.fox28.ruier.patient.activity;

import android.os.Bundle;

import com.example.fox28.base.BaseActivity;
import com.example.fox28.ruier.R;

public class AddSinglePatientActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar("选择患者");
    }

    @Override
    protected void setContentLayout() {
        super.setContentLayout();
        setContentView(R.layout.p_activity_add_single_patient);
    }
}
