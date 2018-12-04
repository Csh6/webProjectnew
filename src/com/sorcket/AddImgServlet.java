package com.sorcket;

import com.pack.ShopDao;
import com.pack.ShopDaoImpl;
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

@WebServlet(name = "AddImgServlet",urlPatterns = "/AddImgServlet")
public class AddImgServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求代码
        req.setCharacterEncoding("utf-8");

        resp.setContentType("text/html;charset=UTF-8");
        //相应乱码
        resp.setCharacterEncoding("utf-8");
        //创建商品实例化对象
        Shop shop = new Shop();
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setHeaderEncoding("utf-8");
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem f : fileItems) {
                if (!f.isFormField()) {
                    //拿值
                    System.out.println(f.getName());
                    String s = f.getName().toLowerCase();
                    shop.setShop_img(s);
                    //判断问价格式是否为照片
                    if (s.endsWith(".jpg") || s.endsWith(".jpeg") || s.endsWith(".png")) {
                        shop.setShop_img(f.getName());
                        //拿到文件流
                        InputStream inputStream = f.getInputStream();
                        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\东软\\textphoto\\" + f.getName());
                        byte[] catche = new byte[1024];
                        int length = 0;
                        while ((length = inputStream.read(catche)) != -1) {
                            outputStream.write(catche, 0, length);
                        }
                        outputStream.flush();
                        outputStream.close();
                        inputStream.close();
                    } else {
                        req.setAttribute("massage", "格式不正确青重新上传");
                    }
                }else {
                    if (f.getFieldName().equals("sid")) {
                        System.out.println("id:" + f.getString("utf-8"));
                        shop.setShop_id(Integer.parseInt(f.getString("utf-8")));
                    }
                    if (f.getFieldName().equals("sName")) {
                        shop.setShop_name(f.getString("utf-8"));
                    }
                    if (f.getFieldName().equals("sDes")) {
                        System.out.println("商品介绍:" + f.getString("utf-8"));
                        shop.setShop_des(f.getString("utf-8"));
                    }
//                    if (f.getFieldName().equals("sImg")) {
//                        shop.setShop_img(f.getString("utf-8"));
//                    }
                    if (f.getFieldName().equals("sPrice")) {
                        shop.setShop_price(new BigDecimal(f.getString("utf-8")));
                    }
                    if (f.getFieldName().equals("scate")) {
                        System.out.println("商品类别:" + f.getString());
                        shop.setShop_Cate_id(Integer.parseInt(f.getString("utf-8")));
                    }
                    if (f.getFieldName().equals("sIs")) {
                        shop.setShop_stock(Integer.parseInt(f.getString("utf-8")));
                    }
                    if (f.getFieldName().equals("isgc")) {
                        shop.setShop_isgc(new Short(f.getString("utf-8")));
                    }
                }

            }
            System.out.println("shop的信息为:"+shop);
            //调用添加方法
            ShopDao shopDao = new ShopDaoImpl();
            boolean b = shopDao.addOneShop(shop);
            System.out.println(b);
            if (b = true) {
                req.getRequestDispatcher("ShopServlet").forward(req, resp);
                System.out.println("成功添加");
            } else {
                req.getRequestDispatcher("add.jap").forward(req, resp);
                System.out.println("添加失败");
            }
        }catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
