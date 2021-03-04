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
public class LargestMirrorTest {

	private int[] actual;
	private int expected;
	public LargestMirrorTest(int[] input, int output) {
		this.expected = output;
		this.actual = input;
	}

	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3}, 
        		{new int[]{1, 2, 1, 4}, 3},
        		{new int[]{1, 4, 5, 3, 5, 4, 1}, 7},
        		{new int[]{7, 1, 4, 9, 7, 4, 1}, 2}
           });
    }
    
    @Test
    public void testCase(){
    	assertEquals(expected, ArrOperation.maxMirror(actual));
    }
    
}
