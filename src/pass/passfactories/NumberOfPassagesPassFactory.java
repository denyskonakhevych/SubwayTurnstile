package pass.passfactories;

import pass.passtype.NumberOfPassagesPassType;
import pass.type.NumberOfPassagesPass;
import pass.type.Pass;

public class NumberOfPassagesPassFactory extends AbstractPassFactory {

	private NumberOfPassagesPassType type;
	
	public NumberOfPassagesPassFactory(NumberOfPassagesPassType type) {
		if (type == null || !type.toString().toLowerCase().contains("PASSAGES".toLowerCase())) {
			throw new NullPointerException("Wrong pass type: " + type);
		}
		this.type = type;
	}
	
	@Override
	public Pass getPass() {
		return new NumberOfPassagesPass(getId(), type);
	}
}
