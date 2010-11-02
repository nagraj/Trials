package log;

public class LogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("This is normal sysout...");
		SisLogger.log("LogTest", 1, "This is logged statement...", SisLogger.INFO);
	}

}
