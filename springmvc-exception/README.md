###### springmvc 异常处理



###### 局部异常处理

在某个控制类中，使用@ExceptionHandler注解到某个
方法上，实现该controller内的特定异常处理。


###### 全局异常处理

定义一个全局的异常处理类，使用@ControllerAdvice
注解，加上异常处理方法@ExceptionHanler。

这个类作为组件被注册到spring的容器中，是对controller对象的
一个增强。






@ControllerAdvice



@ExceptionHandler

