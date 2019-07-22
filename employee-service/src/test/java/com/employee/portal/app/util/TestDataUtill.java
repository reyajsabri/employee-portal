package com.employee.portal.app.util;

import java.io.IOException;
import java.net.Socket;

import org.hsqldb.server.Server;

/**
 * @author reyaj.ahmed
 *
 */
public class TestDataUtill {
	
	private static final Server sv = new Server();
	private static volatile boolean isServerStarted = false;
	public static void startHSQLDB() {
		if(isServerStarted)
			return;
		try {
			
			if(!available(9001)) {
				return;
			}
			
			String[] arg = {"-port", "9001"};
			sv.setPort(9001);
			sv.main(arg);
			isServerStarted = true;
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void stopHSQLDB() {
		if(!isServerStarted)
			return;
		try {
			sv.shutdown();
			Thread.sleep(1000);
			isServerStarted = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean available(int port) {
	    try (Socket ignored = new Socket("localhost", port)) {
	        return false;
	    } catch (IOException ignored) {
	        return true;
	    }
	}

}
