package com.project.servlet.ExpertEventServlet;

import com.google.gson.Gson;
import com.project.bean.EventBean;
import com.project.bean.ExpertEventBean;
import com.project.dao.IEventDao;
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

@WebServlet(name = "SearchExpertInfoServlet",value = "/servlet/searchExpertInfo")
public class SearchExpertInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             int eventId=Integer.parseInt(request.getParameter("id"));
        IEventService iEventService=new EventServiceImpl();

        try {
            EventBean eventBean=iEventService.showEventInfo(eventId);
            Gson gson=new Gson();
            String json=gson.toJson(eventBean);
            response.getWriter().print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
