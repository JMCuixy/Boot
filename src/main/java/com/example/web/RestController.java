package com.example.web;

import com.example.entity.Area;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Api(tags = "RestController", description = "RestTemplate 实例操作类")
@RequestMapping("/area")
public class RestController {

    private RestTemplate restTemplate;

    @Autowired
    public RestController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    @RequestMapping("/list")
    @ResponseBody
    @ApiOperation(value = "获取行政区域列表", notes = "获取行政区域列表", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Area getForObject() {
        String host = "http://restapi.amap.com/v3/config/district?key=4f77b23fa82c9e4fa2e3b114b73a7cde&subdistrict=3";
        return restTemplate.getForObject(host, Area.class);
    }

}
