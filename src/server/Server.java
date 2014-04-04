package server;

import pass.PassType;
import tourniquet.Tourniquet;
import myutil.MyLinkedList;

public class Server {

	public MyLinkedList<Tourniquet> tourniquets = new MyLinkedList<>();
	
	public Server(int numberOfTourniquets) {
		if (numberOfTourniquets <= 0) {
			throw new IllegalArgumentException("Illegal number of tourniquets: " + numberOfTourniquets);
		}
		for (int i = 0; i < numberOfTourniquets; i++) {
			tourniquets.add(new Tourniquet());
		}
	}
	
	public int getPassagesNumber() {
		int totalPassages = 0;
		for (int i = 0; i < tourniquets.size(); i++) {
			totalPassages += tourniquets.get(i).getPassagesNumber();
		}
		return totalPassages;
	}
	
	public int getPassagesNumber(boolean passed) {
		
		int totalPassages = 0;
		for (int i = 0; i < tourniquets.size(); i++) {
			totalPassages += tourniquets.get(i).getPassagesNumber(passed);
		}
		return totalPassages;
	}
	
	public int getPassagesNumber(boolean passed, PassType passType) {
		int totalPassages = 0;
		for (int i = 0; i < tourniquets.size(); i++) {
			totalPassages += tourniquets.get(i).getPassagesNumber(passed, passType);
		}
		return totalPassages;
	}
}
