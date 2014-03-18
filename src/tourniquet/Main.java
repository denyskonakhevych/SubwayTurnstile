package tourniquet;

import java.util.Calendar;

import pass.AccumulativePass;
import pass.Pass;
import pass.PassType;
import pass.date.strategies.DateStrategy;
import pass.date.strategies.MonthStrategy;
import pass.date.strategies.NDaysStrategy;
import pass.passfactories.AbstractPassFactory;
import pass.passfactories.AccumulativePassFactory;
import pass.passfactories.DatePassFactory;
import pass.passfactories.NumberOfPassagesPassFactory;
import server.Server;

public class Main {

	/*
	public static void main(String[] args) {
		DateStrategy dateStrategyMonth = new MonthStrategy(2014, Calendar.MARCH, PassType.MONTH_STUDENT);
		AbstractPassFactory mpf = new DatePassFactory(dateStrategyMonth);
		Pass mp = mpf.getPass();
		
		DateStrategy dateStrategyNDays = new NDaysStrategy(2014, Calendar.MARCH, 15, PassType.DAYS_5);
		AbstractPassFactory ndaf = new DatePassFactory(dateStrategyNDays);
		Pass ndp = ndaf.getPass();
		
		AbstractPassFactory apf = new AccumulativePassFactory(); 
		AccumulativePass ap = (AccumulativePass) apf.getPass();
		ap.increaseBalance(5);
		
		AbstractPassFactory noppf50 = new NumberOfPassagesPassFactory(PassType.PASSAGES_20);
		Pass nopp50 = noppf50.getPass();
		
		AbstractPassFactory noppf100 = new NumberOfPassagesPassFactory(PassType.PASSAGES_40);
		Pass nopp100 = noppf100.getPass();
		
		Server server = new Server(10);
		
		Tourniquet tourniquet = server.tourniquets.get(0);
		//tourniquet.checkPass(mp);
		//tourniquet.checkPass(ndp);
		tourniquet.checkPass(mp);
		tourniquet.checkPass(ndp);
		
		tourniquet.checkPass(ap);
		//tourniquet.checkPass(nopp50);
		//tourniquet.checkPass(nopp100);
	}

	private static void test1() {
		//   MONTH
		
		Calendar startDate = Calendar.getInstance();
		startDate.set(2014, Calendar.MARCH, 1, 0, 0, 0);
		Calendar endDate = Calendar.getInstance();
		endDate.set(startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.getMaximum(Calendar.DATE), 23, 59, 59);
		
		//   N days
		
		int days = 10;
		Calendar startDate = Calendar.getInstance();
		startDate.set(2014, Calendar.MARCH, 1, 0, 0, 0);
		Calendar endDate = (Calendar) startDate.clone();
		endDate.set(Calendar.DATE, endDate.get(Calendar.DATE) + days);
		endDate.set(Calendar.SECOND, endDate.get(Calendar.SECOND) - 1);
		
		
		Calendar currentDate = Calendar.getInstance();
		
		System.out.println("  start - " + startDate.getTime());
		System.out.println("  end   - " + endDate.getTime());
		
		System.out.println("current - " + currentDate.getTime());
		
		System.out.println(currentDate.before(endDate));
		System.out.println(currentDate.after(startDate));
		//StudentPass sp = new StudentPass();
	}
*/
}
