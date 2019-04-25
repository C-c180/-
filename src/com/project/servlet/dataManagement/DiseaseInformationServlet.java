package com.project.servlet.dataManagement;

import com.google.gson.Gson;
import com.project.bean.DiseaseBean;
import com.project.service.IDiseaseService;
import com.project.service.impl.DiseaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiseaseInformationServlet",value = "/servlet/disease/information")
public class DiseaseInformationServlet extends HttpServlet {
    private IDiseaseService iDiseaseService=new DiseaseServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DiseaseBean diseaseBean = iDiseaseService.findById(Integer.parseInt(id));
        response.getWriter().print(new Gson().toJson(diseaseBean));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
