import java.util.Random;
/**
 * Skeleton Code for task 2
 */
public class SimpleGrader implements Runnable
{

	private static int SEED = 2430;
	private static Object Obj = new Object();

 	/* Do not change the code between this comment... */
	public static int[] correctAnswers = generateCorrectAnswers();                 //note that this variable is static
	public static int[][] studentAnswers = generateStudentAnswers(correctAnswers); //note that this variable is static
	/* ...and this comment */
 
 
	/* add or edit necessary variables here*/
	public static int grade = 0;
	public int quesNum;
	
	
	// Implement the constructor with necessary parameters
	/* Hint: When we create threads in main method, each thread only grades its assigned question
	 * Therefore, the user should be able to specify the index of the question being graded and we need a variable to store that index. That's it.
     */
	public SimpleGrader(int qNum)
	{
    	quesNum = qNum;
    }
	
	
	@Override
	/**
	 * run() method will be called when a thread starts.
	 * in this case, the grading (changing the grade variable) should be done here
	 */
	public void run()
	{
		// Acquire the correct answer from correctAnswers, and grade each student's answer to that question accordingly.
     	synchronized (Obj)
		{
			for (int j = 0; j < 1000; j++)
			{
				if(studentAnswers[quesNum][j] == 0) ;
				else if (studentAnswers[quesNum][j] == correctAnswers[quesNum]) grade += 10;
				else grade -= 3;
			}
		}
	}
	
	public static void main(String[] args)
	{
		// Create ten threads, each responsible for one question (tip: make an array of threads could save you lots of work)
		/* As the class implements Runnable instead of extends Thread, here is an example line of creating a thread:
		 * Thread t = new Thread(new SimpleGrader(...)); //the arguments should be corresponding to your constructor
         */

		Thread	t0 = new Thread(new SimpleGrader(0));
		Thread	t1 = new Thread(new SimpleGrader(1));
		Thread	t2 = new Thread(new SimpleGrader(2));
		Thread	t3 = new Thread(new SimpleGrader(3));
		Thread	t4 = new Thread(new SimpleGrader(4));
		Thread	t5 = new Thread(new SimpleGrader(5));
		Thread	t6 = new Thread(new SimpleGrader(6));
		Thread	t7 = new Thread(new SimpleGrader(7));
		Thread	t8 = new Thread(new SimpleGrader(8));
		Thread	t9 = new Thread(new SimpleGrader(9));

		// Start all threads created
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();

		// Wait for all threads to finish. If there is an InterruptedException, print out "Oops!"
		try
		{
			t0.join();
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
			t8.join();
			t9.join();
		}
		catch (InterruptedException e)
		{
			System.out.println("Oops!");
		}

		// Determines the average for the test; you can make changes if necessary
		double average = grade / 1000.0;
		System.out.printf("The average score is %.3f\n", average);
	}
	
	/* Do not change lines below */
	public static int[] generateCorrectAnswers(){
		int[] answers = new int[10];
		Random r = new Random(SEED);
		for(int i = 0; i < answers.length; i ++){
			answers[i] = r.nextInt(4) + 1;
		}
		return answers;
	}
	
	public static int[][] generateStudentAnswers(int[] answers){
		int[][] response = new int[10][1000];
		Random r = new Random(SEED);
		for(int i = 0; i < response.length; i ++){
			int answer = answers[i];
			for(int j = 0; j < response[i].length; j++){
				if(r.nextInt(10) < 7){
					response[i][j] = answer;
				}else if(r.nextBoolean()){
					response[i][j] = 0;
				}else{
					response[i][j] = r.nextInt(4) + 1;
				}
			}
		}
		return response;
	}
}
