package pass.type;

import pass.passtype.NumberOfPassagesPassType;

public class NumberOfPassagesPass extends Pass {

	private int numberOfPassegesLeft;
	
	public NumberOfPassagesPass(int id, NumberOfPassagesPassType passType) {
		super(id, passType);
		this.numberOfPassegesLeft = passType.getValue();
	}
	
	public int getNumberOfPasseges() {
		return numberOfPassegesLeft;
	}

	@Override
	public void validate() {
		if (numberOfPassegesLeft < 1) {
			String message = "No more passeges left!";
			throw new IllegalStateException(message);
		} else {
			numberOfPassegesLeft--;
		}
	}
}
