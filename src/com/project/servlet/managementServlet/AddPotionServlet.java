package com.project.servlet.managementServlet;

import com.project.bean.PotionManagementBean;
import com.project.service.IPotionManagementService;
import com.project.service.impl.PotionManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddPotionServlet",value = "/servlet/addPotion")
public class AddPotionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IPotionManagementService iPotionManagementService = new PotionManagementServiceImpl();
        String potionName = request.getParameter("potionName");
        String preventCureTypeId = request.getParameter("preventCureTypeId");
        String diseasesAndPestsName = request.getParameter("diseasesAndPestsName");
        String treeSpecies = request.getParameter("treeSpecies");
        PotionManagementBean potionManagementBean = new PotionManagementBean();
        potionManagementBean.setPotionName(potionName);
        if(preventCureTypeId.equals("1")){
            potionManagementBean.setPreventCureTypeId(1);
        }
        if(preventCureTypeId.equals("2")){
            potionManagementBean.setPreventCureTypeId(2);
        }
        if(preventCureTypeId.equals("3")){
            potionManagementBean.setPreventCureTypeId(3);
        }
        potionManagementBean.setDiseasesAndPestsName(diseasesAndPestsName);
        potionManagementBean.setTreeSpecies(treeSpecies);
        iPotionManagementService.addPotion(potionManagementBean);
        response.getWriter().print(1);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
