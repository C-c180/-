package com.project.servlet.managementServlet;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.OutboundManagementBean;
import com.project.service.IOutboundManagementService;
import com.project.service.impl.OutboundManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ShowOutboundServlet",value = "/servlet/showOutbound")
public class ShowOutboundServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IOutboundManagementService iOutboundManagementService = new OutboundManagementServiceImpl();
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        Map<String,String> condition = new HashMap<String, String>();
        condition.put("currentPage",currentPage);
        condition.put("pageSize",pageSize);
        if(startDate!=null&&startDate.length()!=0){
            condition.put("startDate",startDate);
        }
        if(endDate!=null&&endDate.length()!=0){
            condition.put("endDate", endDate);
        }
        PageInfo<OutboundManagementBean> page = iOutboundManagementService.showOutboundInfo(condition);
        Gson gson = new Gson();
        String json = gson.toJson(page);
        response.getWriter().print(json);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
