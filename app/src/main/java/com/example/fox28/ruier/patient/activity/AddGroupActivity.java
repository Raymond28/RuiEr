package com.example.fox28.ruier.patient.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fox28.base.BaseActivity;
import com.example.fox28.ruier.R;
import com.example.fox28.ruier.patient.adapter.AddGroupAdapter;
import com.example.fox28.ruier.patient.model.bean.PSinglePatientEntity;
import com.example.fox28.ruier.utils.DataFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddGroupActivity extends BaseActivity {

    @BindView(R.id.et_name)
    EditText mEtName;                 // 输入分组名称，如儿科
    @BindView(R.id.recyc_view)
    RecyclerView mRecycView;           // 患者头像

    private List<PSinglePatientEntity> mList;     // 数据集
    private AddGroupAdapter mAdpater;        // 适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initData() {
        super.initData();
        mList = DataFactory.obtainListDataForPatientList(11);
        mAdpater.setList(mList);
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar("添加分组");
        // 添加保存按钮
        TextView btn = new TextView(this);
        // todo 设置位置信息
        btn.setText("保存");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // todo 在下面方法中设置保存的网络请求
                mAdpater.setConfirm();
            }
        });
        addViewToToolbar(btn);

        // 绑定适配器
        mList = new ArrayList<>();
        mAdpater = new AddGroupAdapter(this, mList);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecycView.setLayoutManager(manager);
        mRecycView.setAdapter(mAdpater);
    }

    @Override
    protected void setContentLayout() {
        super.setContentLayout();
        setContentView(R.layout.p_activity_add_group);
    }
}
