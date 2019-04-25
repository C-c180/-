package com.project.servlet.userManagementServlet;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.LogBean;
import com.project.service.ILogService;
import com.project.service.impl.LogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ShowLogServlet",value = "/servlet/ShowLog")
public class ShowLogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ILogService logService=new LogServiceImpl();
        String currentPage=req.getParameter("currentPage");
        String pageSize=req.getParameter("pageSize");
        String startDate=req.getParameter("startDate");
        String endDate=req.getParameter("endDate");
        Map<String,String> condition=new HashMap<String,String>();
        if (startDate != null && startDate.length() != 0) {
            condition.put("startDate",startDate);
        }
        if (endDate != null && endDate.length() != 0) {
            condition.put("endDate",endDate);
        }
        condition.put("currentPage",currentPage);
        condition.put("pageSize",pageSize);
        PageInfo<LogBean> page=logService.findByCondition(condition);
        System.out.println(page);
        Gson gson=new Gson();
        String json=gson.toJson(page);
        resp.getWriter().print(json);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
