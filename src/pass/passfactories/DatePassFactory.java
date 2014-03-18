package pass.passfactories;

import pass.date.strategies.DateStrategy;
import pass.Pass;

public class DatePassFactory extends AbstractPassFactory {

	private DateStrategy dateStrategy;
	
	public DatePassFactory(DateStrategy dateStrategy) {
		if (dateStrategy != null) {
			this.dateStrategy = dateStrategy;
		} else {
			throw new IllegalArgumentException("Pass type argument exception: " + dateStrategy);
		}
	}

	@Override
	public Pass getPass() {
		return dateStrategy.makePass(getId());
	}
}