package com.business;

import com.pack.UsersDao;
import com.pack.UsersDaoImpl;
import com.pojos.User;

public class UserServiceImpl implements UserService {

    UsersDao usersDao = new UsersDaoImpl();
    @Override
    public boolean userIsExists(User user) {
        return usersDao.isExists(user);
    }
}
