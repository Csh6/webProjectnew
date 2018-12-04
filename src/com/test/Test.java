package com.test;

import com.business.ShopBusiness;
import com.business.ShopBusinessImpl;
import com.pack.ShopDao;
import com.pack.ShopDaoImpl;
import com.pack.UsersDao;
import com.pack.UsersDaoImpl;
import com.pojos.PageBeam;
import com.pojos.Shop;
import com.pojos.User;

import java.util.List;

public class Test {
    public static void main(String[] args) {
//       UsersDao usersDao = new UsersDaoImpl();
//       User user = new User("name","123456","123456","23654","182697");
//        boolean b = usersDao.addOneUser(user);
//        System.out.println(b);
//        ShopDao shopDao = new ShopDaoImpl();
//        List<Shop> allShop = shopDao.getAllShop();
//        System.out.println(allShop);

//        ShopDao shopDao = new ShopDaoImpl();
//        Shop shop = new Shop(3,"shu",null,"hi","text.jpg");
//        boolean b = shopDao.addOneShop(shop);
//        System.out.println(b);
        //分页查询test测试类

        ShopBusiness shopBusiness = new ShopBusinessImpl();
        PageBeam shopByPaging = shopBusiness.getShopByPaging(1, 2);
        System.out.println(shopByPaging.getShops());

    }
}
