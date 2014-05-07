package pass.type;

import java.util.Calendar;

<<<<<<< HEAD:src/pass/type/DatePass.java
<<<<<<< HEAD:src/pass/type/DatePass.java
import pass.passtype.PassType;

=======
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae:src/pass/DatePass.java
=======
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae:src/pass/DatePass.java
public class DatePass extends Pass {

	protected final Calendar startDate;
	protected final Calendar endDate;
	
	public DatePass(int id, PassType type, Calendar startDate, Calendar endDate) {
		super(id, type);
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Calendar getStartDate() {
		return startDate;
	}
	
	public Calendar getEndDate() {
		return endDate;
	}
	
	@Override
	public void validate() {
		Calendar currentDate = Calendar.getInstance();
		
		if (currentDate.after(startDate) && currentDate.before(endDate)) {
			// NOP
		} else {
			String message = "Legal date is between " + startDate.getTime() + " and " + endDate.getTime() + " but it was: " + currentDate.getTime();
			throw new IllegalStateException(message);
		}
	}
<<<<<<< HEAD:src/pass/type/DatePass.java
<<<<<<< HEAD:src/pass/type/DatePass.java
=======
=======
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae:src/pass/DatePass.java
	/*
	@Override
	public Passage makePassage() {
		return new DatePassage(getPassId(), getPassType());
	}
	*/
<<<<<<< HEAD:src/pass/type/DatePass.java
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae:src/pass/DatePass.java
=======
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae:src/pass/DatePass.java

	@Override
	public String toString() {
		return super.toString() + " startDate: " + startDate.getTime() + " endDate: " + endDate.getTime();
	}
}
