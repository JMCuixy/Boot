package com.example.web;

import com.example.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.annotation.XmlRootElement;

@Controller
@Api(tags = "XMLController", description = "验证XML格式返回")
@RequestMapping("/xml")
public class XMLController {


    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取用户", notes = "获取用户", httpMethod = "GET", produces = MediaType.APPLICATION_XML_VALUE)
    public User xmlController(@ApiParam(value = "用户uuid") @PathVariable String uuid, HttpServletRequest request) {
        User user = new User();
        user.setUuid(uuid);
        user.setAge(22);
        user.setMobile("15980292662");
        user.setName("张三");
        user.setSex(1);
        return user;
    }
}
