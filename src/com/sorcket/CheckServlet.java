package com.sorcket;

import com.business.ShopBusiness;
import com.business.ShopBusinessImpl;
import com.pojos.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckServlet",urlPatterns = "/CheckServlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("sid");
        int i = Integer.parseInt(sid);
        ShopBusiness shopBusiness = new ShopBusinessImpl();
        Shop oneShop = shopBusiness.getOneShop(i);
        req.setAttribute("shop",oneShop);
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }
}
