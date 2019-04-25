package com.project.servlet.diseasterPreventServlet;

import com.project.bean.AreaBean;
import com.project.bean.ClassBean;
import com.project.service.IAreaService;
import com.project.service.IClassService;
import com.project.service.impl.AreaServiceImpl;
import com.project.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addClassServlet",value = "/servlet/addClass")
public class addClassServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IClassService iClassService = new ClassServiceImpl();
        IAreaService iAreaService = new AreaServiceImpl();
        String className = request.getParameter("clazzName");
        String principal = request.getParameter("principal");
        String principalTel = request.getParameter("principalTel");
        int personNum = Integer.parseInt(request.getParameter("personNum"));
        int areaId = Integer.parseInt(request.getParameter("chargeOfArea"));
        AreaBean areaBean = iAreaService.findAreaById(areaId);
        ClassBean classBean = new ClassBean(className,personNum,principal,principalTel,areaBean);
        int result = iClassService.addClass(classBean);
        if(result==1){
            response.sendRedirect("../disasterPrevent/pages/class.html");
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
