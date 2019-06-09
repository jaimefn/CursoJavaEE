package beans;

public class Numeros {

	public static boolean IsNumeric(String s) {
		try {
			Long.parseLong(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
