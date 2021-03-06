package com.example.fox28.ruier.patient.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fox28.base.BaseActivity;
import com.example.fox28.ruier.R;
import com.example.fox28.ruier.patient.adapter.GroupListAdapter;
import com.example.fox28.ruier.patient.model.bean.PGroupEntity;
import com.example.fox28.ruier.utils.DataFactory;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GroupListActivity extends BaseActivity {

    @BindView(R.id.recyc_view)
    RecyclerView mRecycView;

    private ArrayList<PGroupEntity> mList;
    private GroupListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        super.initData();

        mList = DataFactory.obtainListDataForGroupList(15);
        mAdapter.setList(mList);

    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar("分组管理");
        mList = new ArrayList<>();
        mAdapter = new GroupListAdapter(this, mList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecycView.setAdapter(mAdapter);
        mRecycView.setLayoutManager(manager);
        //添加自定义分割线
        DividerItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(this,R.drawable.custom_divider));
        mRecycView.addItemDecoration(divider);
    }

    @Override
    protected void setContentLayout() {
        super.setContentLayout();
        setContentView(R.layout.p_activity_group_list);
    }
}
