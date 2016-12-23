package com.webapp.interfaces;

import com.webapp.utils.RuntimeUtils;

public class WebApplication {
	private String appName;
	private int port;
	
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public boolean startApp(String appname, Integer port) {
		String jarName = ApplicationFactory.getAppJar(appname);
		String pid = RuntimeUtils.executeCommand("sh /Users/NI362849/Documents/workspace/WAController/getPid.sh " + port);
		if (pid == null || pid.isEmpty()) {
			RuntimeUtils.executeCommand("sh /Users/NI362849/Documents/workspace/WAController/runApp.sh " + port + " " + jarName + " " + appname );
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pid = RuntimeUtils.executeCommand("sh /Users/NI362849/Documents/workspace/WAController/getPid.sh " + port);
			if(pid != null && !pid.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public boolean stopApp(String appname, Integer port) {
		String pid = RuntimeUtils.executeCommand("sh /Users/NI362849/Documents/workspace/WAController/getPid.sh " + port);
		if (pid != null && !pid.isEmpty()) {
			RuntimeUtils.executeCommand("kill -9 " + pid);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pid = RuntimeUtils.executeCommand("sh /Users/NI362849/Documents/workspace/WAController/getPid.sh " + port);
			if(pid == null || pid.isEmpty())
				return true;
		}
		return false;
	}
}
