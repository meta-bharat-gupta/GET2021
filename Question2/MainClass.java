package Question2;

import static java.lang.System.out;
public class MainClass {
	public static void main(String[] args) {
		int[][] processArray = {{0,10}, {6,20},{60,10},{110,5}};
		
		int[] completionTime = FCFS.getCompletionTime(processArray);
		out.println("Completion Time for every process :-");
		for(int i=0; i<completionTime.length; i++){
			System.out.print(completionTime[i]+" ");
		}
		
		int[] turnAroundTime = FCFS.getTurnAroundTime(processArray);
		out.println("\nTurn Around Time for every process :-");
		for(int i=0; i<turnAroundTime.length; i++){
			System.out.print(turnAroundTime[i]+" ");
		}
		
		int[] waitingTime = FCFS.getWaitingTime(processArray);
		out.println("\nWaiting Time for every process :-");
		for(int i=0; i<waitingTime.length; i++){
			System.out.print(waitingTime[i]+" ");
		}
		out.println("\nAverage Waiting Time  = ");
		out.println(FCFS.getAverageWaitingTime(processArray));
		
		out.println("Maximum Waiting Time = ");
		out.println(FCFS.getMaxWaitingTime(processArray));
	}
}
