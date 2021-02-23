package Question2;

public class MainClass {
	public static void main(String[] args) {
		int[][] processArray = {{0,10}, {6,20},{60,10},{110,5}};
		
		int[] completionTime = FCFS.getCompletionTime(processArray);
		System.out.println("Completion Time for every process :-");
		for(int i=0; i<completionTime.length; i++){
			System.out.print(completionTime[i]+" ");
		}
		
		int[] turnAroundTime = FCFS.getTurnAroundTime(processArray);
		System.out.println("\nTurn Around Time for every process :-");
		for(int i=0; i<turnAroundTime.length; i++){
			System.out.print(turnAroundTime[i]+" ");
		}
		
		int[] waitingTime = FCFS.getWaitingTime(processArray);
		System.out.println("\nWaiting Time for every process :-");
		for(int i=0; i<waitingTime.length; i++){
			System.out.print(waitingTime[i]+" ");
		}
		System.out.println("\nAverage Waiting Time  = ");
		System.out.println(FCFS.getAverageWaitingTime(processArray));
		
		System.out.println("Maximum Waiting Time = ");
		System.out.println(FCFS.getMaxWaitingTime(processArray));
	}
}
