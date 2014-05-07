package tests.tourniquet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import pass.type.AccumulativePass;
import pass.type.DatePass;
import pass.type.NumberOfPassagesPass;
import pass.type.Pass;
import server.Server;
import tourniquet.Tourniquet;

public class TourniquetTest {

	private Tourniquet tourniquet;
	
	@Before
	public void setUp() throws Exception {
		Server server = new Server(1);
		tourniquet = server.getTourniquet(0);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCheckPassNull() {
		tourniquet.checkPass(null);
	}
	
	@Test
	public void testCheckDatePassOk() {
		Pass pass = mock(DatePass.class);
		assertTrue(tourniquet.checkPass(pass));
	}
	
	@Test
	public void testCheckNumberOfPassagesPassOk() {
		Pass pass = mock(NumberOfPassagesPass.class);
		assertTrue(tourniquet.checkPass(pass));
	}
	
	@Test
	public void testCheckAccumulativePassOk() {
		AccumulativePass pass = mock(AccumulativePass.class);
		assertTrue(tourniquet.checkPass(pass));
	}
	
	@Test
	public void testCheckDatePassExpiredFailsValidation() {
		Pass pass = mock(DatePass.class);
		doThrow(new IllegalStateException()).when(pass).grantPassage();
		assertFalse(tourniquet.checkPass(pass));
	}
	
	@Test
	public void testCheckNumberOfPassagesPassFailsValidation() {
		Pass pass = mock(NumberOfPassagesPass.class);
		doThrow(new IllegalStateException()).when(pass).grantPassage();
		assertFalse(tourniquet.checkPass(pass));
	}
	
	@Test
	public void testCheckAccumulativePassWithNotEnoughBalanceFailsValidation() {
		Pass pass = mock(AccumulativePass.class);
		doThrow(new IllegalStateException()).when(pass).grantPassage();
		assertFalse(tourniquet.checkPass(pass));
	}
}
