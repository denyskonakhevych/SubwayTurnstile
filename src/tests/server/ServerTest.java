package tests.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import pass.passtype.NumberOfPassagesPassType;
import pass.passtype.RegularPassType;
import pass.type.AccumulativePass;
import pass.type.NumberOfPassagesPass;
import pass.type.Pass;
import server.Server;
import tourniquet.Tourniquet;

public class ServerTest {

	private static final int NUMBER_OF_TOURNIQUETS = 3;
	private Server server;
	
	@Before
	public void setUp() throws Exception {
		server = new Server(NUMBER_OF_TOURNIQUETS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFailToCreateServerWithIllegalsNumberOfTourniquets() {
		server = new Server(0);
	}

	@Test
	public void testNumberOfCreatedTourniquets() {
		assertEquals(NUMBER_OF_TOURNIQUETS, server.getNumberOfTourniquets());
	}
	
	@Test
	public void testGlobalCountOfPassages() {
		Pass pass = mock(AccumulativePass.class);
		doThrow(new IllegalStateException()).when(pass).grantPassage();
		when(pass.getPassType()).thenReturn(RegularPassType.ACCUMULATIVE);
		
		Tourniquet tourniquet = server.getTourniquet(0);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		
		AccumulativePass accPass = mock(AccumulativePass.class);
		when(accPass.getPassType()).thenReturn(RegularPassType.ACCUMULATIVE);
		tourniquet.checkPass(accPass);
		tourniquet.checkPass(accPass);
		
		tourniquet = server.getTourniquet(1);
		pass = mock(NumberOfPassagesPass.class);
		when(pass.getPassType()).thenReturn(NumberOfPassagesPassType.PASSAGES_20);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		
		assertEquals(9, server.getPassagesNumber());
		assertEquals(5, server.getPassagesNumber(true));
		assertEquals(4, server.getPassagesNumber(false));
		assertEquals(2, server.getPassagesNumber(true, RegularPassType.ACCUMULATIVE));
		assertEquals(4, server.getPassagesNumber(false, RegularPassType.ACCUMULATIVE));
		assertEquals(3, server.getPassagesNumber(true, NumberOfPassagesPassType.PASSAGES_20));
		assertEquals(0, server.getPassagesNumber(false, NumberOfPassagesPassType.PASSAGES_20));
	}

	@Test
	public void testTotalNumberOfPassages() {
		Pass pass = mock(AccumulativePass.class);
		Tourniquet tourniquet = server.getTourniquet(0);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		assertEquals(4, server.getPassagesNumber());
	}
	
	@Test
	public void testNumberOfPassagesByPassageSuccession() {
		Pass pass = mock(AccumulativePass.class);
		doThrow(new IllegalStateException()).when(pass).grantPassage();
		when(pass.getPassType()).thenReturn(RegularPassType.ACCUMULATIVE);
		Tourniquet tourniquet = server.getTourniquet(0);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		
		Pass accPass = mock(AccumulativePass.class);
		when(accPass.getPassType()).thenReturn(RegularPassType.ACCUMULATIVE);
		
		tourniquet.checkPass(accPass);
		tourniquet.checkPass(accPass);
		
		assertEquals(6, server.getPassagesNumber());
		assertEquals(4, server.getPassagesNumber(false));
		assertEquals(2, server.getPassagesNumber(true));
	}
	
	@Test
	public void testNumberOfPassagesByPassageSuccessionAndPassType() {
		Pass pass = mock(AccumulativePass.class);
		doThrow(new IllegalStateException()).when(pass).grantPassage();
		when(pass.getPassType()).thenReturn(RegularPassType.ACCUMULATIVE);
		Tourniquet tourniquet = server.getTourniquet(0);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		tourniquet.checkPass(pass);
		
		Pass accPass = mock(AccumulativePass.class);
		when(accPass.getPassType()).thenReturn(RegularPassType.ACCUMULATIVE);
		tourniquet.checkPass(accPass);
		tourniquet.checkPass(accPass);
		
		Pass numPass = mock(NumberOfPassagesPass.class);
		when(numPass.getPassType()).thenReturn(NumberOfPassagesPassType.PASSAGES_20);
		tourniquet.checkPass(numPass);
		tourniquet.checkPass(numPass);
		tourniquet.checkPass(numPass);
		
		assertEquals(9, server.getPassagesNumber());
		assertEquals(0, server.getPassagesNumber(false, NumberOfPassagesPassType.PASSAGES_20));
		assertEquals(3, server.getPassagesNumber(true, NumberOfPassagesPassType.PASSAGES_20));
	}
}
