package com.business;

import com.pojos.PageBeam;
import com.pojos.Shop;

import java.util.List;

/**
 *
 * shop业务层
// */
public interface ShopBusiness {
    public List<Shop> getAllShop();
    //根据ID查询具体商品
    public Shop getOneShop(int id);
    //根据商品ID修改
    public void updateShop(Shop shop);
    //根据当前页数和每页记录查询
    public PageBeam getShopByPaging(int pageNumber, int pageSize);
}
