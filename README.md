#### spring-mvc

##### 该怎么开始一个springmvc的项目



1. 引入相关依赖

        1） spring-webmvc 依赖
        2） servlet api依赖
        3） jackson依赖，返回json给用户
        
2. 配置web.xml

        1) dispatcherServlet依赖
        2) 字符集编码过滤器

3. 配置springmvc.xml

        1) 组件扫描器
        2) 声明mvc注解驱动
        3) 视图解析器
        4) 静态资源处理器

4. 定义Controller层
