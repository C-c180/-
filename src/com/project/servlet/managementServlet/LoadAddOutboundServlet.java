package com.project.servlet.managementServlet;

import com.google.gson.Gson;
import com.project.bean.ClassBean;
import com.project.bean.OutboundManagementBean;
import com.project.service.IOutboundManagementService;
import com.project.service.impl.OutboundManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadAddOutboundServlet",value = "/servlet/loadAddOutbound")
public class LoadAddOutboundServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IOutboundManagementService iOutboundManagementService = new OutboundManagementServiceImpl();
        List<ClassBean> list = iOutboundManagementService.findAllOutbound();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        response.getWriter().print(json);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
