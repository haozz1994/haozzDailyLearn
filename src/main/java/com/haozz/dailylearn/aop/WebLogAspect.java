package com.haozz.dailylearn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * https://www.cnblogs.com/zwakeup/p/10505425.html
 *
 * @author: haozz
 * @date: 2020/1/14 22:20
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger(this.getClass().toString());

    @Pointcut("execution(* com.haozz.dailylearn.aop.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("before : " + LocalTime.now());
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录请求内容
        logger.info(" ===== URL : " + request.getRequestURL().toString());
        logger.info(" ===== HTTP_METHOD : " + request.getMethod());
        logger.info(" ===== IP : " + request.getRemoteAddr());
        logger.info(" ===== CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info(" ===== ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        System.out.println("after : " + LocalTime.now());
        //处理完请求，返回内容
        logger.info(" ===== RESPONCE : " + ret);
    }
}
