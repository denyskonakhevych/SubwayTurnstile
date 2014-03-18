package pass;

public enum PassType {

	MONTH_STUDENT,
	MONTH_PUPIL,
	PASSAGES_20(20),
	PASSAGES_40(40),
	DAYS_5(5),
	DAYS_10(10),
	ACCUMULATIVE;
	
	private int value;
	
	PassType(Integer... value) {
		if(value != null && value.length > 0) {
			this.value = value[0];
		}
	}
	
	public int getValue() {
		return value;
	}
}
