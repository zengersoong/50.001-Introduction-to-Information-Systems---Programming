package Pset3A;
import junit.framework.*;
import junit.framework.Test;

public class TestFindX extends TestCase {

    // constructor
    public TestFindX (String name) {
        super(name);
    }


   







    @org.junit.Test
    public void testCountingVisits() {
    	 FindX f = new FindX();
    	 int[] a = {4,5,6};
    	 assertEquals("Failed Assertion for FindX", 0, f.findX(4,a));
 	    assertEquals("Failed Assertion for FindX", 1, f.findX(5,a));
 	    assertEquals("Failed Assertion for FindX", 2, f.findX(6,a));
 	    assertEquals("Failed Assertion for FindX", -1, f.findX(9,a));
    }
    	 






    // method create a test suite
    public static Test suite() {
        return new TestSuite(TestFindX.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
