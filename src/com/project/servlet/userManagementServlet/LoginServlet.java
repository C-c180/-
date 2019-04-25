package com.project.servlet.userManagementServlet;

import com.project.bean.LogBean;
import com.project.bean.UserBean;
import com.project.service.ILogService;
import com.project.service.IUserService;
import com.project.service.impl.LogServiceImpl;
import com.project.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginFilter",value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("userName");
        String pwd=req.getParameter("pwd");
        IUserService userService=new UserServiceImpl();
        ILogService iLogService=new LogServiceImpl();
        try {
            UserBean user=userService.login(userName,pwd);
            if(user!=null){
                HttpSession session = req.getSession();
                session.setAttribute(session.getId(), user);
                LogBean logBean=new LogBean();
                logBean.setLogContent(user.getUserScale()+user.getRealName()+"登录成功");
                iLogService.addLog(logBean);
                resp.getWriter().print("1");
            }else{
                resp.getWriter().print("0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
