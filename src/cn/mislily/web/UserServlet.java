package cn.mislily.web;

import cn.mislily.pojo.User;
import cn.mislily.service.UserService;
import cn.mislily.service.impl.UserServiceImpl;
import cn.mislily.utils.ParameterUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class UserServlet extends BaseServlet {

    /**
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    */

    UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String,String[]> src = request.getParameterMap();

        User user = ParameterUtils.copyToBean(src, new User());

        //用户名为空
        if(user.getUsername() == null || "".equals(user.getUsername().trim())){

            request.setAttribute("errMessage", "请输入用户名！");

            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);

            return;
        }

        //密码为空
        if(user.getPassword() == null || "".equals(user.getPassword().trim())){

            request.setAttribute("errMessage", "请输入密码！");

            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);

            return;
        }

        //查询用户名和密码
        User loginUser = userService.login(user);

        //登录成功
        if (loginUser != null){

            request.setAttribute("user", loginUser);

            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);

            return;
        }

        //登录失败
        request.setAttribute("errMessage", "用户名或密码错误！");

        request.setAttribute("username", user.getUsername());

        request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> src = request.getParameterMap();

        User user = ParameterUtils.copyToBean(src, new User());

        String code = request.getParameter("code");

        request.setAttribute("user", user);

        //1.判断验证码
        if(!"abcd".equals(code)){

            request.setAttribute("errMessage", "验证码错误");

            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

            return;
        }

        //2.判断用户名
        if(user.getUsername() == null || userService.existUserName(user.getUsername())){

            if(user.getUsername() == null) {
                request.setAttribute("errMessage", "用户名不能为空");
            } else {
                if (userService.existUserName(user.getUsername())) {
                    request.setAttribute("errMessage", "用户名已存在");
                }
            }

            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);

            return;
        }

        //注册用户
        int changedRow = userService.regist(user);

        //changedRow > 0 说明插入成功
        if(changedRow > 0) {

            request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);

            return;
        }

        request.setAttribute("errMessage", "发生未知错误");

        request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
    }

}
