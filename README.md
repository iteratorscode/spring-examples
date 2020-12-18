# Spring examples

## Spring cache

### 整合Caffeine步骤

1. 引入Caffeine依赖
    - 引入依赖`CaffeineCacheConfiguration`自动配置才会生效)
2. spring 配置缓存类型为
    - `spring.cache.type=caffeine`
3. 配置caffeine缓存
    - `spring.affeine.spec: maximumSize=500,expireAfterAccess=600s`

### Aop注意事项
```properties
# 关闭JDK代理
spring.aop.proxy-target-class = false
```

> 在 AopUtils.getMostSpecificMethod(method, targetClass) 方法中
1.jdk代理的targetClass 是 Proxy的子类，获取到的method是新类的method ，新类的方法不会带注解
2.cglib 代理后，但是它的targetClass 还是父类 (比如 RealSubject.java) ，获取到的则是 RealSubject.java 的方法而不是新类的方法，所以拿得到注解

[参考链接](https://juejin.cn/post/6844903831805886477)
