package com.sorcket;

import com.business.ShopBusiness;
import com.business.ShopBusinessImpl;
import com.pojos.PageBeam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PageServlet",urlPatterns = "/PageServlet")
public class PageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNumber = req.getParameter("pageNumber");
        int changePage=0;
        if (pageNumber == null ||"".equals(pageNumber))
        {
            changePage = 1;
        }
        else {
            changePage = Integer.parseInt(pageNumber);
        }

        ShopBusiness shopBusiness = new ShopBusinessImpl();
        PageBeam shopByPaging = shopBusiness.getShopByPaging(changePage,3);
        req.setAttribute("pageBeam",shopByPaging);
        req.getRequestDispatcher("ShopServlet").forward(req,resp);


    }
}
