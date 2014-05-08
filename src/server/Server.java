package server;

import java.util.concurrent.locks.ReentrantLock;

import tourniquet.Tourniquet;

import myutil.MyLinkedList;
import pass.passtype.PassType;

public class Server {

	private MyLinkedList<Tourniquet> tourniquets = new MyLinkedList<>();
	private MyLinkedList<Passage> passages = new MyLinkedList<>();
	private final ReentrantLock lock = new ReentrantLock();

	public Server(int numberOfTourniquets) {
		if (numberOfTourniquets <= 0) {
			throw new IllegalArgumentException(
					"Illegal number of tourniquets: " + numberOfTourniquets);
		}
		for (int i = 0; i < numberOfTourniquets; i++) {
			tourniquets.add(new Tourniquet(this));
		}
	}

	public int getNumberOfTourniquets() {
		return tourniquets.size();
	}

	public Tourniquet getTourniquet(int index) {
		return tourniquets.get(0);
	}

	public void addPassage(int id, PassType passType, boolean passed,
			String message) {
		lock.lock();
		try {
			passages.add(new Passage(id, passType, passed, message));
		} finally {
			lock.unlock();
		}
	}

	public int getPassagesNumber() {
		return passages.size();
	}

	public int getPassagesNumber(boolean passed) {
		int count = 0;
		for (int i = 0; i < passages.size(); i++) {
			Passage passage = passages.get(i);
			if (passage.passed == passed) {
				count++;
			}
		}
		return count;
	}

	public int getPassagesNumber(boolean passed, PassType passType) {

		int count = 0;
		for (int i = 0; i < passages.size(); i++) {
			Passage passage = passages.get(i);
			if (passage.passed == passed && passage.passType.equals(passType)) {
				count++;
			}
		}
		return count;
	}

	private static class Passage {

		public final int id;
		public final PassType passType;
		public final boolean passed;
		public final String message;

		public Passage(int id, PassType passType, boolean passed, String message) {
			this.id = id;
			this.passType = passType;
			this.passed = passed;
			this.message = message;
		}

		@Override
		public String toString() {
			return "Passage [id=" + id + ", passType=" + passType + ", passed="
					+ passed + ", message=" + message + "]";
		}
	}
	/*
	 * public int getPassagesNumber() { int totalPassages = 0; for (int i = 0; i
	 * < tourniquets.size(); i++) { totalPassages +=
	 * tourniquets.get(i).getPassagesNumber(); } return totalPassages; }
	 * 
	 * public int getPassagesNumber(boolean passed) {
	 * 
	 * int totalPassages = 0; for (int i = 0; i < tourniquets.size(); i++) {
	 * totalPassages += tourniquets.get(i).getPassagesNumber(passed); } return
	 * totalPassages; }
	 * 
	 * public int getPassagesNumber(boolean passed, PassType passType) { int
	 * totalPassages = 0; for (int i = 0; i < tourniquets.size(); i++) {
	 * totalPassages += tourniquets.get(i).getPassagesNumber(passed, passType);
	 * } return totalPassages; }
	 */
}
