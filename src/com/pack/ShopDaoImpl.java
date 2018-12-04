package com.pack;

import com.DBUtils.DButil;
import com.pojos.Shop;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//查询商品的方法
public class ShopDaoImpl implements ShopDao {
    @Override
    public List<Shop> getAllShop() {
        Connection connection = DButil.getConnection();  //拿连接
        PreparedStatement preparedStatement=null;
        ResultSet resultSet= null;
        List<Shop>list=new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from shop");//预编译
            resultSet = preparedStatement.executeQuery();//得到结果集
            while (resultSet.next())
            {
                int shop_id = resultSet.getInt("shop_id");
                String shop_name = resultSet.getString("shop_name");
                String shop_des = resultSet.getString("shop_des");
                String shop_img = resultSet.getString("shop_img");
                BigDecimal shop_price = resultSet.getBigDecimal("shop_price");
                int shop_cate_id = resultSet.getInt("shop_cate_id");
                int shop_stock = resultSet.getInt("shop_stock");
                short shop_isgc = resultSet.getShort("shop_isgc");
                Shop shop = new Shop(shop_id,shop_name,shop_des,shop_img,shop_price,shop_cate_id,shop_stock,shop_isgc);
                list.add(shop);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DButil.closeResource(connection,preparedStatement,resultSet);
        }

        return list;


    }
//删除
    @Override
    public void deleteShops(int shop_id) {
        Connection connection = DButil.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from shop where shop_id = ?");
            preparedStatement.setInt(1,shop_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DButil.closeResource(connection,preparedStatement,null);
        }
    }
//添加商品
    @Override
    public boolean addOneShop(Shop shops) {
        Connection connection = DButil.getConnection();
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement = connection.prepareStatement("insert into shop (shop_id,shop_name,shop_des,shop_img,shop_price,shop_Cate_id,shop_stock,shop_isgc )values (?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,shops.getShop_id());
            preparedStatement.setString(2,shops.getShop_name());
            preparedStatement.setString(3,shops.getShop_des());
            preparedStatement.setString(4,shops.getShop_img());
            preparedStatement.setBigDecimal(5,shops.getShop_price());
            preparedStatement.setInt(6,shops.getShop_Cate_id());
            preparedStatement.setInt(7,shops.getShop_stock());
            preparedStatement.setShort(8,shops.getShop_isgc());
            int result = preparedStatement.executeUpdate();
            if(result!=0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DButil.closeResource(connection,preparedStatement,null);
        }
        return false;
    }

    @Override
    public Shop CheckOneShop(int id) {
        Connection connection = DButil.getConnection();  //拿连接
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement("select * from shop where shop_id=?");//预编译
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();//得到结果集
            if (resultSet.next()) {
                int shop_id = resultSet.getInt("shop_id");
                String shop_name = resultSet.getString("shop_name");
                String shop_des = resultSet.getString("shop_des");
                String shop_img = resultSet.getString("shop_img");
                BigDecimal shop_price = resultSet.getBigDecimal("shop_price");
                int shop_cate_id = resultSet.getInt("shop_cate_id");
                int shop_stock = resultSet.getInt("shop_stock");
                short shop_isgc = resultSet.getShort("shop_isgc");
                Shop shop = new Shop(shop_id,shop_name,shop_des,shop_img,shop_price,shop_cate_id,shop_stock,shop_isgc);
                return shop;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButil.closeResource(connection, preparedStatement, resultSet);
        }

        return null;

    }


    //修改

    @Override
    public void updateShop(Shop shop) {
        Connection connection = DButil.getConnection();  //拿连接
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement= connection.prepareStatement("update shop set shop_name=?,shop_des=?,shop_img=?,shop_price=?,shop_cate_id=?,shop_stock=?,shop_isgc=? where shop_id=?");
            preparedStatement.setString(1,shop.getShop_name());
            preparedStatement.setString(2,shop.getShop_des());
            preparedStatement.setString(3,shop.getShop_img());
            preparedStatement.setBigDecimal(4,shop.getShop_price());
            preparedStatement.setInt(5,shop.getShop_Cate_id());
            preparedStatement.setInt(6,shop.getShop_stock());
            preparedStatement.setShort(7,shop.getShop_isgc());
            preparedStatement.setInt(8,shop.getShop_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DButil.closeResource(connection,preparedStatement,null);
        }
    }

    @Override
    public int getrecods() {
        Connection connection = DButil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select count(*)as Count from shop  ");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                 return resultSet.getInt("Count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DButil.closeResource(connection,preparedStatement,resultSet);
        }
        return 0;
    }
//查询某一页数据
    @Override
    public List<Shop> getshopByLimit(int startIndex, int pageSize) {
        Connection connection = DButil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet= null;
        List<Shop>shops = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from shop  limit ?,? ");
            preparedStatement.setInt(1,startIndex);
            preparedStatement.setInt(2,pageSize);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int shop_id = resultSet.getInt("shop_id");
                String shop_name = resultSet.getString("shop_name");
                String shop_des = resultSet.getString("shop_des");
                String shop_img = resultSet.getString("shop_img");
                BigDecimal shop_price = resultSet.getBigDecimal("shop_price");
                int shop_cate_id = resultSet.getInt("shop_cate_id");
                int shop_stock = resultSet.getInt("shop_stock");
                short shop_isgc = resultSet.getShort("shop_isgc");
                Shop shop1 = new Shop(shop_id,shop_name,shop_des,shop_img,shop_price,shop_cate_id,shop_stock,shop_isgc);
                shops.add(shop1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DButil.closeResource(connection,preparedStatement,resultSet);
        }
        return shops;
    }


}
