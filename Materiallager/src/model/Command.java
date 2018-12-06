package model;

import java.util.ArrayList;

/**
 * Das Pattern COMMAND wird von uns genutzt um eine Redo/Undo-Möglichkeit während der Verteilung einer Buchung umzusetzen.
 */
public class Command {
	Lagerhierarchie hierarchie;
	/** Die ArrayList moeglicheBuchungen enthält alle bisher ausgewählten Buchungen. Diese sind noch nicht im Model.Lager gespeichert,
	 * sondern werden nur angezeigt.
	 *
	 */
	ArrayList<Lieferung> moeglicheBuchungen;

	public Command(Lagerhierarchie hierarchie) {
		this.hierarchie = hierarchie;
	}

	/**
	 * Diese Methode führt erst die Änderungen, bzw. Buchungen im System aus. Vorher werden diese ausschließlich angezeigt.
	 */
	public void execute() {
		for (int i = 0; i < moeglicheBuchungen.size(); i++) {
			moeglicheBuchungen.get(i).ausfuehren(moeglicheBuchungen.get(i).zielLager);
		}
		moeglicheBuchungen.clear();
	}

	/**
	 * Diese Methode löscht die letzte Änderung innerhalb einer Lieferung.
	 */
	public void undo() {
		moeglicheBuchungen.get(moeglicheBuchungen.size()-1).rueckgaengig();
	}

}
