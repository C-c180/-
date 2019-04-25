package com.project.servlet.dataManagement;

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

@WebServlet(name = "MouseInformatinServlet",value = "/servlet/mouse/information")
public class MouseInformatinServlet extends HttpServlet {
    private IMouseService iMouseService=new MouseServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MouseBean mouseBean = iMouseService.findById(Integer.parseInt(id));
        response.getWriter().print(new Gson().toJson(mouseBean));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
