package com.project.servlet.dataManagement;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.InsectBean;
import com.project.service.IInsectService;
import com.project.service.impl.InsectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ShowServlet",value = "/servlet/insect/show")
public class ShowServlet extends HttpServlet {
    private IInsectService insectService=new InsectServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("成功访问");
        Map<String,String> condition=new HashMap<String,String>();
        System.out.println(request.getParameter("pageNum"));
        System.out.println(request.getParameter("pageSize"));
        System.out.println(request.getParameter("insectName"));
        System.out.println(request.getParameter("hostName"));
        condition.put("pageNum", request.getParameter("pageNum"));
        condition.put("pageSize", request.getParameter("pageSize"));
        String insectName=request.getParameter("insectName");
        String hostName=request.getParameter("hostName");
        if (insectName != null && insectName.length() != 0) {
            condition.put("insectName", "'"+insectName+"'");
        }
        if (hostName != null && hostName.length() != 0) {
            condition.put("hostName", "'"+hostName+"'");
        }
        PageInfo<InsectBean> pageInfo = insectService.findInsectByCondition(condition);
        response.getWriter().print(new Gson().toJson(pageInfo));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
