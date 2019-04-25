package com.project.servlet.dataManagement;

import com.project.bean.DiseaseBean;
import com.project.service.IDiseaseService;
import com.project.service.impl.DiseaseServiceImpl;
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

@WebServlet(name = "AddDiseaseServlet",value = "/servlet/disease/add")
public class AddDiseaseServlet extends HttpServlet {
    private IDiseaseService iDiseaseService=new DiseaseServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
        ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
        Map<String,String> map = new HashMap<String,String>();
        DiseaseBean diseaseBean=new DiseaseBean();

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
                    diseaseBean.setPicture(newFileName);
                    String savePath="D:\\java_web_project\\webProject\\test\\web\\down.jpg\\"+newFileName;
                    fileItem.write(new File(savePath));
                }
            }
            diseaseBean.setName(map.get("diseaseName"));
            diseaseBean.setPathogeny(map.get("pathogeny"));
            diseaseBean.setSymptom(map.get("symptom"));
            diseaseBean.setRule(map.get("rule"));
            diseaseBean.setMainDanger(map.get("mainDanger"));
            diseaseBean.setMeasure(map.get("measure"));
            iDiseaseService.addDiease(diseaseBean);
            response.getWriter().print("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
