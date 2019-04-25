package com.project.servlet.dataManagement;

import com.project.bean.InsectBean;
import com.project.service.IInsectService;
import com.project.service.impl.InsectServiceImpl;
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

@WebServlet(name = "AddInsectServlet",value = "/sevrlet/insect/add")
public class AddInsectServlet extends HttpServlet {
    private IInsectService insectService=new InsectServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
        ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
        Map<String,String> map = new HashMap<String,String>();
        InsectBean insectBean=new InsectBean();
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
                    if (oldName.equals("childPicture.jpg") && oldName.length() != 0) {
                        insectBean.setChildPicture(newFileName);
                    }
                    if (oldName.equals("insectPicture.jpg") && oldName.length() != 0) {
                        insectBean.setInsectPicture(newFileName);
                    }
                    String savePath="D:\\java_web_project\\webProject\\test\\web\\down.jpg\\"+newFileName;
                    fileItem.write(new File(savePath));
                }
            }
            insectBean.setName(map.get("insectName"));
            insectBean.setHostName(map.get("hostName"));
            insectBean.setBreed(map.get("breed"));
            insectBean.setEnemy(map.get("enemy"));
            insectBean.setControlling(map.get("controlling"));
            insectBean.setDanger(map.get("danger"));
            insectService.addInsect(insectBean);
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
