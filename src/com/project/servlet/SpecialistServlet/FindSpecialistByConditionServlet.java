package com.project.servlet.SpecialistServlet;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.SpecialistBean;
import com.project.service.ISpecialistService;
import com.project.service.impl.SpecialistServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FindSpecialistByConditionServlet",value ="/servlet/findSpecialistByCondition" )
public class FindSpecialistByConditionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISpecialistService iSpecialistService=new SpecialistServiceImpl();
        String currentPage=request.getParameter("currentPage");
        String pageSize=request.getParameter("pageSize");
        String specialistName=request.getParameter("specialistName");
        String speciality=request.getParameter("speciality");
        String workunit=request.getParameter("workunit");
        Map<String,String> condition=new HashMap<>();
        condition.put("currentPage",currentPage);
        condition.put("pageSize",pageSize);
        condition.put("specialistName",specialistName);
        condition.put("speciality",speciality);
        condition.put("workunit",workunit);
        try {
            PageInfo<SpecialistBean> pageInfo=iSpecialistService.findSpecialistByCondition(condition);
            Gson gson=new Gson();
            String json=gson.toJson(pageInfo);
            response.getWriter().print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
