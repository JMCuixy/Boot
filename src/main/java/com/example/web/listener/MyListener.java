package com.example.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 应用场景：不对对象的属性或行为做任何改变，监听对象的变化，做相对应的操作。
 */
@WebListener
class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("listenerAttribute", "alpha");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
