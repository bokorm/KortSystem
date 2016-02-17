import java.util.Calendar;
import java.util.GregorianCalendar;

public class Gjest extends Kort {

	private GregorianCalendar expires;
	
	public Gjest(String navn) {
		super(navn, 9999);
		expires = new GregorianCalendar();
		expires.add(Calendar.DAY_OF_MONTH, 7);
	}

	@Override
	boolean sjekkPin(int kode) {
		if (isSperret())
			return false;
		
		GregorianCalendar date = new GregorianCalendar();
		int result = date.compareTo(expires);
		
		if (result > 0)
			return false;
		
		if (kode == getPinkode())
			return true;
		
		return false;
	}

}
