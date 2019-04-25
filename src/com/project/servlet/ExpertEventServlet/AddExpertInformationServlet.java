package com.project.servlet.ExpertEventServlet;

import com.google.gson.Gson;
import com.project.bean.EventBean;
import com.project.bean.ExpertEventBean;
import com.project.service.IEventService;
import com.project.service.IExpertEventService;
import com.project.service.impl.EventServiceImpl;
import com.project.service.impl.ExpertEventServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddExpertInformationServlet",value = "/servlet/addExpertInformation")
public class AddExpertInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staff=request.getParameter("staff");
        String result=request.getParameter("result");
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        IExpertEventService iExpertEventService=new ExpertEventServiceImpl();
        IEventService iEventService = new EventServiceImpl();
        ExpertEventBean expertEventBean=new ExpertEventBean();
        expertEventBean.setResult(result);
        expertEventBean.setStaff(staff);
        expertEventBean.setEventId(eventId);
        EventBean eventBean = new EventBean();
        try {
            if(staff!=null&&staff.length()!=0){
                iExpertEventService.addExpertInformation(expertEventBean);
            }
             eventBean = iEventService.showEventInfo(eventId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String json = gson.toJson(eventBean);
        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
