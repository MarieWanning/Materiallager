package model;


public class Lieferung implements Factory{
	Datum datum;
	int menge;
	String kunde;
	Lager zielLager;	

	@Override
	public Lieferung erstelleLieferung() {
		if(menge>0) {
			return new Zulieferung();
		}
		else if(menge<0) {
			return new Ablieferung();
		}
		else return null;
	}
	
	public void ausfuehren(Lager zielLager) {
		zielLager.erfolgteLieferungen.add(this);
	}
	
	public void rueckgaengig() {		
		// letzte Änderung in der View rückgängig machen
	}
}
