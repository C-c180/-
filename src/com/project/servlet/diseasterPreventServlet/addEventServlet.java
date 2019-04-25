package com.project.servlet.diseasterPreventServlet;

import com.project.bean.EventBean;
import com.project.service.IAreaService;
import com.project.service.IEventService;
import com.project.service.impl.AreaServiceImpl;
import com.project.service.impl.EventServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
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

@WebServlet(name = "addEventServlet",value = "/servlet/addEvent")
public class addEventServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
        ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
        Map<String,String> map = new HashMap<String,String>();
        EventBean eventBean = new EventBean();

        try {
            List<FileItem> list = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : list) {
                if (fileItem.isFormField()) {
                    map.put(fileItem.getFieldName(),new String(fileItem.getString().getBytes("iso8859-1"),"utf-8"));
                }else{
                    String oldName = fileItem.getName();
                    System.out.println(oldName);
                    String ext = oldName.substring(oldName.lastIndexOf("."));

                    Thread.sleep(1000);
                    String newFileName = UUID.randomUUID() + ext;
                    if (oldName.equals("eventImage.jpg") && oldName.length() != 0) {
                        eventBean.setImagePath(newFileName);
                    }
                    String savePath="D:\\java_web_project\\webProject\\test\\web\\down.jpg\\"+newFileName;
                    fileItem.write(new File(savePath));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        IEventService iEventService = new EventServiceImpl();
        IAreaService iAreaService=new AreaServiceImpl();
        eventBean.setEventName(map.get("eventName"));
        eventBean.setDateTimes(map.get("dateTimes"));
        eventBean.setDisasterStage(map.get("disasterStage"));
        eventBean.setDisasterDesc(map.get("disasterDesc"));
        eventBean.setLoss(Double.parseDouble(map.get("loss")));
        eventBean.setPreventPlan(map.get("PreventPlan"));
        eventBean.setDisastersType(map.get("disastersType"));
        eventBean.setFoundWay(map.get("FoundWay"));
        eventBean.setAreaOfInfluence(Double.parseDouble(map.get("AreaOfInfluence")));
        eventBean.setHappenPlace(iAreaService.findAreaById(Integer.parseInt(map.get("areaId"))));
        int result = iEventService.addEvent(eventBean);
        if(result==1){
            response.getWriter().print("1");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
