package pass;

import passages.Passage;

public abstract class Pass {

	private int passageCount;
	
	public final int ID;
	
	public final PassType TYPE;
	
	Pass(int id, PassType type) {
		this.ID = id;
		this.TYPE = type;
	}
	
	public void grantPassage() throws IllegalAccessException {
		validate();
		passageCount++;
	}
	
	public abstract void validate() throws IllegalAccessException;
	
	public abstract Passage makePassage();
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Pass that = (Pass) obj;
		if (TYPE != that.TYPE) {
			return false;
		}
		if (ID != that.ID) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ID: " + ID + " TYPE: " + TYPE + " PASSAGES DONE: " + passageCount;
	}
}
