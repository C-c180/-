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

@WebServlet(name = "UpdateUserServlet",value = "/servlet/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        String pwd=req.getParameter("pwds");
        String userScaleId=req.getParameter("userScaleId");
        IUserService userService=new UserServiceImpl();
        UserBean users=new UserBean();
        users.setId(Integer.parseInt(id));
        users.setPwd(pwd);
        users.setUserScaleId(Integer.parseInt(userScaleId));
        try {
            userService.updateUser(users);
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
