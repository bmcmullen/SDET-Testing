package com.FMHerndonSMI.Tests;

import org.apache.log4j.Logger;

public class MyLog {

	// Initialize Log4j log
	private static Logger log4jLog = Logger.getLogger(MyLog.class.getName());//

	public static void startTestCase(String sTestCaseName) {
		log4jLog.info("****************************************************************************************");
		log4jLog.info("*********************" + sTestCaseName);
		log4jLog.info("****************************************************************************************");
	}

	public static void endTestCase(String sTestCaseName) {
		log4jLog.info("****************************************************************************************");
		log4jLog.info("*********************" + sTestCaseName + "*** E N D ***");
		log4jLog.info("****************************************************************************************");
	}

	// Need to create these methods, so that they can be called
	
	
	public static void info(String message) {
		log4jLog.info(message);
	}

	public static void warn(String message) {
		log4jLog.warn(message);
	}

	public static void error(String message) {
		log4jLog.error(message);
	}

	public static void fatal(String message) {
		log4jLog.fatal(message);
	}

	public static void debug(String message) {
		log4jLog.debug(message);
	}
}