package com.pojos;

import java.io.Serializable;
import java.math.BigDecimal;

public class DeleteShops implements Serializable {

    private Integer shop_id;
    private String shop_name;
    private String shop_img;
    private String shop_des;
    private BigDecimal shop_price;
    public DeleteShops()
    {}

    public DeleteShops(Integer shop_id, String shop_name, String shop_img, String shop_des, BigDecimal shop_price) {
        this.shop_id = shop_id;
        this.shop_name = shop_name;
        this.shop_img = shop_img;
        this.shop_des = shop_des;
        this.shop_price = shop_price;
    }

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

    public String getShop_img() {
        return shop_img;
    }

    public void setShop_img(String shop_img) {
        this.shop_img = shop_img;
    }

    public String getShop_des() {
        return shop_des;
    }

    public void setShop_des(String shop_des) {
        this.shop_des = shop_des;
    }

    public BigDecimal getShop_price() {
        return shop_price;
    }

    public void setShop_price(BigDecimal shop_price) {
        this.shop_price = shop_price;
    }

    @Override
    public String toString() {
        return "DeleteShops{" +
                "shop_id=" + shop_id +
                ", shop_name='" + shop_name + '\'' +
                ", shop_img='" + shop_img + '\'' +
                ", shop_des='" + shop_des + '\'' +
                ", shop_price=" + shop_price +
                '}';
    }
}
