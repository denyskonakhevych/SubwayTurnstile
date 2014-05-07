package pass.type;

<<<<<<< HEAD:src/pass/type/Pass.java
import pass.passtype.PassType;

=======
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae:src/pass/Pass.java
public abstract class Pass {

	private int passageCount;
	
	private final int id;
	
	private final PassType type;
	
	Pass(int id, PassType type) {
		this.id = id;
		this.type = type;
<<<<<<< HEAD:src/pass/type/Pass.java
=======
	}
	
	public final PassType getPassType() {
		return type;
	}
	
	public final int getPassId() {
		return id;
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae:src/pass/Pass.java
	}
	
	public PassType getPassType() {
		return type;
	}
	
	public final int getPassId() {
		return id;
	}
	
	public void grantPassage() {
		validate();
		passageCount++;
	}
	
<<<<<<< HEAD:src/pass/type/Pass.java
	public abstract void validate();
=======
	public abstract void validate() throws IllegalAccessException;
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae:src/pass/Pass.java
	
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
