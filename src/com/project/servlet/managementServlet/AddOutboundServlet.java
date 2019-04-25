package com.project.servlet.managementServlet;

import com.project.bean.OutboundManagementBean;
import com.project.service.IOutboundManagementService;
import com.project.service.impl.OutboundManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddOutboundServlet",value = "/servlet/addOutbound")
public class AddOutboundServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IOutboundManagementService iOutboundManagementService = new OutboundManagementServiceImpl();
        String outboundTypeId = request.getParameter("outboundTypeId");
        String preventCureTypeId = request.getParameter("preventCureTypeId");
        String itemName = request.getParameter("itemName");
        String recipientsNum = request.getParameter("recipientsNum");
        String classId = request.getParameter("classId");
        String mainUse = request.getParameter("mainUse");
        OutboundManagementBean outboundManagementBean =new OutboundManagementBean();
        outboundManagementBean.setOutboundTypeId(Integer.parseInt(outboundTypeId));
        outboundManagementBean.setPreventCureTypeId(Integer.parseInt(preventCureTypeId));
        outboundManagementBean.setItemName(itemName);
        outboundManagementBean.setRecipientsNum(Integer.parseInt(recipientsNum));
        outboundManagementBean.setClassId(Integer.parseInt(classId));
        outboundManagementBean.setMainUse(mainUse);
        iOutboundManagementService.addOutboundInformation(outboundManagementBean);
        response.getWriter().print(1);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
