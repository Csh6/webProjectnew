package com.sorcket;

import com.pack.UsersDao;
import com.pack.UsersDaoImpl;
import com.pojos.User;
import com.sun.applet2.preloader.event.UserDeclinedEvent;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServ",value = "/register")
public class RegisterServ extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
    //构造方法
    public RegisterServ()
    {
        System.out.println("构造方法");
    }
    //初始化
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("初始化");
    }
    //提交方式的方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        //请求乱码
        req.setCharacterEncoding("utf-8");
        //相应乱码
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String psw = req.getParameter("psw");
        String cpsw = req.getParameter("cpsw");
        String telphone = req.getParameter("telphone");
        String email = req.getParameter("email");
        String postCard = req.getParameter("postCard");
        System.out.println(username+psw+telphone+email+postCard);
        User user = new User(username,psw,telphone,email,postCard);
        UsersDaoImpl usersDao = new UsersDaoImpl();
        boolean b = usersDao.addOneUser(user);
        if (b==true)
        {
            req.getRequestDispatcher("index.jsp").forward(req,resp);
            return;
        }
        else
        {
            req.setAttribute("message","注册失败");
            req.removeAttribute("message");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }

    }
    //销毁方法
    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
