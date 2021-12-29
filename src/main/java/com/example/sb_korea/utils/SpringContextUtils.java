package com.example.sb_korea.utils;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author hao.wong
 * @date 2021/12/29
 */
@Component(value = "SpringContextUtils")
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //获取Bean
    public static <T> T getBean(Class<T> requiredType) {
        return getApplicationContext().getBean(requiredType);
    }

    public static <T> T getBean(String name) {
        return (T) getApplicationContext().getBean(name);
    }

    public static <T> void publishEvent(T o){
        getApplicationContext().publishEvent(o);
    }

    public static void publishEvent(ApplicationEvent event){
        getApplicationContext().publishEvent(event);
    }
}
