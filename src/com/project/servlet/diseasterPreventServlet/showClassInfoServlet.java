package com.project.servlet.diseasterPreventServlet;

import com.google.gson.Gson;
import com.project.bean.ClassBean;
import com.project.service.IClassService;
import com.project.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "showClassInfoServlet",value = "/servlet/showClassInfo")
public class showClassInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int classId = Integer.parseInt(request.getParameter("classId"));
        IClassService iClassService = new ClassServiceImpl();
        ClassBean classBean = iClassService.showClassInfoById(classId);
        System.out.println(classBean);
        Gson gson = new Gson();
        String json = gson.toJson(classBean);
        response.getWriter().print(json);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
