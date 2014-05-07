package pass.date.strategies;

import java.util.Calendar;

import pass.passtype.PassType;
import pass.passtype.TermPassType;
import pass.type.DatePass;
import pass.type.Pass;

public class NDaysStrategy extends DateStrategy {
	
	private PassType type;
	
	public NDaysStrategy(int year, int month, int day, TermPassType type) {
		if (type == null || !type.toString().toLowerCase().contains("DAYS".toLowerCase())) {
			throw new NullPointerException("Wrong pass type: " + type);
		}
		this.type = type;
		startDate = Calendar.getInstance();
		startDate.set(year, month, day, 0, 0, 0);
		endDate = (Calendar) startDate.clone();
		endDate.set(Calendar.DATE, endDate.get(Calendar.DATE) + type.getValue());
		endDate.set(Calendar.SECOND, endDate.get(Calendar.SECOND) - 1);
	}

	@Override
	public Pass makePass(int id) {
		return new DatePass(id, type, startDate, endDate);
	}
}
