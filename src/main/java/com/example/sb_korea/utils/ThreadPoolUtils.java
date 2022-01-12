package com.example.sb_korea.utils;

import cn.hutool.core.thread.ExecutorBuilder;

import java.util.concurrent.*;

/**
 * @author hao.wong
 * @date 2022/1/6
 */
public final class ThreadPoolUtils {

    private static ThreadPoolExecutor executor;

    static {
        if (null != executor) {
            executor.shutdownNow();
        }
        executor = ExecutorBuilder.create()
                .setCorePoolSize(Runtime.getRuntime().availableProcessors() * 4)
                .setMaxPoolSize(150)
                .setWorkQueue(new LinkedBlockingDeque<>(50))
                .build();
    }

    synchronized public static void shutdown(boolean isNow) {
        if (null != executor) {
            if (isNow) {
                executor.shutdownNow();
            } else {
                executor.shutdown();
            }
        }
    }

    public static <T> Future<T> submit(Callable<T> task) {
        return executor.submit(task);
    }

    public static Future<?> submit(Runnable runnable) {
        return executor.submit(runnable);
    }

}
