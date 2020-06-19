#### SSM 整合

spring + springmvc + mybatis 整合，成为系统开发框架。

springmvc 容器：负责controller层

spring 容器：负责和mybatis 的整合，事务，service层。



##### 整合步骤


1. 引入依赖

        1) spring
        2) springmvc
        3) mybatis
        4) 数据库连接池
        5) spring事务相关
        6) jdbc
        7) jsp
        8) servlet-api
        9) mysql 驱动
    
2. 配置web.xml

        1) dispatcherServlet
        2) characterEncodingFilter
        3) servletContextLoader


3. entity, dao, service, controller 相关包


4. 配置springmvc.xml 【创建springmvc容器】

        1) 组件扫描器  [controller层]
        2) 视图解析器
        3) mvc注解驱动
        4) 静态资源处理
    
5. 配置mybatis

        1) 实体类别名
        2) mapper映射器
    
6. 配置spring.xml
    
        1) 配置数据源
        2) sqlSessionFactoryBean
        3) MapperScannerConfigurer 
        4) 事务管理器
        5) 启动事务注解扫描器
        6) 注解驱动器   [service层]
        

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
