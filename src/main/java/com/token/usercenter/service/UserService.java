package com.token.usercenter.service;

import com.token.usercenter.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;

/**
 * 用户服务
 *
* @author 墨小黑
* @description 针对表【user】的数据库操作Service
* @createDate 2026-02-09 20:44:19
*/
public interface UserService extends IService<User> {


    /**
            * 用户登录态键
     */
    String USER_LOGIN_STATUS = "userLogin_status";

    /**
     *
     * 用户注释
     *
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return  新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    /**
     * 用户登录
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @return 返回用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    int userLogout(HttpServletRequest request);
}
