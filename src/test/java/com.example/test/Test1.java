package com.example.test;

import com.example.Example;
import com.example.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test1 {

    @Autowired
    private TestRestTemplate testRestTemplate; //可以解析到运行服务器的相关链接
    @LocalServerPort // 用于注入测试用例实际使用的端口
    private Integer localServerPort;

    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {
            public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("localhost")) {
                    return true;
                }
                return false;
            }
        });
    }

    @Test
    public void Test1() {
        System.out.println("测试启动的随机端口是" + localServerPort);
        Area area = testRestTemplate.
                getForObject("/area/list", Area.class);
        System.out.println(area.getInfo());
    }
}
