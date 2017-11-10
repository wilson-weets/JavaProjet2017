package be.wilson.ClubVeloPOJO;

import java.util.*;

public class Calendrier {
	private List<Balade> cal;
	private ListIterator iter;

	public Calendrier() {
		this.cal = new ArrayList<>();
		iter = cal.listIterator();
	}

	public List<Balade> getCal() {
		return cal;
	}

	public void setCal(List<Balade> cal) {
		this.cal = cal;
	}
	
	public void addBalade(Balade b){
		if(!cal.contains(b))
			cal.add(b);
	}
	
	public void removeBalade(Balade b){
		cal.remove(b);
	}
}
