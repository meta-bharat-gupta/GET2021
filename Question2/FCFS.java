package Question2;

public class FCFS {
	
//	This function returns the completion time array.
	public static int[] getCompletionTime(int[][] process){
		int processCount = process.length;
		int [] completionTimeArr = new int[processCount];
		for(int i=0; i<processCount; i++){
			if(i==0){
				completionTimeArr[i]=process[i][1];
			}else{
				if(process[i][0]<completionTimeArr[i-1]){
					completionTimeArr[i]=process[i][1]+completionTimeArr[i-1];
				}else{
					completionTimeArr[i]=process[i][0]+process[i][1];
				}
			}
		}
		return completionTimeArr;
	}
	
	
//	This function is used to calculate TurnAround Time for every process and return an array.
	public static int[] getTurnAroundTime(int[][] process){
		int[] completionTimeArr = getCompletionTime(process);
		int[] turnAroundTimeArr = new int[completionTimeArr.length];
		for(int i=0; i<completionTimeArr.length; i++){
			turnAroundTimeArr[i]=completionTimeArr[i]-process[i][0];
		}
		return turnAroundTimeArr;
	}
	
//	This function calculates waiting time for each process and returns the waitingTime array.
	public static int[] getWaitingTime(int[][] process){
		int[] turnAroundTimeArr = getTurnAroundTime(process);
		int[] waitingTimeArr = new int[turnAroundTimeArr.length];
		for(int i=0; i<turnAroundTimeArr.length; i++){
			if(turnAroundTimeArr[i]-process[i][1]<0){
				waitingTimeArr[i]=0;
			}else{
				waitingTimeArr[i]=turnAroundTimeArr[i]-process[i][1];
			}
		}
		return waitingTimeArr;
	}
	
//	This function returns the Average Waiting Time for all the process.
	public static double getAverageWaitingTime(int[][] process){
		int[] waitingTimeArr = getWaitingTime(process);
		int totalWaitingTime = 0;
		for(int i=0; i<waitingTimeArr.length; i++){
			totalWaitingTime += waitingTimeArr[i];
		}
		return totalWaitingTime/waitingTimeArr.length;
	}
	
	
//	This function returns the Maximum Waiting Time.
	public static int getMaxWaitingTime(int[][] process){
		int[] waitingTimeArr = getWaitingTime(process);
		int maxWaitingTime = waitingTimeArr[0];
		for(int i=1; i<waitingTimeArr.length; i++){
			if(maxWaitingTime<waitingTimeArr[i]){
				maxWaitingTime = waitingTimeArr[i];
			}
		}
		return maxWaitingTime;
	}

}
