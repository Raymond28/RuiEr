package com.example.fox28.ruier.patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fox28.base.BaseActivity;
import com.example.fox28.ruier.R;
import com.example.fox28.ruier.patient.adapter.AddGroupAdapter;
import com.example.fox28.ruier.patient.model.bean.PSinglePatientEntity;
import com.example.fox28.ruier.utils.Constants;
import com.example.fox28.ruier.utils.DataFactory;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @Description:
 * @Author: Scorpion
 * @Date: 2018/10/1 11:02
 * @Tags:
 */
public class GroupManageActivity extends BaseActivity {

    @BindView(R.id.et_name)
    EditText mEtName;               // 编辑分组名称，如门诊
    @BindView(R.id.recyc_view)
    RecyclerView mRecycView;        // 患者头像列表
    @BindView(R.id.btn_delete)
    Button mBtnDelete;              // 删除按钮


    private ArrayList<PSinglePatientEntity> mList;      // 数据集
    private AddGroupAdapter mAdpater;                   // 适配器

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        super.initData();
        mList = DataFactory.obtainListDataForPatientList(10);
        mAdpater.setList(mList);
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar("提醒完善信息");
        // 显示删除按钮，设置单击事件
        mBtnDelete.setVisibility(View.VISIBLE);
        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupManageActivity.this, "开始删除当前分组，，，", Toast.LENGTH_LONG).show();
            }
        });

        // 分组名称
        mEtName.setText("门诊门诊门诊");

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.ADD_PATIENT_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // 获得返回数据
                PSinglePatientEntity entity = (PSinglePatientEntity) data.getSerializableExtra(Constants.KEY_ADD_PATIENT_INTENT_RESULT);
                // 更新数据集并刷新数据
                mList.add(entity);
                mAdpater.setList(mList);
            }
        }
    }
}