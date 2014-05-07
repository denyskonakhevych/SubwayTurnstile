package pass.passfactories;

import pass.date.strategies.DateStrategy;
import pass.type.Pass;

public class DatePassFactory extends AbstractPassFactory {

	private DateStrategy dateStrategy;
	
	public DatePassFactory(DateStrategy dateStrategy) {
		if (dateStrategy != null) {
			this.dateStrategy = dateStrategy;
		} else {
			throw new NullPointerException("Pass type argument exception: " + dateStrategy);
		}
	}

	@Override
	public Pass getPass() {
		return dateStrategy.makePass(getId());
	}
}