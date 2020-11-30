# Spring examples

## Spring cache

### 整合Caffeine步骤

1. 引入Caffeine依赖
    - 引入依赖`CaffeineCacheConfiguration`自动配置才会生效)
2. spring 配置缓存类型为
    - `spring.cache.type=caffeine`
3. 配置caffeine缓存
    - `spring.affeine.spec: maximumSize=500,expireAfterAccess=600s`
