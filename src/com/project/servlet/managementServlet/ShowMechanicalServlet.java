package com.project.servlet.managementServlet;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.MechanicalManagementBean;
import com.project.service.IMechanicalManagementService;
import com.project.service.impl.MechanicalManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ShowMechanicalServlet",value = "/servlet/showMechanical")
public class ShowMechanicalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IMechanicalManagementService iMechanicalManagementService = new MechanicalManagementServiceImpl();
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String name = request.getParameter("mechanicalName").trim();
        String type = request.getParameter("preventCureName").trim();
        Map<String,String> condition = new HashMap<String, String>();
        condition.put("currentPage",currentPage);
        condition.put("pageSize",pageSize);
        if (name != null && name.length() != 0) {
            condition.put("name", name);
        }
        if (type != null && type.length() != 0) {
            if(type.equals("1")){
                condition.put("type", "1");
            }
            if(type.equals("2")){
                condition.put("type", "2");
            }
            if(type.equals("3")){
                condition.put("type", "3");
            }
        }
        PageInfo<MechanicalManagementBean> page = iMechanicalManagementService.showMechanicalInfo(condition);
        Gson gson = new Gson();
        String json = gson.toJson(page);
        response.getWriter().print(json);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
