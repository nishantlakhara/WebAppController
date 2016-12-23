package com.webapp.interfaces;

public class ApplicationFactory {
	public static String getAppJar(String appname) {
		if(appname.equals("App1")) {
			return "webapp1-0.1.0.jar";
		} else if(appname.equals("App2")) {
			return "webapp2-0.1.0.jar";
		}
		return null;
	}
}
