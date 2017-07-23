package com.example.yydkj.cachemanager;

import android.text.TextUtils;

import com.example.yydkj.utils.GsonUtil;

import java.lang.reflect.Type;
import java.util.List;


//可以看做一个工具类
public class LoadData {

    private LoadData () {

    }

    private static LoadData sLoadData = new LoadData();


    public static LoadData getInstance() {
        return sLoadData;
    }

    //获取json对象的方法
    public <T> T getBeanData(String url,Class<T> clazz) {

        String content = HttpManager.getInstance().dataGet(url);
        System.out.println("网络获取的数据:"+content);

        if (TextUtils.isEmpty(content)) {
            content = CacheManger.getInstance().getCacheData(url);

        } else {
            CacheManger.getInstance().saveData(content,url);
        }

        return parseJson(content,clazz);

    }

    //解析json数据
    private<T> T parseJson(String content,Class<T> clazz) {
        return GsonUtil.parseJsonToBean(content,clazz);

    }

    //获取json集合的方法
    public <T> List<T> getListData(String url, Type type) {
        String content = HttpManager.getInstance().dataGet(url);

        if (TextUtils.isEmpty(content)) {
            content = CacheManger.getInstance().getCacheData(url);

        } else {
            CacheManger.getInstance().saveData(content,url);
        }

        return parseJsonList(content,type);

    }

    private <T> List<T> parseJsonList(String content, Type type) {
        return GsonUtil.parseJsonToList(content,type);
    }


}
