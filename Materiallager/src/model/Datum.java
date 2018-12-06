package model;

public class Datum {

	private int tag;
	private Monat monat;
	private int jahr;

	/** Konstruktor für ein neues Datum mit:
	 * @param tag Darf nicht >31 oder <0 sein
	 * @param monat ENUM enthält Monatsnamen
	 * @param jahr Darf nicht >9999 oder <1900
	 */
	public Datum(int tag, Monat monat, int jahr) {
		if (tag > 0 && tag < 31) {
			if (jahr < 9999 && jahr > 1900) {
				this.tag = tag;
				this.jahr = jahr;
				this.monat = monat;
			}
			//else Jahresfehler
		}
		//else Tagesfehler
	}

	public int getTag() {
		return tag;
	}

	public int getJahr() {
		return jahr;
	}

	public Monat getMonat() {
		return monat;
	}
}
