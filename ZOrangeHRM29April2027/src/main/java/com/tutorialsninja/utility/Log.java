package com.tutorialsninja.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {
	//Initialize log4j logs
	public static Logger log = LogManager.getLogger(Log.class);
	

    public static void startTestCase(String sTestCaseName) {
        log.info("======================="+sTestCaseName+" TEST STARTS==========");
    }

    

    public static void endTestCase(String sTestCaseName) {
        log.info("======================="+sTestCaseName+" TEST ENDS==========");
    }
    
    
    
    public static void info(String message) {
        log.info(message);
    }
    
    public static void error(String message) {
        log.error(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void debug(String message) {
        log.debug(message);
    }

}
