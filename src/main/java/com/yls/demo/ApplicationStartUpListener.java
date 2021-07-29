package com.yls.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author yunglee on 2021/07/10
 * @package com.yls.demo
 */
@WebListener
public class ApplicationStartUpListener implements ServletContextListener {
    private static final Logger log = LogManager.getLogger(ApplicationStartUpListener.class);

    public void contextDestroyed(ServletContextEvent event) {
        log.debug("contextDestroyed");
    }

    public void contextInitialized(ServletContextEvent event) {
        log.debug("contextInitialized");
        PropertyConfig.load();
    }
}
