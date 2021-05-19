package com.iterators.spring.example.aop.aspect;

import com.iterators.spring.example.aop.annotation.WhitelistAnnotation;
import com.iterators.spring.example.aop.component.whitelist.IWhitelistService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * 请求参数切面
 *
 * @author iterators
 * @date 2020/12/18 下午2:30
 */
@Aspect
@Component
@Slf4j
public class WhitelistAspect {

    private final IWhitelistService whitelistService;

    public WhitelistAspect(IWhitelistService whitelistService) {
        this.whitelistService = whitelistService;
    }

    @Pointcut(value = "@annotation(com.iterators.spring.example.aop.annotation.WhitelistAnnotation)")
    public void whitelistAnnotationFilter() {
    }

    @Around("whitelistAnnotationFilter()")
    public Object aroundAdviceForHello(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        extractJoinPointInfo(proceedingJoinPoint);
        extractProxyInfo(proceedingJoinPoint);
        Map<String, Object> params = getNameAndValue(proceedingJoinPoint);
        log.info("method params: {}", params);
        Object filterProperty = getFilterPropertyForMethod(proceedingJoinPoint);
        Object o = Optional.ofNullable(filterProperty)
            .map(propertyName -> params.getOrDefault(propertyName, ""))
            .orElse("");
        if (o instanceof Integer) {
            Integer id = (Integer) o;
            log.info("o: {}", id);
            if (whitelistService.getWhitelist().contains(id)) {
                return "filter by whitelist";
            }
        }
        return proceedingJoinPoint.proceed();
    }

    /**
     * 获取方法参数Map集合
     *
     * @author iterators
     * @date 2020/12/18 下午2:51
     */
    private Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint) {
        Map<String, Object> param = new HashMap<>(16);
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            param.put(paramNames[i], paramValues[i]);
        }
        return param;
    }

    /**
     * 获取连接点的方法注解
     *
     * @author iterators
     * @date 2020/12/18 下午2:51
     */
    private Object getFilterPropertyForMethod(ProceedingJoinPoint joinPoint) {
        Class<?> targetClazz = joinPoint.getTarget().getClass();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        log.info("Target class: {}, name: {}", targetClazz, name);
        WhitelistAnnotation whitelistAnnotation = signature.getMethod().getAnnotation(WhitelistAnnotation.class);
        String filterPropertyName = "";
        if (Objects.nonNull(whitelistAnnotation)) {
            filterPropertyName = whitelistAnnotation.value();
            log.info("filterPropertyName: {}", filterPropertyName);
        }
        return filterPropertyName;
    }

    private void extractJoinPointInfo(ProceedingJoinPoint joinPoint) {
        log("Join Point Info Start");
        Signature signature = joinPoint.getSignature();
        log.info("signature: {}, kind: {}, sourceLocation: {}", signature, joinPoint.getKind(), joinPoint.getSourceLocation());
        Object target = joinPoint.getTarget();
        Object aThis = joinPoint.getThis();
        log.info("target: {}, this: {}", target, aThis);
        log("Join Point Method Info Start");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Class returnType = methodSignature.getReturnType();
        String[] parameterNames = methodSignature.getParameterNames();
        Class[] parameterTypes = methodSignature.getParameterTypes();
        log.info("Method: {}, returnType: {}, parameterNames: {}, parameterTypes: {}", method, returnType, parameterNames, parameterTypes);
    }

    private void extractProxyInfo(ProceedingJoinPoint joinPoint) {
        Object currentProxy = AopContext.currentProxy();
        Class<?> proxyClazz = currentProxy.getClass();
        log.info("Proxy: {}, clazz: {}", proxyClazz, proxyClazz);
    }

    private void log(String info) {
        log.info("#######################{}#############################", info);
    }
}
