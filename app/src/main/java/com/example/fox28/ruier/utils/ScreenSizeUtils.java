package com.example.fox28.ruier.utils;

import android.content.Context;
import android.view.View;


/**
 * Created by scorpion on 2018/4/19.
 *  （1）px和dip的转化
 */

public class ScreenSizeUtils {

    private static  volatile ScreenSizeUtils instance = null;
    private static Context con;

    public static ScreenSizeUtils getInstance(Context mContext) {
        if (instance == null) {
            synchronized (ScreenSizeUtils.class) {
                if (instance == null)
                    instance = new ScreenSizeUtils(mContext);
            }
        }
        return instance;
    }

    private ScreenSizeUtils(Context mContext) {
        con =mContext; // 实例化 con
    }


    public int dip2px(double dipValue) {

        float scale = con.getResources().getDisplayMetrics().density;

        return (int) (dipValue * scale + 0.5f);
    }

    public int px2dip(double pxValue) {

        float scale = con.getResources().getDisplayMetrics().density;

        return (int) (pxValue / scale + 0.5f);

    }

    /**
     * 测量View的宽高
     *
     * @param view View
     */
    public static void measureWidthAndHeight(View view) {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(widthMeasureSpec, heightMeasureSpec);
    }

    public static void release() {
        if (con != null) {
            con = null;
        }
        if (instance != null) {
            instance = null;
        }
    }

}
