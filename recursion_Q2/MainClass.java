package recursion_Q2;
import static java.lang.System.out;
public class MainClass {
	public static void main(String[] args) {
		int[] array = new int[]{42,312,6423,64,23,6,3,2,0};
		out.println(Search.linearSearch(array, 6423));
		
		int[] array2 = new int[]{23, 45, 67, 89, 102, 345, 431, 555};
		out.println(Search.binarySearch(array2, 345));
		
	}
}
