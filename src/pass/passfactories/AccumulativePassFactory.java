package pass.passfactories;

import pass.AccumulativePass;
import pass.Pass;

public class AccumulativePassFactory extends AbstractPassFactory {

	@Override
	public Pass getPass() {
		return new AccumulativePass(getId(), 0, 2.5f);
	}
}
