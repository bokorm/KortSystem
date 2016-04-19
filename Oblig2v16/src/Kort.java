

public abstract class Kort implements Cloneable, Comparable<Kort>{
	private String fornavn, etternavn;
	private int pinkode, kortnummer;
	private boolean sperret;
	private static int antallKort;
	
	public Kort(String navn, int pinkode) {
		String[] names = navn.split(" ", 2);
		this.fornavn = names[0];
		this.etternavn = names[1];
		this.pinkode = pinkode;
		sperret = false;
		kortnummer = ++antallKort;
	}
	
	public String getNavn(){
		return fornavn + " " +etternavn;
	}
	
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	public int getPinkode() {
		return pinkode;
	}
	public void setPinkode(int pinkode) {
		this.pinkode = pinkode;
	}
	public int getKortnummer() {
		return kortnummer;
	}
	public void setKortnummer(int kortnummer) {
		this.kortnummer = kortnummer;
	}
	public boolean isSperret() {
		return sperret;
	}
	public void setSperret(boolean sperret) {
		this.sperret = sperret;
	}

	@Override
	public String toString() {
		return "Kort: fornavn= " + fornavn + ", etternavn= " + etternavn + ", kortnummer= " + kortnummer
				+ ", sperret= " + sperret;
	}
	
	abstract boolean sjekkPin(int kode);

	@Override
	public int compareTo(Kort kort) {
		int resultat = this.etternavn.compareTo(kort.etternavn);
		
		if(resultat == 0)
			resultat = this.fornavn.compareTo(kort.fornavn);
		
		return resultat;
	}

	@Override
	protected Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Kloning feilet.");
			return null;
		}
	}
}
