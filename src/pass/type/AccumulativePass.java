package pass.type;

<<<<<<< HEAD:src/pass/type/AccumulativePass.java
import pass.passtype.RegularPassType;

=======
>>>>>>> 2706a1564073d7a7c569705333c2b6aa87a18bae:src/pass/AccumulativePass.java
public class AccumulativePass extends Pass {

	private float balance;
	
	private float pricePerPassage;
	
	public AccumulativePass(int id, float balance, float pricePerPassage) {
		super(id, RegularPassType.ACCUMULATIVE);
		this.balance = balance;
		this.pricePerPassage = pricePerPassage;
	}
	
	public void setPrice(float pricePerPassage) {
		if (pricePerPassage > 0) {
			this.pricePerPassage = pricePerPassage;
		} else {
			throw new IllegalArgumentException("Price value error, must be more 0, but was: " + pricePerPassage);
		}
	}
	
	public float getPrice() {
		return pricePerPassage;
	}
	
	public void increaseBalance(float raise) {
		if (raise > 0) {
			balance += raise;
		} else {
			throw new IllegalArgumentException("Raise value error, must be more 0, but was: " + raise);
		}
	}
	
	public float getBalance() {
		return balance;
	}

	@Override
	public void validate() {
		if ((balance - pricePerPassage) < 0) {
			String message = "Sorry, but there is not enough money on your balance for passage. Current balance: " + balance + " and price for trip is: " + pricePerPassage;
			throw new IllegalStateException(message);
		} else {
			balance -= pricePerPassage;
		}
	}

	@Override
	public String toString() {
		return super.toString() + " BALANCE LEFT: " + balance;
	}
}
