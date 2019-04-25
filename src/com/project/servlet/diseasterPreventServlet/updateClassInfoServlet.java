package com.project.servlet.diseasterPreventServlet;

import com.project.bean.ClassBean;
import com.project.service.IClassService;
import com.project.service.impl.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateClassInfoServlet",value = "/servlet/updateClassInfo")
public class updateClassInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IClassService iClassService = new ClassServiceImpl();
        int classId = Integer.parseInt(request.getParameter("classId"));
        ClassBean classBean = iClassService.showClassInfoById(classId);
        String principal = request.getParameter("principal");
        String principalTel = request.getParameter("principalTel");
        classBean.setPrincipal(principal);
        classBean.setPrincipalTel(principalTel);
        int result = iClassService.updateClassInfo(classBean);
        if(result==1){
            response.getWriter().print("1");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
