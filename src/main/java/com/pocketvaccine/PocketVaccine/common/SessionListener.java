package com.pocketvaccine.PocketVaccine.common;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SessionListener implements HttpSessionListener {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setMaxInactiveInterval(5);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

}