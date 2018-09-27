package com.example.web.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 应用场景：不对对象的行为或属性做改变。过滤掉非法url，设置统一字符集，移除非法字符...
 * Filter —— > listener ——> Intercepter
 */
@WebFilter(filterName = "MyFilter", urlPatterns = "/user/*")
public class MyFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        logger.info("--- 自定义过滤器操作---");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
