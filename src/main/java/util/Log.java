package util;

import org.apache.log4j.Logger;

public class Log {
	
	static Logger log = Logger.getLogger(Log.class.getName());
	
	public void info(String message)
	{
		log.info(message);
	}

	public static void error(String message)
	{
		log.error(message);
	}
	
	public static void startTC(String tcid)
	{
		log.info("********************");
		log.info("Executing test case :" + tcid);
		log.info("********************");
	}
}
