package tourniquet;

import pass.type.Pass;
import server.Server;

public class Tourniquet {
	
	Server server;
	
	public Tourniquet(Server server) {
		super();
		this.server = server;
	}

	public boolean checkPass(Pass pass) {
		if (pass == null) {
			throw new NullPointerException("Wrong pass type: " + pass);
		}
		try {
			pass.grantPassage();
			server.addPassage(pass.getPassId(), pass.getPassType(), true, pass.toString());
		} catch (IllegalStateException e) {
			server.addPassage(pass.getPassId(), pass.getPassType(), false, pass.toString());
			return false;
		}
		return true;
	}
}
