package pass;

public class NumberOfPassagesPass extends Pass {

	private int numberOfPassegesLeft;
	
	public NumberOfPassagesPass(int id, PassType passType) {
		super(id, passType);
		this.numberOfPassegesLeft = passType.getValue();
	}
	
	public int getNumberOfPasseges() {
		return numberOfPassegesLeft;
	}

	@Override
	public void validate() throws IllegalAccessException {
		if (numberOfPassegesLeft < 1) {
			String message = "No more passeges left!";
			throw new IllegalAccessException(message);
		} else {
			numberOfPassegesLeft--;
		}
	}
}
