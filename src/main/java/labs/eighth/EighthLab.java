package labs.eighth;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class EighthLab {

  // The run method to initiate the functionality
  public static void run() {
    System.out.println("Welcome to Eighth Lab: Parallel Sum Calculation using ForkJoin!");

    // Initialize the array with 1,000,000 random integers between 0 and 100
    int[] array = new int[1_000_000];
    Random random = new Random();
    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt(101);  // Generates values between 0 and 100
    }

    // Create ForkJoinPool and submit the task
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    ArraySumTask task = new ArraySumTask(array, 0, array.length);

    // Invoke the task and get the result
    long sum = forkJoinPool.invoke(task);

    System.out.println("The sum of all array elements is: " + sum);
  }
}
