
##### spring mvc 文件上传和下载


multipart格式的数据会将一个表单拆分为多个部分（part），每个部分对应一个输入域。
在一般的表单输入域中，它所对应的部分中会放置文本型数据，但是如果上传文件的话，它所对应的部分可以是二进制
    
    表单：
        基本类型： 文件类型数据
        文件： 二进制文件
    

### 实验步骤

##### 配置multipart解析器

1.引入依赖
   <!-- 文件上传 -->
    <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>1.3.1</version>
    </dependency>
    
2. 定义multipart解析器 
        
        
    <!-- 配置文件上传解析器 id:必须是multipartResolver-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="#{1024*1024*80}"/>
        <property name="defaultEncoding" value="utf-8"/>
    </bean>
    
3. 处理器方法 使用MultipartFile 接受文件


##### MultipartFile 文件[file]保存到本地的方式

1. 转换成字节数组  


    byte[] bytes = file.getBytes();   // 转换成字节数组
    FileOutputStream outputStream = new FileOutputStream(f);
    outputStream.write(bytes);
    outputStream.close();
    
    
    
2. 转换成输入流，inputStream



    InputStream inputStream = file.getInputStream();
    FileOutputStream outputStream = new FileOutputStream(f);
    byte bytes[] = new byte[1024];
    int i = 0;
    while ( (i = inputStream.read(bytes)) != -1 ) {
        outputStream.write(bytes, 0, i);
    }
    outputStream.close();    



3. 使用方法 transferTo(new File()) 方法。


     file.transferTo(f);
    
    

##### 文件上传的两种方式

1. 表单上传，指明 enctype="multipart/form-data"




    <form method="post" action="form" enctype="multipart/form-data">
        <input type="text" name="name"/>
        <input type="file" name="file"/>
        <input type="submit"/>
    </form>
    
    
    
    
2. ajax 文件上传； 需要 dataForm 对象封装。

    
    
    
    //FormData是ajax定义的接口,可以模拟键值对向服务器提交数据
    //FormData类型的作用是可以提交文本数据,还可以提交二进制数据.
    var formData = new FormData();
    formData.append("file", $("#activityFile")[0].files[0]);
    $.ajax({
       url: 'form3',
       data: formData,
       type: 'post',
       processData: false,//主要是配合contentType使用的,默认情况下,ajax把所有数据进行applciation/x-www-form-urlencoded编码之前,会把所有数据统一转化为字符串;把proccessData设置为false,可以阻止这种行为.
       contentType: false,//默认情况下,ajax向服务器发送数据之前,把所有数据统一按照applciation/x-www-form-urlencoded编码格式进行编码;把contentType设置为false,能够阻止这种行为.
       success: function (data) {
           if (data.success) {
               alert("上传成功");
           } else {
               alert("失败")
           }
       }
    })
    
    
    
    
##### 文件下载的三种方式

1.  返回ResponseEntity



    public ResponseEntity<byte[]> download(String fileName, File file) throws IOException {
            String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", dfileName);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
    
    
    
2. os.write(FileUtils.readFileToByteArray(file));



    OutputStream os = res.getOutputStream();
    try {
        res.reset();
        res.setHeader("Content-Disposition", "attachment; filename=" + name);
        res.setContentType("application/octet-stream; charset=utf-8");
    
        String storageDir = getStorageDir(request);
    
        // 本地的一个文件。
        File file = new File(storageDir, name);
        os.write(FileUtils.readFileToByteArray(file));
        os.flush();
    
    } finally {
        if (os != null) {
            os.close();
        }
    }