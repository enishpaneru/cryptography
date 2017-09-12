import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
public class Entry {
	public static void main(String[] args){
		Result result=new Result();
		result=JUnitCore.runClasses(RCfourTest.class);
	    for (Failure failure : result.getFailures()) {
	       System.out.println(failure.toString());
	       }
	 		
	    System.out.println("Result for RCfourTest "+result.wasSuccessful());
	}

}
