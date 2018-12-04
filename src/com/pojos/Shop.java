package com.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
//定义实体类要存的东西
public class Shop implements Serializable {

    public  Shop()
    {

    }
    private Integer shop_id;
    private String shop_name;
    private String shop_des;
    private String shop_img;
    private BigDecimal shop_price;
    private Integer shop_Cate_id;
    private Integer shop_stock;
    private short shop_isgc;

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_des() {
        return shop_des;
    }

    public void setShop_des(String shop_des) {
        this.shop_des = shop_des;
    }

    public String getShop_img() {
        return shop_img;
    }

    public void setShop_img(String shop_img) {
        this.shop_img = shop_img;
    }

    public BigDecimal getShop_price() {
        return shop_price;
    }

    public void setShop_price(BigDecimal shop_price) {
        this.shop_price = shop_price;
    }

    public Integer getShop_Cate_id() {
        return shop_Cate_id;
    }

    public void setShop_Cate_id(Integer shop_Cate_id) {
        this.shop_Cate_id = shop_Cate_id;
    }

    public Integer getShop_stock() {
        return shop_stock;
    }

    public void setShop_stock(Integer shop_stock) {
        this.shop_stock = shop_stock;
    }

    public short getShop_isgc() {
        return shop_isgc;
    }

    public void setShop_isgc(short shop_isgc) {
        this.shop_isgc = shop_isgc;
    }

    public Shop(Integer shop_id, String shop_name, String shop_des, String shop_img, BigDecimal shop_price, Integer shop_Cate_id, Integer shop_stock, short shop_isgc) {
        this.shop_id = shop_id;
        this.shop_name = shop_name;
        this.shop_des = shop_des;
        this.shop_img = shop_img;
        this.shop_price = shop_price;
        this.shop_Cate_id = shop_Cate_id;
        this.shop_stock = shop_stock;
        this.shop_isgc = shop_isgc;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shop_id=" + shop_id +
                ", shop_name='" + shop_name + '\'' +
                ", shop_des='" + shop_des + '\'' +
                ", shop_img='" + shop_img + '\'' +
                ", shop_price=" + shop_price +
                ", shop_Cate_id=" + shop_Cate_id +
                ", shop_stock=" + shop_stock +
                ", shop_isgc=" + shop_isgc +
                '}';
    }
}
