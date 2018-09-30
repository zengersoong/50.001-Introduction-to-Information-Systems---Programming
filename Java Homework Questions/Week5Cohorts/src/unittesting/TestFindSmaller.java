package unittesting;

/**
 * Created by jit_biswas on 10/8/2017.
 */
import junit.framework.*;
import junit.framework.Test;

import org.junit.*;

public class TestFindSmaller extends TestCase {

    // constructor
    public TestFindSmaller (String name) {
        super(name);// javaframework will take the name from your testcases to Junit..
        
    }

    @org.junit.Test
    public void testFindingSmaller () {
     FindSmaller f = new FindSmaller();
     int[] a = { 1,2,7,6,2};
     assertEquals("Failed Assertion for findx", 3, f.findSmaller(4, a));
     assertEquals("Failed Assertion for findx", 3, f.findSmaller(8, a));
     assertEquals("Failed Assertion for findx", 3, f.findSmaller(-1, a));
    }

    // method create a test suite
    public static Test suite() {
        return new TestSuite(TestFindSmaller.class);
        // MAKE SURE IT RUNS THE NAME OF THE CURRENT CLASS.
        
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}

