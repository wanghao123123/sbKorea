package com.example.sb_korea.config;

import com.example.sb_korea.vo.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author hao.wong
 * @date 2021/12/29
 */
@Component
public class MyListener {

private static final Logger logger = LoggerFactory.getLogger(MyListener.class);

    @EventListener(classes = UserDTO.class)
    public void userTtoListener(UserDTO dto){
        logger.info("UserDTO 监听器");
    }

    @EventListener(classes = ApplicationStartedEvent.class)
    public void userTtoListener(ApplicationStartedEvent dto){
        logger.info("【SpringApplication】--------------------- 启动成功 【执行时间】：{}",dto.getTimeTaken().getSeconds());
    }
}
