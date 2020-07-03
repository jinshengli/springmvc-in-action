package com.ljs.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * create by ljs on 2020/7/3 20:23
 * description: 下载文件的controller
 *
 *   演示文件下载的三种方式。  || 去掉了各种异常判断。
 *
 *   分两大类：
 *
 *  1   out = httpServletResponse.getOutputStream()
 *      out.write(字节数组)
 *  2. 返回 ResponseEntity<byte[]> 对象。
 *
 */


@Controller
public class DownloadFileController {


    // 获取保存文件的目录
    private String getStorageDir(HttpServletRequest request) {
        // 服务器保存文件的路径
        String uploadPath = request.getServletContext().getRealPath("/upload");
        File f = new File(uploadPath);

        if ( ! f.getParentFile().exists() ) {
            f.getParentFile().mkdirs();
        }

        return uploadPath;
    }

    /**
     *  列出服务器 某目录下的文件。
     * @param request
     * @return
     */
    @RequestMapping("/files")
    public ModelAndView getFileList(HttpServletRequest request) {

        File file = new File(getStorageDir(request));
        // file 是目录
        String[] list = file.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("/files.jsp");
        return modelAndView;

    }


    /**
     *  下载文件
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> downloadFile(String file, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String storageDir = getStorageDir(request);

        // 定位到需要下载的文件。
        File file1 = new File(storageDir,file);

        return download(file, file1);

    }


    @RequestMapping("/download1")
    public void download(HttpServletRequest request, HttpServletResponse res, @RequestParam("file") String name) throws IOException {
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
    }


    @RequestMapping("/download2")
    public void download2(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") String name) throws IOException {

        response.setContentType("octets/stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + name);
        OutputStream out = response.getOutputStream();
        InputStream inputStream = new FileInputStream(new File(getStorageDir(request), name));
        int i = 0;
        byte bytes[] = new byte[1024];
        while ((i = inputStream.read(bytes)) != -1) {
            out.write(bytes,0,i);
        }

        out.flush();
        out.close();

    }



    public ResponseEntity<byte[]> download(String fileName, File file) throws IOException {
        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }



    /**
     *
     *
     *
     *    response.setContentType("octets/stream");
     *         response.setHeader("Content-Disposition","attachment;filename="+ file);
     *
     *         OutputStream out = response.getOutputStream();
     *
     *         InputStream inputStream = new FileInputStream(file1);
     *
     *         int i = 0;
     *
     *         byte bytes[] = new byte[1024];
     *
     *         while ( (i=inputStream.read(bytes)) != -1 ) {
     *             out.write(bytes,0,i);
     *         }
     *
     *         out.flush();
     */




}
