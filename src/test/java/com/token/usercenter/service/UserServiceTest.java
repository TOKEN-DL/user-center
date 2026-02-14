package com.token.usercenter.service;
import java.util.Date;

import com.token.usercenter.model.User;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 用户服务测试
 *
 * @author delong
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {


    @Resource
    private UserService userService;


    @Test
    public void testAddUser() {

        User user = new User();
        user.setUsername("dogYupi");
        user.setAvatarUrl("123");
        user.setUserAccount("");
        user.setGender(0);
        user.setUserPassword("xxxx");
        user.setPhone("123456789");
        user.setEmail("2313");


        boolean result = userService.save(user);
        System.out.println(user.getId());
        assertTrue(result);
    }

    @Test
    public void userRegister() {
        String userAccount = "yupi";
        String userPassword = "";
        String checkPassword = "123456";
        String planetCode = "1";
        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        //断言？
        Assertions.assertEquals(-1, result);

        //测试不同的的特殊情况下是否能正常拦截
        //覆盖所有的测试路径
        userAccount = "yu";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "yupi";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "yu pi";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);


        userPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "dogYupi";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);

        userAccount = "yupi";

        result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
        Assertions.assertEquals(-1, result);


    }
}