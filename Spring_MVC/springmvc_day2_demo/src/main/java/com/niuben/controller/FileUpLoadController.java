package com.niuben.controller;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileUpLoadController {

    /**
     * 文件上传
     * @return
     */
    @RequestMapping("upload1")
    public String File1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");
        //使用fileupload组件完成文件上传
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(realPath);
        //判断路径是否合法
        File file = new File(realPath);
        if (!file.exists()) {
            //创建文件夹
            file.mkdir();
        }
        //解析获取文件
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = upload.parseRequest(request);
        for (FileItem fileItem : fileItems) {
            //判断是否使文件 true使不同文件  false说明是上传文件
            if (!fileItem.isFormField()) {
                //获取名称
                String name = fileItem.getName();
                //完成上传
                fileItem.write(new File(realPath,name));
                //删除临时文件
                fileItem.delete();
            }
        }
        return "success";
    }
    @RequestMapping("upload2")//MultipartFile 参数名必须与表单长传name相同才能接收
    public String File2(HttpServletRequest request, MultipartFile  upload) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/upload2");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String name = upload.getName();
        upload.transferTo(new File(realPath, name));
        return "success";
    }

    /**
     * 跨服务器文件上传
     * @param upload
     * @return
     * @throws IOException
     */
//    @RequestMapping("upload3")//MultipartFile 参数名必须与表单长传name相同才能接收
//    public String File3(MultipartFile  upload) throws IOException {
//        //定义服务器路径
//        String path = "http://localhost:8090/fileload/";
//        //导入jersey包
//        //创建客户端对象
//        Client client = Client.create();
//        //连接得到web支援
//        WebResource resource = client.resource(path + upload.getName());
//         //resource需要字节文件所有getBytes
//        resource.put(upload.getBytes());
//        return "success";
//    }

}
