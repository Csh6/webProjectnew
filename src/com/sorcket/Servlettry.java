package com.sorcket;

import com.business.UserService;
import com.business.UserServiceImpl;
import com.pojos.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Servlettry",value="/Servlettry")
public class Servlettry extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //请求乱码
        req.setCharacterEncoding("utf-8");
        //相应乱码
        resp.setCharacterEncoding("utf-8");
        //拿到用户名
        String username = req.getParameter("username");
        //拿到表单密码
        String password = req.getParameter("password");
        //
        HttpSession session = req.getSession();
        session.setAttribute("username",username);
        session.setAttribute("password",password);
//        resp.sendRedirect("shop.jsp");
        System.out.println("servlet接受："+username+password);
        boolean b = false;
        if (username!=null &&!"".equals(username) && password!=null && !"".equals(password))
        {
            //调用业务层方法
            UserService userService = new UserServiceImpl();
            //创建要比较的对象
            User compareUser = new User();
            //给比较的方法赋值
            compareUser.setUserName(username);
            compareUser.setPassWord(password);
           b = userService.userIsExists(compareUser);
        }

        if (b == true) {
            //创建cookie
            Cookie cookie = new Cookie("username",username);
           //设置过期时间
            cookie.setMaxAge(60);
            //添加到cookie
            resp.addCookie(cookie);
            //跳到查询页面
            req.getRequestDispatcher("ShopServlet").forward(req, resp);
//            return;
        }
        else
        {
            Cookie[] cookies = req.getCookies();
            if (cookies !=null)
            {
                for (Cookie c:cookies) {
                    if ("username".equals(c.getName()))
                    {
                        req.getRequestDispatcher("ShopServlet").forward(req, resp);
                        return;
                    }
                    else
                    {
                        req.getRequestDispatcher("index.jsp").forward(req,resp);
                        return;
                    }
                }
            }
            req.getRequestDispatcher("index.jsp").forward(req,resp);

        }

    }
}


//        if (exist == true)
//        {
//            request.getRequestDispatcher("ShopServlet").forward(request,response);
//            return;
//        }
//        else {
//            request.getRequestDispatcher("index.jsp").forward(request,response);
//        }
//        Cookie[] cookies = req.getCookies();
//        out.println(cookies);
//        if (cookies==null)
//        {
//            Cookie cookie = new Cookie("username","csh");
//            Cookie cookie1 = new Cookie("password","12345");
//        }
//        if (cookies !=null && cookies.length>0)
//        {
//            for (Cookie c:cookies) {
//                out.print(c.getName());
//                out.print(c.getValue());
//            }
//        }
//        out.println("用户名"+username+"密码"+password);
//
//    }
//    }

