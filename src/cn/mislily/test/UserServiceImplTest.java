package cn.mislily.test;

import cn.mislily.pojo.User;
import cn.mislily.service.UserService;
import cn.mislily.service.impl.UserServiceImpl;

public class UserServiceImplTest {

    private static UserService userService = new UserServiceImpl();

    @org.junit.Test
    public void login() {

        User user = new User(0, "admin", "admin", null);

        User loginUser = userService.login(user);

        System.out.println(loginUser);
    }

    @org.junit.Test
    public void regist() {

        User user = new User(0, "Tony", "123456", "Tony@163.com");

        int changedRow = userService.regist(user);

        System.out.println(changedRow);

    }

    @org.junit.Test
    public void existUserName() {

        boolean exist = userService.existUserName("Tony");

        System.out.println(exist);
    }
}