package com.project.servlet.diseasterPreventServlet;

import com.project.bean.AreaBean;
import com.project.service.IAreaService;
import com.project.service.impl.AreaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addAreaServlet",value = "/servlet/addArea")
public class addAreaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IAreaService iAreaService = new AreaServiceImpl();
        String areaName = request.getParameter("areaName");
        String forestType = request.getParameter("forestType");
        String landType = request.getParameter("landType");
        String dominantTree = request.getParameter("dominantTree");
        AreaBean areaBean = new AreaBean(areaName,forestType,landType,dominantTree);
        int result =  iAreaService.addArea(areaBean);
        if(result==1){
            response.getWriter().print("1");
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
