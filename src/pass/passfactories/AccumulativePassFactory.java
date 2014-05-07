package pass.passfactories;

import pass.type.AccumulativePass;
import pass.type.Pass;

public class AccumulativePassFactory extends AbstractPassFactory {

	@Override
	public Pass getPass() {
		return new AccumulativePass(getId(), 0, 2.5f);
	}
}
