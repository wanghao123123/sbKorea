package com.example.sb_korea.service;

import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author hao.wong
 * @date 2022/1/6
 */
public class MyCallable implements Callable {

    private Map<String,Object> map;

    public MyCallable(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public Object call() throws Exception {
        map.get("");
        return 1;
    }
}
