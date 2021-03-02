package Question2;

public class FCFS {
	
	/**
	 * This function calculate the completion time for every process.
	 * @param process 2D array of processes with arrival time and burst time in sorted order of arrival time.
	 * @return completionTimeArr an array with completion time of each process.
	 */
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
	
	
	/**
	 * This function calculate the Turn Around time for each process.
	 * @param process  2D array of processes with arrival time and burst time in sorted order of arrival time.
	 * @return turnAroundTimeArr  1D array with turn around timings for each process.
	 */
	public static int[] getTurnAroundTime(int[][] process){
		int[] completionTimeArr = getCompletionTime(process);
		int[] turnAroundTimeArr = new int[completionTimeArr.length];
		for(int i=0; i<completionTimeArr.length; i++){
			turnAroundTimeArr[i]=completionTimeArr[i]-process[i][0];
		}
		return turnAroundTimeArr;
	}
	
	
	/**
	 * This function calculates the waiting time for each process.
	 * @param process 2D array of processes with arrival time and burst time in sorted order of arrival time.
	 * @return waitingTimeArr 1D array with waiting time of every process.
	 */
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
	
	
	/**
	 * Calculates the average waiting time.
	 * @param process 2D array of processes with arrival time and burst time in sorted order of arrival time.
	 * @return a double value equivalent to average waiting time for all the processes.
	 */
	public static double getAverageWaitingTime(int[][] process){
		int[] waitingTimeArr = getWaitingTime(process);
		int totalWaitingTime = 0;
		for(int i=0; i<waitingTimeArr.length; i++){
			totalWaitingTime += waitingTimeArr[i];
		}
		return totalWaitingTime/waitingTimeArr.length;
	}
	
	
	/**
	 * To fetch maximum waiting time for given processes.
	 * @param process 2D array of processes with arrival time and burst time in sorted order of arrival time.
	 * @return integer which gives the maximum waiting time for a process in the queue.
	 */
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
