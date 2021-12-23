package com.example.sb_korea.config;

import org.apache.el.util.ReflectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * @author hao.wong
 * @date 2021/12/14
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(MyBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("myController".equals(beanName)) {
            Class<?> aClass = bean.getClass();
            System.err.println();
            ReflectionUtils.doWithLocalFields(aClass,a->{
                System.err.println(a.getName());});
//            ReflectionUtils.doWithFields(bean.getClass(), a -> {
//                Object name = a.get("name");
//                String chars="hao.wong";
//                a.set(name,chars);
//                System.err.println(a.get("name"));
//                System.err.println(a.getName());
//            });
        }

        return bean;
    }
}
