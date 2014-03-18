package server;

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
}
