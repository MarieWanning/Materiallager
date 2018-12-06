package model;




import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Sämtiche Lager sind Observable und werden von ihren Oberlagern beobachtet
 */
public class Lager extends Observable implements Observer{

	String name;
	int maxKapazitaet;
	int fuellstand;

	/**
	 * Alle zu diesem Lager gehörigen Unterlager
	 */
	//ArrayList, weil man so viele Lager hinzufügen kann, wie man möchte, das geht bei einem einfachen Array nicht.
	ArrayList<Lager> unterLager;
	ArrayList<Lieferung> erfolgteLieferungen;

	/**
	 * @param name: Name des Lagers
	 * @param maxKapazitaet: maximal Kapazität, die nicht überschritten werden kann.
	 * @param fuellstand: wie viel im Lager gefüllt ist
	 * @param oberLager: übergeordnete Lager
	 */
	public Lager(String name, int maxKapazitaet, int fuellstand, Lager oberLager) {
		if(fuellstand < maxKapazitaet) {
			this.name = name;
			this.maxKapazitaet = maxKapazitaet;
			this.fuellstand = fuellstand;
			oberLager.unterLager.add(this);
			this.addObserver(oberLager);
			setChanged();
			notifyObservers();
		}
		//	else(Fehler ausgeben)
	}

	public void nameAendern(String neuerName) {
		this.name = neuerName;
	}

	/**Diese Methode gibt ein int[2] mit
	 * @return [0] maxKapazität [1] fuellstand
	 */
	public int[] anzeigen() {
		int[] j = new int[2];
		if(unterLager.isEmpty()) {
			j[0] = maxKapazitaet;
			j[1] = fuellstand;
		}
		else {
			for(int i = 0; i < unterLager.size();i++) {
				unterLager.get(i);
				j[0] = j[0] + maxKapazitaet;
				j[1] = j[1] + fuellstand;
			}
		}
		return j;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}
}
