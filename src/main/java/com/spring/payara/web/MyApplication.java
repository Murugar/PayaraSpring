package com.spring.payara.web;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;

@ApplicationPath("/api")
public class MyApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        HashMap<String, Object> prop = new HashMap<>();
        prop.put("jersey.config.disableMoxyJson", true); 
        return prop;
    }
}
