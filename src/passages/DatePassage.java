package passages;

import java.util.Calendar;

import pass.PassType;

public class DatePassage extends Passage{

	public final Calendar startDate;
	public final Calendar endDate;
	
	public DatePassage(int id, PassType passType, Calendar startDate, Calendar endDate) {
		super(id, passType);
		this.startDate = startDate;
		this.endDate = endDate;
	}
}