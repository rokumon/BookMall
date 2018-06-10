package cn.mislily.dao.impl;

import cn.mislily.dao.UserDao;
import cn.mislily.pojo.User;

import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User queryUserById(int id) {

        String sql = "SELECT id, username, password, email " +
                     "FROM t_user " +
                     "WHERE id = ?";

        User user = queryForOne(sql, id);

        return user;

    }

    @Override
    public User queryUserByUsername(String username) {

        String sql = "SELECT id, username, password, email " +
                     "FROM t_user " +
                     "WHERE username = ?";

        User user = queryForOne(sql, username);

        return user;
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {

        String sql = "SELECT id, username, password, email " +
                     "FROM t_user " +
                     "WHERE username = ? AND password = ?";

        User user = queryForOne(sql, username, password);

        return user;
    }

    @Override
    public List<User> listUsers() {

        String sql = "SELECT id, username, password, email " +
                     "FROM t_user ";

        List<User> users = queryForList(sql);

        return users;
    }

    @Override
    public int saveUser(User user) {

        String sql = "INSERT INTO t_user(username, password, email) " +
                     "VALUES(?,?,?)";

        int changedRow = update(sql, user.getUsername(), user.getPassword(), user.getEmail());

        return changedRow;
    }

    @Override
    public int updateUser(User user) {

        String sql = "UPDATE t_user " +
                     "SET username = ?, password = ?, email = ? " +
                     "WHERE id = ?";

        int changedRow = update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getId());

        return changedRow;
    }

    @Override
    public int deleteUser(User user) {

        String sql = "DELETE FROM t_user " +
                     "WHERE id = ?";

        int changedRow = update(sql, user.getId());

        return changedRow;
    }
}
