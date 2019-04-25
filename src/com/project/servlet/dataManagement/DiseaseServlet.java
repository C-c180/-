package com.project.servlet.dataManagement;

import com.github.pagehelper.PageInfo;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DiseaseServlet",value = "/servlet/disease/show")
public class DiseaseServlet extends HttpServlet {
    private IDiseaseService iDiseaseService=new DiseaseServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> condition=new HashMap<String,String>();
        condition.put("pageNum", request.getParameter("pageNum"));
        condition.put("pageSize", request.getParameter("pageSize"));
        String diseaseName=request.getParameter("diseaseName");
        String mainDanger=request.getParameter("symptom");
        if (diseaseName != null && diseaseName.length() != 0) {
            condition.put("diseaseName", "'%"+diseaseName+"%'");
        }
        if (mainDanger != null && mainDanger.length() != 0) {
            condition.put("mainDanger", "'%"+mainDanger+"%'");
        }
        PageInfo<DiseaseBean> pageInfo = iDiseaseService.findDiseaseByCondition(condition);
        response.getWriter().print(new Gson().toJson(pageInfo));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
