package pass.passfactories;

import pass.Pass;
import pass.PassType;
import pass.NumberOfPassagesPass;

public class NumberOfPassagesPassFactory extends AbstractPassFactory {

	private PassType type;
	
	public NumberOfPassagesPassFactory(PassType type) {
		if (type == null || !type.toString().toLowerCase().contains("PASSAGES".toLowerCase())) {
			throw new IllegalArgumentException("Wrong pass type: " + type);
		}
		this.type = type;
	}
	
	@Override
	public Pass getPass() {
		return new NumberOfPassagesPass(getId(), type);
	}
}
