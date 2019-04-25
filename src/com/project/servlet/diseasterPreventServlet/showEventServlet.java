package com.project.servlet.diseasterPreventServlet;

import com.github.pagehelper.PageInfo;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "showEventServlet",value = "/servlet/showEvent")
public class showEventServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IEventService iEventService = new EventServiceImpl();
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String type = request.getParameter("type");
        String value = request.getParameter("value");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        Map<String,String> condition = new HashMap<String, String>();
        condition.put("currentPage",currentPage);
        condition.put("pageSize",pageSize);
        condition.put("type",type);
        condition.put("value",value);
        condition.put("startDate",startDate);
        condition.put("endDate", endDate);
        PageInfo<EventBean> page = iEventService.findEventByCondition(condition);
        Gson gson = new Gson();
        String json = gson.toJson(page);
        System.out.println(json);
        response.getWriter().print(json);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
