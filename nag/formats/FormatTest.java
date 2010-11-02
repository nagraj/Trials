package nag.formats;

import java.text.MessageFormat;

public class FormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Object[] links = { "english" };
		String formattedMsg = MessageFormat.format("<a href='yahoo.com' >{0} </a>", links);
		System.out.println("msg="+formattedMsg);
	}

}
