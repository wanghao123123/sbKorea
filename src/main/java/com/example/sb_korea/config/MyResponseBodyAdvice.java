package com.example.sb_korea.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author hao.wong
 * @date 2021/12/14
 */
@RestControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice {
    private static final Logger logger = LoggerFactory.getLogger(MyResponseBodyAdvice.class);
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        logger.error("ResponseBodyAdvice==============");
        return body;
    }
}
