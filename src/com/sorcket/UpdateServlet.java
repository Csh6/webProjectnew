package com.sorcket;

import com.business.ShopBusiness;
import com.business.ShopBusinessImpl;
import com.pojos.Shop;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        //请求乱码
        req.setCharacterEncoding("utf-8");
        //相应乱码
        resp.setCharacterEncoding("utf-8");
        String sid = req.getParameter("sid");
        int i = Integer.parseInt(sid);
        String sName = req.getParameter("sName");
        String sDes = req.getParameter("sDes");
        String sImg = req.getParameter("sImg");
        String sPrice = req.getParameter("sPrice");
        //通过BigDecimal的构造方法将字符串类型的价格转换为BigDecimal类型
        BigDecimal bigDecimal= new BigDecimal(sPrice);
        String scate = req.getParameter("scate");
        int j = Integer.parseInt(scate);
        String stock = req.getParameter("sStock");
        int sto = Integer.parseInt(stock);
        String isgc = req.getParameter("sIs");
        short isg = Short.parseShort(isgc);
        ShopBusiness shopBusiness = new ShopBusinessImpl();
        Shop shop = new Shop(i,sName,sDes,sImg,bigDecimal,j,sto,isg);
        shopBusiness.updateShop(shop);
        //
        resp.sendRedirect("/ShopServlet");



    }
}
