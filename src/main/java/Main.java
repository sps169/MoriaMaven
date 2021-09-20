public class Main {

	public static final int HOW_MANY_RUNS = 1000;

	public static void main (String[] args){

		int deadHobbits = 0;
		while(deadHobbits < HOW_MANY_RUNS) {
			Run runner = new Run();
			runner.executeRun();
			runner.printRun();
			deadHobbits++;
		}
	}
}
