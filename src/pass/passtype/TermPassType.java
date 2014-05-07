package pass.passtype;

public enum TermPassType implements PassType {
	DAYS_5(5),
	DAYS_10(10),
	MONTH,
	MONTH_STUDENT,
	MONTH_PUPIL;
	
	private int value;
	
	TermPassType(Integer... value) {
		if(value != null && value.length > 0 && value[0] > 0) {
			this.value = value[0];
		}
	}
	
	public int getValue() {
		return value;
	}
}
