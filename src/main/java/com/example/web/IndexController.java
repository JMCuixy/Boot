package com.example.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Api(tags = "IndexController", description = "首页相关")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);


    @RequestMapping("/")
    @ApiOperation(value = "欢迎页面", notes = "欢迎页面", httpMethod = "GET", produces = MediaType.TEXT_HTML_VALUE)
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        logger.info(session.getId());
        return "forward:/public/index.html";
    }

    @RequestMapping("/index")
    @ApiOperation(value = "网站首页", notes = "网站首页", httpMethod = "GET", produces = MediaType.TEXT_HTML_VALUE)
    public String jspIndex() {
        return "index";
    }

}
