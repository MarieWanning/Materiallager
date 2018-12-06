package model;

/**
 * Das InterfaceLieferung enthält alle Methoden die Aus/- und Zulieferungen ausführen können sollen.
 *
 */
public interface InterfaceLieferung {
	void anzeigen();
	void ausfuehren(Lager ziellager);
}
