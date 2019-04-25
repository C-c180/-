package com.project.servlet.SpecialistServlet;

import com.project.service.ISpecialistService;
import com.project.service.impl.SpecialistServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteSpecialistInformationServlet",value = "/servlet/deleteSpecialistInformation")
public class DeleteSpecialistInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISpecialistService iSpecialistService=new SpecialistServiceImpl();
        String specialistId=request.getParameter("specialistId");
        try {
            iSpecialistService.deleteSpecialistInformation(Integer.parseInt(specialistId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().print(1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
