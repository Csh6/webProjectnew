package com.sorcket;

import com.business.ShopBusiness;
import com.business.ShopBusinessImpl;
import com.pack.ShopDao;
import com.pack.ShopDaoImpl;
import com.pojos.PageBeam;
import com.pojos.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopServlet",urlPatterns = "/ShopServlet")
public class ShopServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNumber = req.getParameter("pageNumber");
        int i = 0;
        if("".equals(pageNumber)||pageNumber==null)
        {
            i=1;
        }
        else
        {
             i = Integer.parseInt(pageNumber);
        }
        ShopBusiness shopBusiness = new ShopBusinessImpl();
        PageBeam shopByPaging = shopBusiness.getShopByPaging(i, 3);
        req.setAttribute("pageBeam",shopByPaging);
        req.getRequestDispatcher("shop.jsp").forward(req,resp);
    }
}
