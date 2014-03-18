package pass;

import java.util.Calendar;

import passages.DatePassage;
import passages.Passage;

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
	public void validate() throws IllegalAccessException {
		Calendar currentDate = Calendar.getInstance();
		
		if (currentDate.after(startDate) && currentDate.before(endDate)) {
			// NOP
		} else {
			// TODO: make SB
			String message = "Legal date is between " + startDate.getTime() + " and " + endDate.getTime() + " but it was: " + currentDate.getTime();
			throw new IllegalAccessException(message);
		}
	}
	
	@Override
	public Passage makePassage() {
		return new DatePassage(ID, TYPE, startDate, endDate);
	}

	@Override
	public String toString() {
		return super.toString() + " startDate: " + startDate.getTime() + " endDate: " + endDate.getTime();
	}
}
