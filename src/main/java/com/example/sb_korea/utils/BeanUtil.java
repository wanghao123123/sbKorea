package com.example.sb_korea.utils;

import java.io.*;

/**
 * @author hao.wong
 * @date 2021/12/24
 */
public class BeanUtil {

    /**
     * 拷贝对象需要序列化
     * @param o
     * @param <T>
     * @return
     * @throws RuntimeException
     */
    public static <T> T deepClone(T o) throws RuntimeException {
        try {
            // 将对象写到流里
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(o);
            // 从流里读出来
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            @SuppressWarnings("unchecked")
            T data1 = (T) oi.readObject();
            return data1;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

