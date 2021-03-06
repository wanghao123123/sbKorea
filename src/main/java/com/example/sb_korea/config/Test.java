package com.example.sb_korea.config;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.cron.CronUtil;
import com.example.sb_korea.service.MyCallable;
import com.example.sb_korea.utils.JSONUtils;
import com.example.sb_korea.utils.ThreadPoolUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author hao.wong
 * @date 2021/12/14
 */
public class Test {

    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter YYYY_MM = DateTimeFormatter.ofPattern("yyyy-MM");

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ROUND_HALF_UP
        BigDecimal bigDecimal = new BigDecimal("998").divide(new BigDecimal("3"),0, RoundingMode.CEILING);
        System.err.println(bigDecimal);

        String json="{\n" +
                "    \"a\":{\n" +
                "        \"b\":{\n" +
                "            \"c\":{\n" +
                "                \"d\":12\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Integer parse1 = JSONUtils.parse("a.b.c.d", json, Integer.class);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            Future submit = executorService.submit(new MyCallable(new HashMap<>()));
            Integer o = (Integer) submit.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CronUtil.schedule("0 0/1 * * * ?", (Runnable) ()->{
            System.err.println(1);
        });


        new ThreadPoolExecutor(1,1,1,TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(100),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

//        System.err.println();

    }


    /**
     * 获取用户增加金额
     * @param currentNum 当前金额
     * @param totalNum 领取所需金额数
     * @param assistPersonNum 领取所需总人数
     * @param currPersonNum 当前助力人数
     * @return
     */
    public static long getAddVal(long currentNum, long totalNum, int assistPersonNum, int currPersonNum) {
        // 判断金额超过总金额
        if (currentNum >= totalNum) {
            return 0;
        }
        // 需要助力人数
        int needAssistPersonNum = assistPersonNum - currPersonNum;
        // 如果只差1人
        if (needAssistPersonNum <= 1) {
            return (int) (totalNum - currentNum);
        }

        // 需要金额
        long needNum = totalNum - currentNum;
        // 最小值
        long lowLimit =needNum / needAssistPersonNum;

        // 浮动值 = 剩余需要金额 / 5 * 助力总人数 ===> 即 当前金额越高 浮动值越低
        int factor = (int) (needNum / (5 * assistPersonNum));
        // 平均 = 需要金额 / 需要助力人数
        long avg = needNum / needAssistPersonNum;
        // 如果 平均金额 > 100（假设平均值100）  平均金额 +- 100随机
        Random random = new Random();
        // 人数大时会出现 factor = 1 或者 0 抛出random无意义异常
        int factorRandom = factor <= 1 ? 1 : random.nextInt(factor);
        // 这里返回的 -100 ~ 400 之间的数值 前面的金额大的概率会很高 ，越往后平均值越低，得到的红包值越小。
        return Math.min((avg + (5* factorRandom - factor)), lowLimit);
    }


}
