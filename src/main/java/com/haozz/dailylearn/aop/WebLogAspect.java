package com.haozz.dailylearn.aop;

import com.alibaba.druid.support.json.JSONUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * https://www.cnblogs.com/zwakeup/p/10505425.html
 * https://blog.csdn.net/lmb55/article/details/82470388
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








    //===========================================================================================
    /**
     * 前置通知，方法调用前被调用
     * @param joinPoint/null
     */
    @Before("webLog()")
    public void before(JoinPoint joinPoint){
        logger.info("前置通知");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        logger.info("代理的是哪一个方法"+signature.getName());
        //AOP代理类的名字
        logger.info("AOP代理类的名字"+signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        //获取请求参数
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = new HashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }
        String str = JSONUtils.toJSONString(parameterMap);
        if(obj.length > 0) {
            logger.info("请求的参数信息为："+str);
        }
    }
}
