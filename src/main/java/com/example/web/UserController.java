package com.example.web;

import com.example.entity.User;
import com.example.service.UserSercice;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by XiuYin.Cui on 2018/9/15.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserSercice userSercice;

    @RequestMapping("/index")
    public String home() {
        return "Hello Boot";
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    public User getUser(@PathVariable String uuid, HttpServletRequest request) {
        String listenerAttribute = (String) request.getServletContext().getAttribute("listenerAttribute");
        logger.info("监听器中容器初始化加载的参数是：{}", listenerAttribute);
        User user = new User();
        user.setUuid(uuid);
        user.setAge(22);
        user.setMobile("15980292662");
        user.setName("张三");
        user.setSex(1);
        return user;
    }

    @RequestMapping(value = "/getUserByUuid", method = RequestMethod.GET)
    public User getUserByUuid(@RequestParam String uuid, HttpServletRequest request) {
        return userSercice.getUserByUuid(uuid);
    }

    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public List<User> listUser() {
        //假设是前端传入的分页参数
        int currentPage = 1;
        int pageSize = 10;
        return userSercice.listUser(currentPage, pageSize);
    }

}
