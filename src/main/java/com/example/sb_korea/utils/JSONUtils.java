package com.example.sb_korea.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * @author hao.wong
 * @date 2021/12/27
 */
public class JSONUtils {


    /**
     * 获取嵌套对象的值
     * @param key
     * @param json
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T parse(String key, String json, Class<T> t) {
        List<String> points = Arrays.asList(key.split("\\."));
        JSONObject jsonObject = JSONObject.parseObject(json);
        for (int i = 0; i <points.size() ; i++) {
            if(i==points.size()-1) {
                return get(points.get(i), jsonObject, t);
            }else{
                jsonObject=get(points.get(i),jsonObject,JSONObject.class);
            }
        }
        return null;
    }


    public static <T> T get(String key, JSONObject jsonObject,Class<T> parseT) {
        String o = jsonObject.getString(key);
        return JSONObject.parseObject(o, parseT);
    }

    public static JSONArray getList(String key, JSONObject jsonObject) {
        String o = jsonObject.getString(key);
        return JSONArray.parseArray(o);
    }

}
