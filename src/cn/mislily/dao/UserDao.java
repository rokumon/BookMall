package cn.mislily.dao;

import cn.mislily.pojo.User;

import java.util.List;

public interface UserDao {

    public User queryUserById(int id);

    public User queryUserByUsername(String username);

    public User queryUserByUsernameAndPassword(String username, String password);

    public List<User> listUsers();

    public int saveUser(User user);

    public int updateUser(User user);

    public int deleteUser(User user);

}
