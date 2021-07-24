# sparkzxl-auth
## spring auth 项目基础架构组件
**采用spring cloud基本组件以及spring boot组件，对常见组件进行封装成业务开发组件，使用DDD领域驱动模型架构，构建分布式脚手架，减少不必要的环境的搭建，开箱即用，已有组件有授权登录，用户管理，网关，监控组件的通用集成**


## 推荐学习阅读文档
> 本项目所使用的的组件，均来自于自己封装的spring boot以及分布式组件库
[sparkzxl-component学习文档](https://sparkzxl.github.io/sparkzxl-component)

## 在线体验

- [spark auth](http://119.45.182.28:3000/login)

!> 账户：test 密码：123456

## 演示效果

![sparkzxl-demo-7.png](https://oss.sparksys.top/images/sparkzxl-demo-7.png)

![sparkzxl-demo-6.png](https://oss.sparksys.top/images/sparkzxl-demo-6.png)

![sparkzxl-demo-5.png](https://oss.sparksys.top/images/sparkzxl-demo-5.png)

![sparkzxl-demo-4.png](https://oss.sparksys.top/images/sparkzxl-demo-4.png)

![sparkzxl-demo-3.png](https://oss.sparksys.top/images/sparkzxl-demo-3.png)

![sparkzxl-demo-2.png](https://oss.sparksys.top/images/sparkzxl-demo-2.png)

![sparkzxl-demo-1.png](https://oss.sparksys.top/images/sparkzxl-demo-1.png)

## 开源博客
[凛冬王昭君的笔记](https://www.sparksys.top)

### 组织结构
> 主要是统一了对外接口的api访问格式，web模块进行了封装，基于DDD领域驱动模型设计代码，具体落地实施，对常用的core包进行二次封装，简单易用，elasticsearch，mybatis组件。集成了oauth2，redis多级缓存的构建，分布式锁的封装等等

```text
sparkzxl-auth
├── sparkzxl-auth-server       	                 -- 单点认证服务
├── sparkzxl-code-generator                      -- 代码生成工具
├── sparkzxl-gateway                             -- 网关服务
├── sparkzxl-job-admin                           -- 定时任务服务
├── sparkzxl-workflow                            -- 工作流服务
```

### 分布式系统架构
![分布式系统架构](https://oss.sparksys.top/images/system.png)
### 技术选型

技术 | 说明 | 官网
----|----|----
Spring Cloud | 全栈框架 | [https://spring.io/projects/spring-cloud/](https://spring.io/projects/spring-cloud/)
Spring Boot | 容器+MVC框架 | [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)
nacos | 服务注册发现以及服务配置中心 | [https://www.eurekanetwork.org/](https://www.eurekanetwork.org/)
spring security | 认证框架 | [https://spring.io/projects/spring-security](https://spring.io/projects/spring-security)
oauth2 | 授权框架 | [https://oauth.net/2/](https://oauth.net/2/)
spring-cloud-openfeign | 服务调用 | [https://spring.io/projects/spring-cloud-openfeign](https://spring.io/projects/spring-cloud-openfeign)
Jackson | Json工具 | |
sentinel | 分布式系统的流量防卫兵 | [https://github.com/alibaba/Sentinel](https://github.com/alibaba/Sentinel)
MyBatis | ORM框架  | [http://www.mybatis.org/mybatis-3/zh/index.html](http://www.mybatis.org/mybatis-3/zh/index.html)
MyBatis-Plus | 数据层代码生成 | https://mp.baomidou.com/ 
Elasticsearch | 搜索引擎 | [https://github.com/elastic/elasticsearch](https://github.com/elastic/elasticsearch)
Redis | 分布式缓存 | [https://redis.io/](https://redis.io/)
Docker | 应用容器引擎 | [https://www.docker.com/](https://www.docker.com/)
Druid | 数据库连接池 | [https://github.com/alibaba/druid](https://github.com/alibaba/druid)
OSS | 对象存储 | [https://github.com/aliyun/aliyun-oss-java-sdk](https://github.com/aliyun/aliyun-oss-java-sdk)
JWT | JWT登录支持 | [https://github.com/jwtk/jjwt](https://github.com/jwtk/jjwt)
Logback | 日志收集 | [http://logback.qos.ch/](http://logback.qos.ch/)
Lombok | 简化对象封装工具 | [https://github.com/rzwitserloot/lombok](https://github.com/rzwitserloot/lombok)


### 使用说明
> 关于sparkzxl-xxx-starter组件，是我自己封装的快捷脚手架框架[sparkzxl-component](https://sparkzxl.github.io/sparkzxl-component/)

1. nacos配置中心，预先安装nacos服务，安装方法请参考[nacos官网](https://nacos.io/zh-cn/docs/quick-start.html)
- 在config目录，导入压缩包到nacos中
![导入zip压缩包](https://oss.sparksys.top/images/1604982963903.jpg)

- 然后在bootstrap-dev.yaml修改对应你nacos注册配置地址，然后就可以启动了
