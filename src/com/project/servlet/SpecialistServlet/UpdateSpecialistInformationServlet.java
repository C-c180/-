package com.project.servlet.SpecialistServlet;

import com.project.bean.SpecialistBean;
import com.project.service.ISpecialistService;
import com.project.service.impl.SpecialistServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateSpecialistInformationServlet",value = "/servlet/updateSpecialistInformation")
public class UpdateSpecialistInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ISpecialistService iSpecialistService=new SpecialistServiceImpl();
        String specialistId=request.getParameter("specialistId");
        String telphone=request.getParameter("telphone");
        String duty=request.getParameter("duty");
        String workunit=request.getParameter("workunit");
        String mailbox=request.getParameter("email");
        try {
            SpecialistBean specialistBean=iSpecialistService.getSpecialistInformationById(Integer.parseInt(specialistId));
            specialistBean.setEmail(mailbox);
            specialistBean.setWorkunit(workunit);
            specialistBean.setDuty(duty);
            specialistBean.setTelphone(telphone);
            iSpecialistService.updateSpecialistInformation(specialistBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().print("1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
