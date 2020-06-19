#### Springmvc in action



#### 处理器方法的参数

处理器方法可以包含以下四类参数，这些参数会在系统调用时由系统自动赋值，即程序
员可在方法内直接使用。

    ➢ HttpServletRequest
    ➢ HttpServletResponse
    ➢ HttpSession
    ➢ 请求中所携带的请求参数

一般接收参数的情况：

##### 1. 逐个接收，请求参数和方法形参一样。

    public void geStudent(String name, String age ){
    
    }

##### 2. 逐个接收，请求参数和方法形参不一样，

    需要使用@RequestParam注解进行参数矫正。
    
    属性：
        value: 代表是请求参数名称。
        required: 默认是true, 代表请求中必须有该参数，否者失败。
        
        
     @RequestMapping(value = "/param.do", method = RequestMethod.POST)
     public ModelAndView doParameter(HttpServletRequest request, @RequestParam("rname") String name, @RequestParam("rage") Integer age){
    
            ModelAndView modelAndView = new ModelAndView();
    
            System.out.println("name = " + name);
            System.out.println("age = " + age);
    
            modelAndView.addObject("name", name);
            modelAndView.addObject("age", age);
            modelAndView.addObject("url", request.getRequestURL().toString());
            modelAndView.setViewName("result");
    
            return modelAndView;
    
    }


##### 3. 使用对象参数；要求请求参数和对象的属性一样。

      @RequestMapping(value = "/getParamByObject", method = RequestMethod.POST)
        public ModelAndView getParambyObject(HttpServletRequest request, StudentVo studentVo){
    
            ModelAndView modelAndView = new ModelAndView();
    
            System.out.println("name = " + studentVo.getName());
            System.out.println("age = " + studentVo.getAge());
    
            modelAndView.addObject("name", studentVo.getName());
            modelAndView.addObject("age", studentVo.getAge());
            modelAndView.addObject("url", request.getRequestURL().toString());
            modelAndView.setViewName("result");
    
            return modelAndView;
      }
    
    
#### 处理器方法返回值

##### 1. 返回ModelAndView



##### 2. 返回逻辑视图 String


##### 3. 返回void, 结果通过HttpServletResponse 返回内容。

    response.setContentType("application/json;charset=utf8");
    PrintWriter writer = response.getWriter();
    writer.write("这是一个response");
    writer.flush();


##### 4. 返回对象， @ResponseBody


    1) 返回给用json字符串，需要引入 jackson依赖
    2) 需要注解@ResponseBody
    3) 声明  <mvc:annotation-driven/> 注解驱动


##### 4. 返回String + @ResponseBody

    
    返回String字符串给用户，含有中文需要produces属性处理，
    
    @RequestMapping(
                value = "/string", produces = "text/application;charset=utf8")
        @ResponseBody
        public String getString(){
    
    
            return "我是个Tina才";
    
        }
        