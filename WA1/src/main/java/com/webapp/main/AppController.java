package com.webapp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	
	
	
    @RequestMapping("/appinfo")
    public String appInfo(@RequestParam(value="state", required=false, defaultValue="Working") String name, Model model) {
        model.addAttribute("state", name);
        return "appinfo";
    }
    
//    @RequestMapping("/shutdown")
//    public void shutdownApp() {
//    	SpringApplication.run(Application.class).close();
//    }
}
