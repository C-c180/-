package com.project.servlet.managementServlet;

import com.google.gson.Gson;
import com.project.bean.CountOutboundBean;
import com.project.service.IOutboundManagementService;
import com.project.service.impl.OutboundManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OutboundReportServlet",value = "/servlet/OutboundReport")
public class OutboundReportServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IOutboundManagementService iOutboundManagementService = new OutboundManagementServiceImpl();
        List<CountOutboundBean> list=iOutboundManagementService.obtainReportShowData();
        Gson gson=new Gson();
        String s = gson.toJson(list);
        response.getWriter().print(s);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
