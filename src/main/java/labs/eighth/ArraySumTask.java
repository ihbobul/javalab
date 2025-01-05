package labs.eighth;

import java.util.concurrent.RecursiveTask;

public class ArraySumTask extends RecursiveTask<Long> {

  private static final int THRESHOLD = 20;
  private final int[] array;
  private final int start;
  private final int end;

  public ArraySumTask(int[] array, int start, int end) {
    this.array = array;
    this.start = start;
    this.end = end;
  }

  @Override
  protected Long compute() {
    if (end - start <= THRESHOLD) {
      long sum = 0;
      for (int i = start; i < end; i++) {
        sum += array[i];
      }
      return sum;
    } else {
      int mid = (start + end) / 2;
      ArraySumTask leftTask = new ArraySumTask(array, start, mid);
      ArraySumTask rightTask = new ArraySumTask(array, mid, end);

      // Fork the tasks
      leftTask.fork();
      rightTask.fork();

      // Wait for the results from both sub-tasks and combine them
      long leftResult = leftTask.join();
      long rightResult = rightTask.join();

      return leftResult + rightResult;
    }
  }
}
