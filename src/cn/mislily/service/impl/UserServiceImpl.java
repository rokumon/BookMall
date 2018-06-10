package cn.mislily.service.impl;

import cn.mislily.dao.UserDao;
import cn.mislily.dao.impl.UserDaoImpl;
import cn.mislily.pojo.User;
import cn.mislily.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {

        User loginUser = userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());

        return loginUser;
    }

    @Override
    public int regist(User user) {

        int changedRow = userDao.saveUser(user);

        return changedRow;
    }

    @Override
    public boolean existUserName(String username) {

        User user = userDao.queryUserByUsername(username);

        if( user != null ){
            return true;
        }

        return false;
    }
}
