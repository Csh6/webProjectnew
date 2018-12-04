package com.business;


import com.pack.ShopDao;
import com.pack.ShopDaoImpl;
import com.pojos.PageBeam;
import com.pojos.Shop;

import java.util.List;

public class ShopBusinessImpl implements ShopBusiness {

   private ShopDao shopDao = new ShopDaoImpl();

    @Override
    public List<Shop> getAllShop() {
        return  shopDao.getAllShop();
    }

    @Override
    public Shop getOneShop(int id) {
        return shopDao.CheckOneShop(id);
    }

    @Override
    public void updateShop(Shop shop) {
        shopDao.updateShop(shop);
    }

//    根据当前页数和每页的记录查询
    @Override
    public PageBeam getShopByPaging(int pageNumber, int pageSize) {
        //查询所有记录
        int getrecods = shopDao.getrecods();
        //构建PageBeam对象
        PageBeam pageBeam = new PageBeam(pageNumber,pageSize,getrecods);
        //拿到PageBeam中的开始索引
        Integer startIndex = pageBeam.getStartIndex();
        //拿到索引和页面数量查询商品
        List<Shop> shopByLimit = shopDao.getshopByLimit(startIndex, pageSize);
        pageBeam.setShops(shopByLimit);
        return pageBeam;
    }


}
