package com.example.fox28.ruier.patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fox28.base.BaseActivity;
import com.example.fox28.ruier.R;
import com.example.fox28.ruier.patient.adapter.AddGroupAdapter;
import com.example.fox28.ruier.patient.model.bean.PSinglePatientEntity;
import com.example.fox28.ruier.utils.Constants;
import com.example.fox28.ruier.utils.DataFactory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddGroupActivity extends BaseActivity {

    @BindView(R.id.et_name)
    EditText mEtName;                 // 输入分组名称，如儿科
    @BindView(R.id.recyc_view)
    RecyclerView mRecycView;           // 患者头像

    private ArrayList<PSinglePatientEntity> mList;     // 数据集
    private AddGroupAdapter mAdpater;        // 适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initData() {
        super.initData();
        mList = DataFactory.obtainListDataForPatientList(3);
        mAdpater.setList(mList);
    }

    @Override
    protected void initView() {
        super.initView();
        initToolBar("添加分组");
        // 添加保存按钮
        Toolbar toolbar = getToolbar();
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_save:
                        // todo 在下面方法中设置保存的网络请求
                        mAdpater.setConfirm();
                        break;
                }
                return true;
            }
        });

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

    //设置menu（右边文字）
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_clinic, menu); //解析menu布局文件到menu
        return true;
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
