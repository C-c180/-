package com.project.servlet.dataManagement;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.MouseBean;
import com.project.service.IMouseService;
import com.project.service.impl.MouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "MouseShowServlet",value = "/servlet/mouse/show")
public class MouseShowServlet extends HttpServlet {
    private IMouseService iMouseService=new MouseServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("成功访问");
        Map<String,String> condition=new HashMap<String,String>();
        System.out.println(request.getParameter("pageNum"));
        System.out.println(request.getParameter("pageSize"));
        System.out.println(request.getParameter("mouseName"));
        condition.put("pageNum", request.getParameter("pageNum"));
        condition.put("pageSize", request.getParameter("pageSize"));
        String mouseName=request.getParameter("mouseName");
        if (mouseName != null && mouseName.length() != 0) {
            condition.put("name", "'%"+mouseName+"%'");
        }
        PageInfo<MouseBean> pageInfo = iMouseService.findMouseByCondition(condition);
        response.getWriter().print(new Gson().toJson(pageInfo));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
