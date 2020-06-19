#### SpringMvc初体验


#### DispatcherServlet 前端控制器

继承FrameworkServlet，属于Servlet; 接收所有的请求，

在 spring-webmvc-5.2.5.RELEASE.jar包下。

##### 配置DisPatcherServlet

    
    <servlet>
        <servlet-name>dispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>dispatcherServlet</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>


    
    1）<init-param> 指明springMvc容器的配置文件。
    
    2）<load-on-startup>标签设定该servlet是tomcat启动时创建，还是接收到用户第一个请求时创建。
    
    大于等于0；是先创建，小于0，延迟创建。
    
    在<servlet/>中添加<load-on-startup/>的作用是，标记是否在Web服务器（这里是Tomcat）
    启动时会创建这个 Servlet 实例，即是否在 Web 服务器启动时调用执行该 Servlet 的 init()方
    法，而不是在真正访问时才创建。
    
    
    3）<url-pattern> 指明接收什么声明请求url；一般 /； *.do; *.action
       
       如果url-pattern配置为 /； 需要特殊处理。 因为dispatcherServlet会认为静态资源的请求也是一个普通的Controller请求。
       不是交给web服务器默认的servlet去处理静态资源。
       
       处理静态资源问题的方式有一下两种：
        
       一：使用注解 <mvc:default-servlet-handler/>
       二：使用注解 <mvc:resources mapping="/static/**" location="/static/"></mvc:resources>
        
       推荐使用第二种。


##### 开启组件扫描器

     <context:component-scan base-package="com.ljs.controller"/>
 
##### 注册视图解析器
    
    将逻辑视图转换成真正的视图；为我们拼接上前缀资源路径和后缀视图扩展名。
    
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix" value="/WEB-INF/jsp/"/>
            <property name="suffix" value=".jsp"/>
    </bean>


##### 实现处理类 @Controller




##### ModelAndView

    包含数据model和视图view。
    
    model中的数据将会被存放到Request域上，根据view视图做转发。

    

##### jsp 注意点


就是创建了jsp模板；有base的相对位置，

请求前不要加上 /

    <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";    
    %>
    <html>
    <head>
        <base href="<%=basePath %>"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Insert title here</title>
    </head>
    <body>
    
        <a href="stu/list.do"> 点击 list.do </a>
    
    </body>
    </html>



####  @RequestMapping  定义请求规则

1) 可作用在类，或者方法上。 与请求的uri路径匹配；用于定义处理器方法。

2）属性：
    
    value = 请求的url
    method = 请求的类型
    





