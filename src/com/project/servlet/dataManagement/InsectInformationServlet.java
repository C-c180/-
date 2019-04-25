package com.project.servlet.dataManagement;

import com.google.gson.Gson;
import com.project.bean.InsectBean;
import com.project.service.IInsectService;
import com.project.service.impl.InsectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsectInformationServlet",value = "/servlet/insect/information")
public class InsectInformationServlet extends HttpServlet {
    private IInsectService insectService=new InsectServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        InsectBean insectBean = insectService.findInsectById(Integer.parseInt(id));
        response.getWriter().print(new Gson().toJson(insectBean));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
