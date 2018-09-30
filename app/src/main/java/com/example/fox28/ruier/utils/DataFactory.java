package com.example.fox28.ruier.utils;

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
     * 添加分组成员页面，生成adapter的模拟数据集
     * @param size
     * @return
     */
    public static ArrayList<PSinglePatientEntity> obtainListDataForPatientList(int size) {
        ArrayList<PSinglePatientEntity> list = new ArrayList<>();
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
