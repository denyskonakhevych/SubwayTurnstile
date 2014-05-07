package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pass.AccumulativePass;
import pass.Pass;
import pass.PassType;
import pass.passfactories.AbstractPassFactory;
import pass.passfactories.AccumulativePassFactory;
import pass.passfactories.NumberOfPassagesPassFactory;
import server.Server;
import tourniquet.Tourniquet;

public class ServerTest {

	private static final int NIMBER_OF_TOURNIQUETS = 3;
	private Server server;
	
	@Before
	public void setUp() throws Exception {
		server = new Server(NIMBER_OF_TOURNIQUETS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailToCreateServerWithIllegalsNumberOfTourniquets() {
		server = new Server(0);
	}

	@Test
	public void testNumberOfCreatedTourniquets() {
		assertEquals(NIMBER_OF_TOURNIQUETS, server.tourniquets.size());
	}
	
	@Test
	public void testGlobalCountOfPassages() {
		final float RAISE = 50.0f;
		
		AbstractPassFactory apf = new AccumulativePassFactory();
		Pass pass = apf.getPass();
		Tourniquet tourniquet = server.tourniquets.get(0);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		
		AccumulativePass accPass = (AccumulativePass) pass;
		accPass.increaseBalance(RAISE);
		tourniquet.checkPass(accPass);
		tourniquet.checkPass(accPass);
		
		tourniquet = server.tourniquets.get(1);
		apf = new NumberOfPassagesPassFactory(PassType.PASSAGES_20);
		pass = apf.getPass();
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		
		assertEquals(9, server.getPassagesNumber());
		assertEquals(5, server.getPassagesNumber(true));
		assertEquals(4, server.getPassagesNumber(false));
		assertEquals(2, server.getPassagesNumber(true, PassType.ACCUMULATIVE));
		assertEquals(4, server.getPassagesNumber(false, PassType.ACCUMULATIVE));
		assertEquals(3, server.getPassagesNumber(true, PassType.PASSAGES_20));
		assertEquals(0, server.getPassagesNumber(false, PassType.PASSAGES_20));
	}

}
