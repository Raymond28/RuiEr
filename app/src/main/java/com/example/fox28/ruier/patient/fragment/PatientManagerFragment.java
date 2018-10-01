package com.example.fox28.ruier.patient.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fox28.ruier.R;
import com.example.fox28.ruier.utils.MFGT;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientManagerFragment extends Fragment {


    Unbinder unbinder;

    public PatientManagerFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_patient_manager, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 跳转监听事件
     * @param view
     */
    @OnClick({R.id.ll_add_patient, R.id.ll_add_group, R.id.ll_patientgroup_manager, R.id.ll_notice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_add_patient:   // 添加患者
                MFGT.gotoAddPatient(getActivity());
                break;
            case R.id.ll_add_group:     //添加新分组
                MFGT.gotoAddGroup(getActivity());
                break;
            case R.id.ll_patientgroup_manager:  //分组管理
                break;
            case R.id.ll_notice:        // 通知完善信息
            MFGT.gotoNoticeUpdateInfo(getActivity());
                break;
        }
    }
}
