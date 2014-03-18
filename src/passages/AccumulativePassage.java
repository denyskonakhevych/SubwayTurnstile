package passages;

import pass.PassType;

public class AccumulativePassage extends Passage {

	public float balance;
	
	public float pricePerPassage;
	
	public AccumulativePassage(int id, PassType passType, float balance, float pricePerPassage) {
		super(id, passType);
		this.balance = balance;
		this.pricePerPassage = pricePerPassage;
	}
}
