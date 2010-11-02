package log;



import java.io.*;
import org.apache.log4j.*;

public class Log4jHelper {
	
	private static final String FQCN = Log4jHelper.class.getName();
	
	public static Level getLog4jLevel(int level) {
		switch (level) {
		case SisLogger.INFO:
			return Level.INFO;
		
		case SisLogger.ERROR:
			return Level.ERROR;
		
		case SisLogger.WARN:
			return Level.WARN;
		
		case SisLogger.DEBUG:
			return Level.DEBUG;
		
		case SisLogger.FATAL:
			return Level.FATAL;
		
		default:
			return Level.DEBUG;
		}
	}
	
	public static void log(String callerFQCN, long locationID,
			String logMessage, int level) {
		Logger logger = Logger.getLogger(callerFQCN);
		Level log4jLevel = getLog4jLevel(level);
		if (logger.isEnabledFor(log4jLevel)) {
			logMessage = getMessage(callerFQCN, locationID, log4jLevel,
					logMessage);
			logger.log(log4jLevel, logMessage);
		}
	}
	
	public static String getExceptionMessage(Exception error) {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			error.printStackTrace(pw);
			return "******\r\n" + sw.toString() + "******\r\n";
			
		} catch (Exception e2) {
			return "Unknown Exception";
		}
	}
	
	public static void log(String callerFQCN, long locationID, Exception excep,
			int level) {
		Logger logger = Logger.getLogger(callerFQCN);
		Level log4jLevel = getLog4jLevel(level);
		if (logger.isEnabledFor(log4jLevel)) {
			String logMessage = getMessage(callerFQCN, locationID, log4jLevel,
					getExceptionMessage(excep));
			logger.log(log4jLevel, logMessage);
		}
	}
	
	public static String getMessage(String callerFQCN, long locationID,
			Level log4jLevel, String logMessage) {
		
		return " | " + callerFQCN + " | " + locationID + " | " + log4jLevel
		+ " | " + logMessage + " ";
	}
	
	public static void log(String callerFQCN, Level log4jLevel,
			String logMessage) {
		Logger logger = Logger.getLogger(callerFQCN);
		logger.log(log4jLevel, logMessage);
		return;
	}
}
