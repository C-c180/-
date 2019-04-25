package com.project.servlet.diseasterPreventServlet;

import com.google.gson.Gson;
import com.project.bean.AreaBean;
import com.project.service.IAreaService;
import com.project.service.impl.AreaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadAddEventServlet",value = "/servlet/LoadEventEvent")
public class LoadAddEventServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IAreaService iAreaService = new AreaServiceImpl();
        int areaId = Integer.parseInt(request.getParameter("areaId"));
        AreaBean areaBean = iAreaService.findAreaById(areaId);
        Gson gson = new Gson();
        String json = gson.toJson(areaBean);
        response.getWriter().print(json);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
