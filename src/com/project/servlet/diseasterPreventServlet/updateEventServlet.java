package com.project.servlet.diseasterPreventServlet;

import com.project.bean.EventBean;
import com.project.service.IEventService;
import com.project.service.impl.EventServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateEventServlet",value = "/servlet/updateEvent")
public class updateEventServlet extends HttpServlet {
    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        IEventService iEventService = new EventServiceImpl();
        EventBean eventBean = iEventService.showEventInfo(eventId);
        String disasterStage = request.getParameter("disasterStage");
        String PreventPlan = request.getParameter("PreventPlan");
        if(!eventBean.getDisasterStage().equals("已经得到控制")){
            eventBean.setDisasterStage(disasterStage);
        }
        if(PreventPlan!=null){
            eventBean.setPreventPlan(PreventPlan);
        }
        int result = iEventService.updateEventInfo(eventBean);
        if(result==1){
            response.getWriter().print(1);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
