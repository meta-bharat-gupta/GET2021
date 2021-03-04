package testingAndJUnit_Q1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


//Parameterized JUnit Test Class
@RunWith(Parameterized.class)
public class SplitArrayTest {

	private int[] actual;
	private int expected;
	public SplitArrayTest(int[] input, int output) {
		this.expected = output;
		this.actual = input;
	}

	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{new int[]{2, 1, 1, 2, 1}, -1}, 
        		{new int[]{1, 1, 1, 2, 1}, 3},
        		{new int[]{10, 10}, 1},
        		{new int[]{10, 5, 5, 5,5}, 2}
           });
    }
    
    @Test
    public void testCase(){
    	assertEquals(expected, ArrOperation.splitArray(actual));
    }

}
