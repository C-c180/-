package com.project.servlet.dataManagement;

import com.project.bean.MouseBean;
import com.project.service.IMouseService;
import com.project.service.impl.MouseServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "AddMouseServlet",value = "/mouse/add")
public class AddMouseServlet extends HttpServlet {
    private IMouseService iMouseService=new MouseServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
        ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
        Map<String,String> map = new HashMap<String,String>();
        MouseBean mouseBean=new MouseBean();
        try {
            List<FileItem> list = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : list) {
                if (fileItem.isFormField()) {
                    map.put(fileItem.getFieldName(),new String(fileItem.getString().getBytes("iso8859-1"),"utf-8"));
                    System.out.println(fileItem.getFieldName()+"        "+fileItem.getString());
                }else{
                    String oldName = fileItem.getName();
                    System.out.println(oldName);
                    String ext = oldName.substring(oldName.lastIndexOf("."));
                    Thread.sleep(1000);
                    String newFileName = UUID.randomUUID() + ext;
                    mouseBean.setPicture(newFileName);
                    String savePath="D:\\java_web_project\\webProject\\test\\web\\down.jpg\\"+newFileName;
                    fileItem.write(new File(savePath));
                }
            }
            mouseBean.setName(map.get("mouseName"));
            mouseBean.setFood(map.get("food"));
            mouseBean.setBreed(map.get("breed"));
            mouseBean.setEnemy(map.get("enemy"));
            mouseBean.setMeasure(map.get("measure"));
            mouseBean.setMainDanger(map.get("mainDanger"));
            iMouseService.addMouse(mouseBean);
            response.getWriter().print("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
