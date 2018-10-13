package com.example.fox28.ruier.patient.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

    private static final String TAG = "GroupManageActivity";

    public static final String KEY_SIZE = "list_size";

    @BindView(R.id.et_name)
    EditText mEtName;               // 编辑分组名称，如门诊
    @BindView(R.id.recyc_view)
    RecyclerView mRecycView;        // 患者头像列表
    @BindView(R.id.btn_delete)
    Button mBtnDelete;              // 删除按钮


    private ArrayList<PSinglePatientEntity> mList;      // 数据集
    private AddGroupAdapter mAdapter;                   // 适配器


    // 临时变量
    private int mTempSize;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        obtainIntentData(getIntent());
        super.onCreate(savedInstanceState);
    }

    /**
     * 获得intent数据
     * @param intent
     */
    private void obtainIntentData(Intent intent) {
        mTempSize = intent.getIntExtra(KEY_SIZE, 1);
    }

    @Override
    protected void initData() {
        super.initData();
        mList = DataFactory.obtainListDataForPatientList(mTempSize);
        mAdapter.setList(mList);
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
//        TextView btn = new TextView(this);
//        // todo 设置位置信息
//        btn.setText("保存");
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // todo 在下面方法中设置保存的网络请求，网络请求成功，返回分组列表
//                mAdapter.setConfirm();
//                // todo 下面的方法需要移到请求成功后执行
//                finish();
//            }
//        });
//        addViewToToolbar(btn);

        // 添加保存按钮
        Toolbar toolbar = getToolbar();
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_save:
                        // todo 在下面方法中设置保存的网络请求，网络请求成功，返回分组列表
                        mAdapter.setConfirm();
                        // todo 下面的方法需要移到请求成功后执行
                        finish();
                        break;
                }
                return true;
            }
        });

        // 绑定适配器
        mList = new ArrayList<>();
        mAdapter = new AddGroupAdapter(this, mList);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecycView.setLayoutManager(manager);
        mRecycView.setAdapter(mAdapter);
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
        if (requestCode == Constants.ADD_PATIENT_REQUEST_CODE && resultCode == RESULT_OK) {
            // 获得返回数据
            PSinglePatientEntity entity = (PSinglePatientEntity) data.getSerializableExtra(Constants.KEY_ADD_PATIENT_INTENT_RESULT);
            // 更新数据集并刷新数据
            mList.add(entity);
            mAdapter.setList(mList);
        }
    }
}
