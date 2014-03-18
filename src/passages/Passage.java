package passages;

import pass.PassType;

public class Passage {

	public final int id;
	public final PassType passType;
	
	Passage(int id, PassType passType) {
		this.id = id;
		this.passType = passType;
	}
}
