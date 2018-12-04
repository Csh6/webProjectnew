package com.pack;


import com.pojos.User;

import javax.jws.soap.SOAPBinding;

public interface UsersDao {
    public boolean addOneUser(User user);
    boolean isExists(User user);
//    void addOneUser();

    //添加数据

}
