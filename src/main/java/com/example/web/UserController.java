package com.example.web;

import com.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by XiuYin.Cui on 2018/9/15.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

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

}
