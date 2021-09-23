import Execution.Run;
import Output.PrintStatistics;
import Output.Statistics;

public class Main {

	public static final int HOW_MANY_RUNS = 100000;

	public static void main (String[] args){

		int deadHobbits = 0;
		Statistics stats = new Statistics();
		while(deadHobbits < HOW_MANY_RUNS) {
			Run runner = new Run();
			runner.executeRun();
			runner.printRun();
			deadHobbits++;
			stats.addRunToSample(runner);
		}
		stats.generateStatistics();
		PrintStatistics.printStatistics(stats);
	}
}
