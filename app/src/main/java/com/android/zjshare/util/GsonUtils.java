package com.android.zjshare.util;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

/**
 * Created by zhangjia on 16/8/25.
 */
public class GsonUtils {


    public static String parseToString(Object object) {
        if(null != object) {
            return JSON.toJSONString(object);
        }
        return "";
    }

    public static <T> T parseFromString(String content, Class<T> clazz) {
        try{
            if(!TextUtils.isEmpty(content)) {
                return JSON.parseObject(content, clazz);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
