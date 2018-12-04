package com.pack;

import com.pojos.Shop;

import java.util.List;

public interface ShopDao {
    //查询所有商品
    public List<Shop> getAllShop();

    public void deleteShops(int shop_id);

    public boolean addOneShop(Shop shops);
    //查询:根据商品ID进行查询
    public Shop CheckOneShop(int id);



    //根据商品的ID修改
    public void updateShop(Shop shop);
//    //查询数据库中所有记录
    public  int getrecods();
//    //查询某一句也数据
    public List<Shop>getshopByLimit(int startIndex,int pageSize);
}
