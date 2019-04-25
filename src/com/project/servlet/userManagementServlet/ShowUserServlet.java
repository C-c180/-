package com.project.servlet.userManagementServlet;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.project.bean.UserBean;
import com.project.service.IUserService;
import com.project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name ="ShowUserServlet",value ="/servlet/showUser" )
public class ShowUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage=req.getParameter("currentPage");
        String pageSize=req.getParameter("pageSize");
        String userScaleId = req.getParameter("userScaleId");
        IUserService userService=new UserServiceImpl();
        Map<String,String> condition=new HashMap<String,String>();
        if (userScaleId != null && userScaleId.length() != 0) {
            condition.put("userScaleId", userScaleId);
        }
        condition.put("currentPage",currentPage);
        condition.put("pageSize",pageSize);
        try {
            PageInfo<UserBean> page=userService.findByCondition(condition);
            Gson gson=new Gson();
            String json=gson.toJson(page);
            resp.getWriter().print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
