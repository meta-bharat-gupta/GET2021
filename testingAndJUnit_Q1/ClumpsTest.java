package testingAndJUnit_Q1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


// Parameterized JUnit Test Class
@RunWith(Parameterized.class)
public class ClumpsTest {
	private int[] passed;
	private int expected;
	public ClumpsTest(int[] input, int output) {
		this.expected = output;
		this.passed = input;
	}

	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{new int[]{1,2,1,1}, 1}, 
        		{new int[]{1,1,1,1}, 1},
        		{new int[]{1, 2, 2, 3, 4, 4}, 2}
           });
    }
    
    @Test
    public void testCase(){
    	assertEquals(expected, ArrOperation.numberOfClumps(passed));
    }
    
    
}
