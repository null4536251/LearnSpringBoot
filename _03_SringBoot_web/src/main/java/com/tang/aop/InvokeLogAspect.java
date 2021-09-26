package com.tang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect//标识这是一个切面类
@Component
public class InvokeLogAspect {
    //确定切点
    @Pointcut("@annotation(com.tang.aop.InvokeLog)")
    public void pt(){

    }
    @Around("pt()")
    public Object printInvokeLog(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        System.out.println(methodName + "即将被调用");
        //目标方法调用前
        try {
            proceed = joinPoint.proceed();
            //目标方法调用后
            System.out.println(methodName + "被调用完了");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("出现了异常");
        }
        return proceed;
    }
}
