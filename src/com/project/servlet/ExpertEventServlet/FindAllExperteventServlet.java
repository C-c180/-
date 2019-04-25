package com.project.servlet.ExpertEventServlet;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.EventBean;
import com.project.bean.ExpertEventBean;
import com.project.service.IExpertEventService;
import com.project.service.impl.ExpertEventServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FindAllExperteventServlet",value = "/servlet/findAllExpertevent")
public class FindAllExperteventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IExpertEventService iExpertEventService=new ExpertEventServiceImpl();
         String currentPage=request.getParameter("currentPage");
         String pageSize=request.getParameter("pageSize");
         String type=request.getParameter("type");
         String value=request.getParameter("value");
         Map<String,String>map=new HashMap<>();
         map.put("currentPage",currentPage);
         map.put("pageSize",pageSize);
         map.put("type","灾情状态");
         map.put("value","无法解决,申请专家会商");
        PageInfo<EventBean>pageInfo=iExpertEventService.findAllExperteventBean(map);
        Gson gson=new Gson();
        String json=gson.toJson(pageInfo);
        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
