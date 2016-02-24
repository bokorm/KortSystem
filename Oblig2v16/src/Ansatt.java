import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.LogRecord;

public class Ansatt extends Kort implements Konstanter{
	double lonn;
	GregorianCalendar ansatt;

	public Ansatt(String navn, int pinkode) {
		super(navn, pinkode);
		this.lonn = 200;
		ansatt = new GregorianCalendar();
	}
	
	public Ansatt(String navn, int pinkode, double lonn ,int aar, int maaned, int dag) {
		super(navn, pinkode);
		this.lonn = lonn;
		ansatt = new GregorianCalendar(aar, maaned, dag);
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

	@Override
	public void settFornavn(String fornavn) {
		super.setFornavn(fornavn);
	}

	@Override
	public String hentFornavn() {
		return super.getFornavn();	
		}

	@Override
	public void settEtternavn(String etternavn) {
		super.setEtternavn(etternavn);
	}

	@Override
	public String hentEtternavn() {
		return super.getEtternavn();
	}

	@Override
	public void setFulltNavn(String navn) {
		String[] names = navn.split(" ", 2);
		setFornavn(names[0]);
		setEtternavn(names[1]);
	}

	@Override
	public String hentFultNavn() {
		return super.getNavn();
	}

	@Override
	public double beregnKreditt() {
		return lonn * KREDITT_FAKTOR;
	}

	@Override
	public double beregnBonus() {
		int aarNaa = new GregorianCalendar().get(Calendar.YEAR);
		int aarAnsatt = ansatt.get(Calendar.YEAR);
		
		return (aarNaa- aarAnsatt) * BONUS_FAKTOR;
	}

}
