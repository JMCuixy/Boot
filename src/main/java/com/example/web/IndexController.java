package com.example.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "IndexController", description = "首页相关")
public class IndexController {

    @RequestMapping("/")
    @ApiOperation(value = "欢迎页面", notes = "欢迎页面", httpMethod = "GET", produces = MediaType.TEXT_HTML_VALUE)
    public String index() {
        return "forward:/public/index.html";
    }

    @RequestMapping("/index")
    @ApiOperation(value = "网站首页", notes = "网站首页", httpMethod = "GET", produces = MediaType.TEXT_HTML_VALUE)
    public String jspIndex() {
        return "index";
    }

}
