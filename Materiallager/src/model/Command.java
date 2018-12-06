package model;

import java.util.ArrayList;

/**
 * Das Pattern COMMAND wird von uns genutzt um eine Redo/Undo-M�glichkeit w�hrend der Verteilung einer Buchung umzusetzen.
 */
public class Command {
	Lagerhierarchie hierarchie;
	/** Die ArrayList moeglicheBuchungen enth�lt alle bisher ausgew�hlten Buchungen. Diese sind noch nicht im Model.Lager gespeichert,
	 * sondern werden nur angezeigt.
	 *
	 */
	ArrayList<Lieferung> moeglicheBuchungen;

	public Command(Lagerhierarchie hierarchie) {
		this.hierarchie = hierarchie;
	}

	/**
	 * Diese Methode f�hrt erst die �nderungen, bzw. Buchungen im System aus. Vorher werden diese ausschlie�lich angezeigt.
	 */
	public void execute() {
		for (int i = 0; i < moeglicheBuchungen.size(); i++) {
			moeglicheBuchungen.get(i).ausfuehren(moeglicheBuchungen.get(i).zielLager);
		}
		moeglicheBuchungen.clear();
	}

	/**
	 * Diese Methode l�scht die letzte �nderung innerhalb einer Lieferung.
	 */
	public void undo() {
		moeglicheBuchungen.get(moeglicheBuchungen.size()-1).rueckgaengig();
	}

}
