package com.example.sb_korea.task;

import cn.hutool.core.date.LocalDateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author hao.wong
 * @date 2022/1/27
 */
@Component
@Slf4j
public class LogTask {

    @Scheduled(cron = "0/7 * * * * ?")
    public void logger(){
        log.info("{}-测试Loki+Promtail+Grafana-看看成果", LocalDateTimeUtil.format(LocalDateTime.now(),"yyyy-MM-dd HH:mm:ss"));
    }

}
