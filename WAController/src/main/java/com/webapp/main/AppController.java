package com.webapp.main;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webapp.interfaces.WebApplication;

@Controller
public class AppController {
    @RequestMapping("/app")
    public @ResponseBody JSONObject appOperation(@RequestParam(value="appname", required=true) String appname,
    											@RequestParam(value="operation", required=true) String operation,
    											@RequestParam(value="port", required=true) Integer port
    											) {
        System.out.println("Application  : " + appname);
        System.out.println("Operation  : " + operation);
        System.out.println("Port  : " + port);
        
        boolean operationStatus = false;
        if(operation.equals("start"))
        	operationStatus = new WebApplication().startApp(appname,port);
        else if(operation.equals("stop")) {
        	operationStatus = new WebApplication().stopApp(appname,port);
        }
        
        JSONObject obj = new JSONObject();

        obj.put("appname", appname);
        obj.put("operation", operation);
        obj.put("port", port);
        obj.put("operationStatus", operationStatus);

        System.out.println("Request completed");
        return obj;
    }
}

