package com.project.servlet.SpecialistServlet;

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

@WebServlet(name = "GetSpecialistInformationByIdServlet",value = "/servlet/getSpecialistInformation")
public class GetSpecialistInformationByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISpecialistService iSpecialistService=new SpecialistServiceImpl();
        String specialistId=request.getParameter("specialistId");
        try {
            SpecialistBean specialistBean=iSpecialistService.getSpecialistInformationById(Integer.parseInt(specialistId));
            Gson gson=new Gson();
            String json=gson.toJson(specialistBean);
            response.getWriter().print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
