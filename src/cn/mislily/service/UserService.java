package cn.mislily.service;

import cn.mislily.pojo.User;

public interface UserService {

    public User login(User user);

    public int regist(User user);

    public boolean existUserName(String username);

}
