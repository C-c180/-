package com.project.servlet.SpecialistServlet;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.DiseaseBean;
import com.project.bean.SpecialistBean;
import com.project.service.ISpecialistService;
import com.project.service.impl.SpecialistServiceImpl;
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

@WebServlet(name = "AddSpecialistInformationServlet",value = "/servlet/addSpecialistInformation")
public class AddSpecialistInformationServlet extends HttpServlet {
    private ISpecialistService iSpecialistService=new SpecialistServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
        ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
        Map<String,String> map = new HashMap<String,String>();
        SpecialistBean specialistBean=new SpecialistBean();

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
                    specialistBean.setPicture(newFileName);
                    String savePath="D:\\java_web_project\\webProject\\test\\web\\down.jpg\\"+newFileName;
                    fileItem.write(new File(savePath));
                }
            }
            specialistBean.setSpecialistName(map.get("specialistName"));
            specialistBean.setTelphone(map.get("telphone"));
            specialistBean.setDuty(map.get("duty"));
            specialistBean.setWorkunit(map.get("workunit"));
            specialistBean.setEmail(map.get("email"));
            specialistBean.setAddress(map.get("address"));
            specialistBean.setBirthday(map.get("birthday"));
            specialistBean.setSex(map.get("sex"));
            specialistBean.setSpeciality(map.get("speciality"));
            iSpecialistService.addSpecialistInformation(specialistBean);
            response.getWriter().print("1");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
