package com.ljs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * create by ljs on 2020/7/3 17:33
 * description: 接收上传文件
 *
 *
 * request.getContextPath()
 * request.getServletContext().getRealPath("/")// 编译目录
 *
 * request.getServletPath() // 请求相对路径
 *
 *
 *   BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
 *   BufferedReader reader = new BufferedReader(new InputStreamReader(bufferedInputStream));
 *
 *
 *  列举接收文件 保存到本地的三种方式。
 *
 *
 */

@Controller
public class UploadFileController {



    // 获取文件保存在服务器的文件名，  [随机数+.pdf]
    private String getNewFileName(String originalFilename) {
        String subfix = originalFilename.substring(originalFilename.lastIndexOf('.') + 1);
        // 自定义一个文件名
        String filename = UUID.randomUUID().toString().replace("-", "");
        filename += "." + subfix;
        return filename;
    }

    // 获取保存文件的file 对象
    private File getStoragePathToFile(HttpServletRequest request, String filename) {
        // 服务器保存文件的路径
        String uploadPath = request.getServletContext().getRealPath("/upload");
        // 文件保存绝对路径
        String filePath = uploadPath + "/" + filename;
        File f = new File(filePath);
        if ( ! f.getParentFile().exists() ) {
            f.getParentFile().mkdirs();
        }
        return f;
    }


    /**
     *  file multipartFile 转成 file.getBytes() 转成字节数组输出。  】
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String handleFormUpload(MultipartFile file, HttpServletRequest request) {

        try {

            String filename = getNewFileName(file.getOriginalFilename());
            File f = getStoragePathToFile(request, filename);
            byte[] bytes = file.getBytes();   // 转换成字节数组
            FileOutputStream outputStream = new FileOutputStream(f);
            outputStream.write(bytes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/fail.jsp";
        }
        return "redirect:/success.jsp";
    }

    /**
     *   通过 file.getInputStream() ---》 FileOutputStream 保存文件
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(path = "/form1", method = RequestMethod.POST)
    public String handleFormUpload1(MultipartFile file, HttpServletRequest request) {

        try {

            String filename = getNewFileName(file.getOriginalFilename());
            File f = getStoragePathToFile(request, filename);
            InputStream inputStream = file.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(f);
            byte bytes[] = new byte[1024];
            int i = 0;
            while ( (i = inputStream.read(bytes)) != -1 ) {
                outputStream.write(bytes, 0, i);
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/fail.jsp";
        }
        return "redirect:/success.jsp";
    }

    /**
     *    使用file.transferTo(File) 保存文件到本地。
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(path = "/form2", method = RequestMethod.POST)
    public String handleFormUpload2(MultipartFile file, HttpServletRequest request) {

        try {
            String filename = getNewFileName(file.getOriginalFilename());
            File f = getStoragePathToFile(request, filename);
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/fail.jsp";
        }
        return "redirect:/success.jsp";
    }


    @RequestMapping(path = "/form3", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> handleFormUpload3(MultipartFile file, HttpServletRequest request) {

        HashMap<String, Object> map = new HashMap<>();
        try {
            String filename = getNewFileName(file.getOriginalFilename());
            File f = getStoragePathToFile(request, filename);
            file.transferTo(f);
            map.put("success", true);
        } catch (IOException e) {
            e.printStackTrace();
            map.put("success", false);
            return map;
        }
        return map;
    }






}