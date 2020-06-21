#### 转发和重定向的区别


###### 前提
    springmvc 转发和重定向是不与视图处理器一起工作的。
    如果想转发或者重定向到某个视图，一定是需要指明视图的完整路径。


#### 请求重定向， redirect 

    在进行重定向处理时，服务器会告诉浏览器目标资源的地址，
    浏览器会再次一个请求，进行资源访问。
    
    浏览器使用了两次请求处理。 访问目标资源还是通过浏览器发出的一个请求。

###### 特点
    
    1） 不能重定向到受保护资源，类型 WEB-INF 目录下的文件。
    2） 可以通过url带参数实现重定向传递数据。最后都是发送get请求，通过get的请求参数发送数据。

###### 使用场景

    一般用在post请求处理方法之后，不希望在刷新，回退是，重复提交表单，需要个重定向。
    
###### 实现代码形式  
  
    在视图路径前加入关键字： redirect

    1) response.sendRedirect("myjsp/myredirect.jsp?name=response");
    
    2) 使用modelAndView; 
    mv.addObject("age", "23");
    mv.setViewName("redirect:myjsp/myredirect.jsp");
    return mv;
          
    
    3) 视图路径前加入redirect  
    String name = "wowo";
    return "redirect:myjsp/myredirect.jsp?&name=" + name;


#### 请求转发， dispatcher

    进行请求转发处理时， 服务器内部将该请求转发,访问另外的一个资源。
    使用的是同一请求，所有是转发前后是共享请求域的数据的。

##### 特点

    转发前后都是使用同一个请求。因为是通过服务器访问最终的资源，可以访问WEB-INF下面的
    资源。

##### 使用场景
    
    经典的是处理完请求之后，把处理结果封装成模型数据，然后转发给某个视图；
    经过视图渲染结果。
    
##### 代码使用形式：
    
    1) request.getRequestDispatcher("/WEB-INF/jsp/some.jsp?age=23").forward(request, response);、
    2)  
        request.setAttribute("name", "dispatcher1");
        return "forward:/WEB-INF/jsp/some.jsp?age=23";
    3) 
        
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "modelAndView");
        mv.setViewName("forward:/WEB-INF/jsp/some.jsp?age=21");
        return mv;















    
    
    


