package com.project.servlet.diseasterPreventServlet;

import com.google.gson.Gson;
import com.project.bean.EventBean;
import com.project.service.IEventService;
import com.project.service.impl.EventServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "showEventInfoServlet",value = "/servlet/showEventInfo")
public class showEventInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IEventService iEventService = new EventServiceImpl();
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        EventBean eventBean = iEventService.showEventInfo(eventId);
        Gson gson = new Gson();
        String json =gson.toJson(eventBean);
        response.getWriter().print(json);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
