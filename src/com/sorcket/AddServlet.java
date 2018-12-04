package com.sorcket;

import com.business.ShopBusiness;
import com.business.ShopBusinessImpl;
import com.pack.ShopDao;
import com.pack.ShopDaoImpl;
import com.pojos.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "AddServlet",urlPatterns = "/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //从请求中获取用户信息
//        String sid = req.getParameter("sid");
//        int i = Integer.parseInt(sid);
//        String sName = req.getParameter("sName");
//        String sDes = req.getParameter("sDes");
//        String sImg = req.getParameter("sImg");
//        String sPrice = req.getParameter("sPrice");
//        BigDecimal bigDecimal= new BigDecimal(sPrice);
//        String scate = req.getParameter("scate");
//        int j = Integer.parseInt(scate);
//        String stock = req.getParameter("stock");
//        int sto = Integer.parseInt(stock);
//        String isgc = req.getParameter("isgc");
//        short isg = Short.parseShort(isgc);
//
//        //调用dao层
//        //ShopBusiness shopBusiness = new ShopBusinessImpl();
//        Shop shop = new Shop(i,sName,sDes,sImg,bigDecimal,j,sto,isgc);
//        ShopDao shopDao = new ShopDaoImpl();
//        boolean b = shopDao.addOneShop(shop);
//        System.out.println(b);
//        if (b == true)
//        {
//            req.
//            req.getRequestDispatcher("/AddImgServlet").forward(req,resp);
//            return;
//        }
//        req.getRequestDispatcher("/shop.jsp").forward(req,resp);
  }
}

