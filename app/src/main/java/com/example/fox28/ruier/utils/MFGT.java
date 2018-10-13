package com.example.fox28.ruier.utils;

import android.app.Activity;
import android.content.Intent;

import com.example.fox28.ruier.patient.activity.AddGroupActivity;
import com.example.fox28.ruier.patient.activity.AddPatientActivity;
import com.example.fox28.ruier.patient.activity.AddSinglePatientActivity;
import com.example.fox28.ruier.patient.activity.GroupListActivity;
import com.example.fox28.ruier.patient.activity.GroupManageActivity;
import com.example.fox28.ruier.patient.activity.NoticeUpdateInfoActivity;


/**
 * Created by apple on 2017/5/23.
 */

public class MFGT {

    /**
     * 关闭Activity
     * @param activity
     */
    public static void finish(Activity activity) {
        activity.finish();
    }

    /**
     * 启动Activity
     * @param activity
     * @param cls
     */
    public static void startActivity(Activity activity, Class cls) {
        activity.startActivity(new Intent(activity, cls));
    }

    /**
     * 重载方法：启动Activity
     * @param activity
     * @param intent
     */
    public static void startActivity(Activity activity, Intent intent) {
        activity.startActivity(intent);

    }

    /**
     * 有返回值的启动Activity
     * @param activity
     * @param intent
     * @param requestCode
     */
    public static void startActivityForResult(Activity activity, Intent intent, int requestCode) {
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 重载方法：有返回值的启动Activity
     * @param activity
     * @param cls
     * @param requestCode
     */
    public static void startActivityForResult(Activity activity, Class cls, int requestCode) {
        activity.startActivityForResult(new Intent(activity, cls), requestCode);
    }

    /**
     * 跳转添加患者界面
     * @param activity
     */
    public static void gotoAddPatient(Activity activity) {
        startActivity(activity, AddPatientActivity.class);
    }

    /**
     * 跳转添加分组界面
     * @param activity
     */
    public static void gotoAddGroup(Activity activity) {
        startActivity(activity, AddGroupActivity.class);
    }

    /**
     * 跳转添加患者界面
     * @param activity
     */
    public static void gotoAddSinglePatientForResult(Activity activity, int requestCode) {
        startActivityForResult(activity, AddSinglePatientActivity.class, requestCode);
    }

    /**
     * 跳转分组管理界面
     * @param activity
     */
    public static void gotoGroupManage(Activity activity) {
        startActivity(activity, GroupManageActivity.class);
    }

    /**
     * 跳转分组列表界面
     * @param activity
     */
    public static void gotoGroupList(Activity activity) {
        startActivity(activity, GroupListActivity.class);
    }

    /**
     * 跳转提醒完善信息界面
     * @param activity
     */
    public static void gotoNoticeUpdateInfo(Activity activity) {
        startActivity(activity, NoticeUpdateInfoActivity.class);
    }




}