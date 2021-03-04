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
public class FixXYTest {

	private int[] actual;
	private int[] expected;
	private int xValue;
	private int yValue;
	public FixXYTest(int[] input, int[] output, int x, int y) {
		this.expected = output;
		this.actual = input;
		this.xValue = x;
		this.yValue = y;
	}

	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
        		{new int[]{5, 4, 9, 4, 9, 5}, new int[]{9, 4, 5, 4, 5, 9}, 4, 5}, 
        		{new int[]{1, 4, 1, 5}, new int[]{1, 4, 5, 1}, 4, 5},
        		{new int[]{1, 4, 1, 5, 5, 4, 1}, new int[]{1, 4, 5, 1, 1, 4, 5}, 4, 5},
        		{new int[]{5, 4, 1, 5, 5, 4, 5, 4, 1, 4, 6}, new int[]{1, 4, 5, 1, 6, 4, 5, 4, 5, 4, 5}, 4, 5}
           });
    }
    
    @Test
    public void testCase(){
    	assertArrayEquals(expected, ArrOperation.fixXY(actual, xValue, yValue));
    }
    

}
