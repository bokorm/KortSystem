
public interface Konstanter {

	double BONUS_FAKTOR = 1.2; 
	
	double KREDITT_FAKTOR = 1.5; 
	
	void settFornavn(String fornavn);

	String hentFornavn();

	void settEtternavn(String etternavn);

	String hentEtternavn();

	void setFulltNavn(String navn);

	String hentFultNavn();

	double beregnKreditt();

	double beregnBonus();

}
