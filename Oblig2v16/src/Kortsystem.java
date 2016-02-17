
public abstract class Kortsystem {
	private String fornavn, etternavn;
	private int pinkode, kortnummer;
	private boolean sperret;
	private static int antallKort;
	
	public Kortsystem(String fornavn, String etternavn, int pinkode) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
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
	
	abstract boolean sjekkPin();
}
