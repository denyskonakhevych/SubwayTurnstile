package tourniquet;

<<<<<<< HEAD
<<<<<<< HEAD
import pass.type.Pass;
import server.Server;

public class Tourniquet {
	
	Server server;

	public Tourniquet(Server server) {
		this.server = server;
	}
=======
import myutil.MyLinkedList;
import pass.Pass;
import pass.PassType;

public class Tourniquet {
	
	private MyLinkedList<Passage> passages = new MyLinkedList<>();
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae
=======
import myutil.MyLinkedList;
import pass.Pass;
import pass.PassType;

public class Tourniquet {
	
	private MyLinkedList<Passage> passages = new MyLinkedList<>();
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae
	
	public boolean checkPass(Pass pass) {
		if (pass == null) {
			throw new NullPointerException("Wrong pass type: " + pass);
		}
		try {
			pass.grantPassage();
<<<<<<< HEAD
<<<<<<< HEAD
			server.addPassage(pass.getPassId(), pass.getPassType(), true, pass.toString());
		} catch (IllegalStateException e) {
			server.addPassage(pass.getPassId(), pass.getPassType(), false, pass.toString());
=======
			passages.add(new Passage(pass.getPassId(), pass.getPassType(), true, pass.toString()));
		} catch (IllegalAccessException e) {
			passages.add(new Passage(pass.getPassId(), pass.getPassType(), false, pass.toString()));
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae
=======
			passages.add(new Passage(pass.getPassId(), pass.getPassType(), true, pass.toString()));
		} catch (IllegalAccessException e) {
			passages.add(new Passage(pass.getPassId(), pass.getPassType(), false, pass.toString()));
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae
			return false;
		}
		return true;
	}
	
	public int getPassagesNumber() {
	
		return passages.size();
	}
	
	public int getPassagesNumber(boolean passed) {
		int count = 0;
		for (int i = 0; i < passages.size(); i++) {
			Passage passage = passages.get(i);
			if (passage.passed == passed) {
				count++;
			}
		}
		return count;
	}
	
	public int getPassagesNumber(boolean passed, PassType passType) {
		
		int count = 0;
		for (int i = 0; i < passages.size(); i++) {
			Passage passage = passages.get(i);
			if (passage.passed == passed && passage.passType.equals(passType)) {
				count++;
			}
		}
		return count;
	}
	
	private class Passage {

		public final int id;
		public final PassType passType;
		public final boolean passed;
		public final String message; 
		
		public Passage(int id, PassType passType, boolean passed, String message) {
			this.id = id;
			this.passType = passType;
			this.passed = passed;
			this.message = message;
		}
	}
}
