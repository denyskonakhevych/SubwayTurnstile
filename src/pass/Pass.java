package pass;

public abstract class Pass {

	private int passageCount;
	
	private final int id;
	
	private final PassType type;
	
	Pass(int id, PassType type) {
		this.id = id;
		this.type = type;
	}
	
	public final PassType getPassType() {
		return type;
	}
	
	public final int getPassId() {
		return id;
	}
	
	public void grantPassage() throws IllegalAccessException {
		validate();
		passageCount++;
	}
	
	public abstract void validate() throws IllegalAccessException;
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Pass that = (Pass) obj;
		if (type != that.type) {
			return false;
		}
		if (id != that.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ID: " + id + " TYPE: " + type + " PASSAGES DONE: " + passageCount;
	}
}
