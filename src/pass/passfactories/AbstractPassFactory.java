package pass.passfactories;

import pass.Pass;


public abstract class AbstractPassFactory {

	private static volatile int id;
	
	protected int getId() {
		return id++;
	}
	
	public abstract Pass getPass();
}
