package com.example.fox28.ruier.patient.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fox28.base.BaseActivity;
import com.example.fox28.ruier.R;
import com.example.fox28.ruier.patient.adapter.PatientListAdapter;
import com.example.fox28.ruier.patient.model.bean.PSinglePatientEntity;
import com.example.fox28.ruier.utils.DataFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddSinglePatientActivity extends BaseActivity {


    @BindView(R.id.rv_patient_list)
    RecyclerView mRvPatientList;        // RecyclerView，显示患者列表

    private List<PSinglePatientEntity> mList;
    private PatientListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initData() {
        super.initData();
        mList = DataFactory.obtainListDataForPatientList(15);
        mAdapter.setList(mList);
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar("选择患者");

        mList = new ArrayList<>();
        mAdapter = new PatientListAdapter(this, mList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRvPatientList.setAdapter(mAdapter);
        mRvPatientList.setLayoutManager(manager);
    }

    @Override
    protected void setContentLayout() {
        super.setContentLayout();
        setContentView(R.layout.p_activity_add_single_patient);
    }
}
