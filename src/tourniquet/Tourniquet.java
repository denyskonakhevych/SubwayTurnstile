package tourniquet;

import myutil.MyLinkedList;
import pass.Pass;
import passages.Passage;
import server.Server;

public class Tourniquet {
	
	//private Server server;
	
	MyLinkedList<Passage> passages = new MyLinkedList<>();
	
	public Tourniquet() {
		//this.server = server;
	}
	
	public boolean checkPass(Pass pass) {
		if (pass == null) {
			throw new IllegalArgumentException("Wrong pass type: " + pass);
		}
		try {
			pass.grantPassage();
			passages.add(pass.makePassage());
		} catch (IllegalAccessException e) {
			return false;
		}
		return true;
	}
}
