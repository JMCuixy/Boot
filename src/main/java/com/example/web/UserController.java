package com.example.web;

import com.example.entity.User;
import com.example.service.UserSercice;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by XiuYin.Cui on 2018/9/15.
 */
@RestController
@RequestMapping("/user")
@Api(tags = "UserController", description = "用户操作相关")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserSercice userSercice;

    @RequestMapping("/index")
    @ApiOperation(value = "用户首页", notes = "用户首页", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String home() {
        return "Hello Boot";
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户", notes = "获取用户", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser(@ApiParam(value = "用户uuid") @PathVariable String uuid, HttpServletRequest request) {
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
    @ApiOperation(value = "根据用户uuid获取用户", notes = "根据用户uuid获取用户", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUserByUuid(@ApiParam(value = "用户uuid") @RequestParam String uuid, HttpServletRequest request) {
        return userSercice.getUserByUuid(uuid);
    }

    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    @ApiOperation(value = "用户列表", notes = "用户列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> listUser() {
        //假设是前端传入的分页参数
        int currentPage = 1;
        int pageSize = 10;
        return userSercice.listUser(currentPage, pageSize);
    }

}
