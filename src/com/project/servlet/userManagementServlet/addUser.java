package com.project.servlet.userManagementServlet;

import com.project.bean.UserBean;
import com.project.service.IUserService;
import com.project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addUser",value = "/servlet/addUser")
public class addUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName=req.getParameter("userName");
        String pwd=req.getParameter("pwd");
        String realName=req.getParameter("realName");
        String userScaleId=req.getParameter("userScaleId");
        UserBean user=new UserBean();
        user.setUserName(userName);
        user.setRealName(realName);
        user.setPwd(pwd);
        user.setUserScaleId(Integer.parseInt(userScaleId));
        IUserService userService=new UserServiceImpl();
        try {
            userService.addUser(user);
            resp.getWriter().print("1");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
