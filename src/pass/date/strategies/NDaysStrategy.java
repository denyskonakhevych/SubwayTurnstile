package pass.date.strategies;

import java.util.Calendar;

import pass.DatePass;
import pass.Pass;
import pass.PassType;

public class NDaysStrategy extends DateStrategy {
	
	private PassType type;
	
	public NDaysStrategy(int year, int month, int day, PassType type) {
		if (type == null || !type.toString().toLowerCase().contains("DAYS".toLowerCase())) {
			throw new IllegalArgumentException("Wrong pass type: " + type);
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
