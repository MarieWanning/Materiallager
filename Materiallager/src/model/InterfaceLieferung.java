package model;

/**
 * Das InterfaceLieferung enth�lt alle Methoden die Aus/- und Zulieferungen ausf�hren k�nnen sollen.
 *
 */
public interface InterfaceLieferung {
	void anzeigen();
	void ausfuehren(Lager ziellager);
}
