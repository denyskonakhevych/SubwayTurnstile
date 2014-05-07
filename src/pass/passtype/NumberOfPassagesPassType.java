package pass.passtype;

public enum NumberOfPassagesPassType implements PassType {

	PASSAGES_20(20),
	PASSAGES_40(40);
	
	private int value;
	
	NumberOfPassagesPassType(int value) {
		if(value > 0) {
			this.value = value;
		}
	}
	
	public int getValue() {
		return value;
	}
}
