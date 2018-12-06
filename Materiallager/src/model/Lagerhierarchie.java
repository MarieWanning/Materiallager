package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Lagerhierarchie implements Observer{
	ArrayList<Lager> hierarchie;

	public Lagerhierarchie(){
		Lager Deutschland = new Lager("Deutschland", 0, 0, null);
		Lager Niedersachsen = new Lager("Niedersachsen",0,0, Deutschland);
		new Lager("Hannover-Misburg", 0,0, Niedersachsen);
		new Lager("Nienburg", 0,0, Niedersachsen);
		new Lager("NRW", 0,0, Deutschland);
		new Lager("Bremen", 0,0, Deutschland);
		new Lager("Hessen", 0,0, Deutschland);
		new Lager("Sachsen", 0,0, Deutschland);
		new Lager("Brandenburg", 0,0, Deutschland);
		new Lager("MV", 0,0, Deutschland);
		Lager Europa = new Lager("Europa", 0,0, null);
		Lager Frankreich = new Lager("Frankreich", 0,0, Europa);
		new Lager("Paris-Nord", 0,0, Frankreich);
		new Lager("Orléans", 0,0, Frankreich);
		new Lager("Marseille", 0,0, Frankreich);
		new Lager("Nímes", 0,0, Frankreich);
		Lager Italien = new Lager("Italien", 0,0, Europa);
		new Lager("Mailand", 0,0, Italien);
		new Lager("L`Aquila", 0,0, Italien);
		new Lager("Spanien", 0,0, Europa);
		new Lager("Großbritannien", 0,0, null);

	}

	@Override
	public void update(Observable lager, Object arg) {
		Lager l = (Lager) lager;
		hierarchie.add(l);
	}
}
