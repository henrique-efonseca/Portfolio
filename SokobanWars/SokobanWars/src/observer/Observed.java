package observer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Observed extends JFrame {
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void unregisterObserver(Observer o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		for (Observer o: observers) {
			o.update(this);
		}
	}

	
}
