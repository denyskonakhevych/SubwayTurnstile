package passages;

import pass.PassType;

public class NumberOfPassagesPassage extends Passage {

	public int numberOfPassegesLeft;
	
	public NumberOfPassagesPassage(int id, PassType passType, int numberOfPassegesLeft) {
		super(id, passType);
		this.numberOfPassegesLeft = numberOfPassegesLeft;
	}
}
