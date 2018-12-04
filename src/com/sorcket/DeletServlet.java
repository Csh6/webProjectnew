package com.sorcket;


import com.pack.ShopDao;
import com.pack.ShopDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeletServlet",urlPatterns = "/DeleteServlet")
public class DeletServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        ShopDao shopDao = new ShopDaoImpl();
        String id = req.getParameter("id");
        int i = Integer.parseInt(id);
        shopDao.deleteShops(i);
        resp.sendRedirect("/ShopServlet");

    }
}
