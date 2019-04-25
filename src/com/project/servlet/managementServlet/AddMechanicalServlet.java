package com.project.servlet.managementServlet;

import com.project.bean.MechanicalManagementBean;
import com.project.service.IMechanicalManagementService;
import com.project.service.impl.MechanicalManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddMechanicalServlet",value = "/servlet/addMechanical")
public class AddMechanicalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IMechanicalManagementService iMechanicalManagementService = new MechanicalManagementServiceImpl();
        String mechanicalName = request.getParameter("mechanicalName");
        String preventCureTypeId = request.getParameter("preventCureTypeId");
        String mainUse = request.getParameter("mainUse");
        MechanicalManagementBean mechanicalManagementBean = new MechanicalManagementBean();
        mechanicalManagementBean.setMechanicalName(mechanicalName);
        if(preventCureTypeId.equals("1")){
            mechanicalManagementBean.setPreventCureTypeId(1);
        }
        if(preventCureTypeId.equals("2")){
            mechanicalManagementBean.setPreventCureTypeId(2);
        }
        if(preventCureTypeId.equals("3")){
            mechanicalManagementBean.setPreventCureTypeId(3);
        }
        mechanicalManagementBean.setMainUse(mainUse);
        iMechanicalManagementService.addMechanical(mechanicalManagementBean);
        response.getWriter().print(1);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
