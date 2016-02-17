import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ansatt extends Kort {

	public Ansatt(String navn, int pinkode) {
		super(navn, pinkode);
	}

	@Override
	boolean sjekkPin(int kode) {
		if (isSperret())
			return false;
		
		GregorianCalendar date = new GregorianCalendar();
		
		int hour = date.get(Calendar.HOUR_OF_DAY);
		int day = date.get(Calendar.DAY_OF_WEEK);
		
		if (hour >=7 && hour <=17 && day !=1 && day !=7)
			return true;
		
		if (kode == getPinkode())
			return true;
		
		return false;
	}

}
