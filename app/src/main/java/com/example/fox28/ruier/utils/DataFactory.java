package com.example.fox28.ruier.utils;

import com.example.fox28.ruier.patient.model.bean.PGroupMemberEntity;
import com.example.fox28.ruier.patient.model.bean.PSinglePatientEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description: 生成模拟数据的工具类
 * @Author: Scorpion
 * @Date: 2018/9/30 14:45
 * @Tags:
 */
public class DataFactory {

    /**
     * 添加分组页面，生成adapter的模拟数据集
     * @param size
     * @return
     */
    public static List<PGroupMemberEntity> obtainListDataForAddGroup(int size) {
        List<PGroupMemberEntity> list = new ArrayList<>();
        for(int i=0; i<size; i++) {
            PGroupMemberEntity entity = new PGroupMemberEntity("病人" + i);
            list.add(entity);
        }
        return list;
    }
    /**
     * 添加分组页面，生成adapter的模拟数据集
     * @param size
     * @return
     */
    public static List<PSinglePatientEntity> obtainListDataForPatientList(int size) {
        List<PSinglePatientEntity> list = new ArrayList<>();
        for(int i=0; i<size; i++) {
            PSinglePatientEntity entity = new PSinglePatientEntity();
            entity.setName("病人" + i);
            entity.setNote("备注"+i);

            Calendar calendar=Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            entity.setStartTime(sdf.format(calendar.getTime()));

            list.add(entity);
        }
        return list;
    }
}
