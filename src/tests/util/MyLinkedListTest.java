package tests.util;

import static org.junit.Assert.*;
import myutil.MyLinkedList;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {

	private MyLinkedList<Integer> myLinkedList;
	
	@Before
	public void initMyLinkedList(){
		myLinkedList = new MyLinkedList<>();
	}
	
	@Test
	public void testAdd() {
		myLinkedList.add(0);
		assertEquals(myLinkedList.size(), 1);
	}
	
	@Test
	public void testAddSeveral() {
		myLinkedList.add(1);
		myLinkedList.add(2);
		myLinkedList.add(3);
		assertEquals(myLinkedList.size(), 3);
	}
	
	@Test
	public void testAddNull() {
		Integer i = null;
		myLinkedList.add(i);
		assertNull(myLinkedList.get(0));
	}
	
	@Test
	public void testAddCollection() {
		
		myLinkedList.add(0);
		myLinkedList.add(1);
		myLinkedList.add(2);
		MyLinkedList<Integer> mll = new MyLinkedList<>();
		mll.add(3);
		mll.add(4);
		myLinkedList.add(mll);
		assertEquals(myLinkedList.size(), 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNullCollection() {
		MyLinkedList<Integer> mll = null;
		myLinkedList.add(mll);
	}
	
	@Test
	public void testAddByPossitionToTheBeginning() {
		myLinkedList.add(0);
		myLinkedList.add(0, 1);
		assertEquals(myLinkedList.get(0), new Integer(1));
	}
	
	@Test
	public void testAddByPossition() {
		myLinkedList.add(0);
		myLinkedList.add(2);
		myLinkedList.add(1, 1);
		assertEquals(myLinkedList.get(1), new Integer(1));
	}
	
	@Test
	public void testAddByPossitionWithZeroLength() {
		myLinkedList.add(0, 1);
		assertEquals(myLinkedList.get(0), new Integer(1));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddByPossitionIllegalIndex() {
		myLinkedList.add(1, 1);
	}
	
	@Test
	public void testGet() {
		myLinkedList.add(0);
		myLinkedList.add(1);
		myLinkedList.add(2);
		assertEquals(myLinkedList.get(1), new Integer(1));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetNotExisting() {
		myLinkedList.add(0);
		myLinkedList.add(1);
		myLinkedList.get(3);
	}
	
	@Test
	public void testRemoveByPossition() {
		myLinkedList.add(0);
		myLinkedList.add(1);
		myLinkedList.add(2);
		myLinkedList.remove(1);
		assertEquals(myLinkedList.get(1), new Integer(2));
	}
	
	@Test
	public void testRemoveByValue() {
		myLinkedList.add(1);
		myLinkedList.add(2);
		myLinkedList.add(3);
		myLinkedList.remove(new Integer(2));
		assertNotEquals(myLinkedList.get(1), new Integer(2));
	}
	
	@Test
	public void testRemoveLast() {
		myLinkedList.add(0);
		myLinkedList.add(1);
		myLinkedList.remove(1);
		myLinkedList.remove(0);
		assertEquals(myLinkedList.size(), 0);
	}
	
	@Test
	public void testRemoveNullByIndex() {
		myLinkedList.add(0);
		Integer i = null;
		myLinkedList.add(i);
		myLinkedList.add(2);
		myLinkedList.remove(1);
		assertNotNull(myLinkedList.get(1));
	}
	
	@Test
	public void testRemoveNullByValue() {
		myLinkedList.add(0);
		Integer i = null;
		myLinkedList.add(i);
		myLinkedList.add(2);
		myLinkedList.remove(null);
		assertNotNull(myLinkedList.get(1));
	}

	@Test
	public void testRemoveByObjectAll() {
		myLinkedList.add(0);
		myLinkedList.add(1);
		myLinkedList.add(1);
		myLinkedList.add(1);
		myLinkedList.add(1);
		myLinkedList.add(2);
		while(myLinkedList.remove(new Integer(1)));
		assertEquals(myLinkedList.size(), 2);
	}
	
	@Test
	public void testSet() {
		myLinkedList.add(0);
		myLinkedList.add(1);
		myLinkedList.add(2);
		myLinkedList.set(1, 3);
		assertEquals(myLinkedList.get(1), new Integer(3));
	}
}
