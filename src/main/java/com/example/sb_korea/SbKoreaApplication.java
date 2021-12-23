package com.example.sb_korea;

import com.example.sb_korea.config.MyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ServletComponentScan
@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableWebMvc
public class SbKoreaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SbKoreaApplication.class, args);
    }

}
