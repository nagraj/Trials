package log;


/*
 * Created on Jul 11, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */


/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class SisLogger {
	
	public static final int DEBUG = 0;
	
	public static final int INFO = 1;
	
	public static final int WARN = 2;
	
	public static final int ERROR = 3;
	
	public static final int FATAL = 4;

	
	public static void log(String callerFQCN, long locationID,
			String logMessage, int level) {
		Log4jHelper.log(callerFQCN, locationID, logMessage, level);
	}
	
	public static void log(String callerFQCN, long locationID, Exception execp,
			int level) {
		Log4jHelper.log(callerFQCN, locationID, execp, level);
	}
	
}
