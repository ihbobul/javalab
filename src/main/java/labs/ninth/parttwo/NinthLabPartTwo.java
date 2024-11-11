package labs.ninth.parttwo;

public class NinthLabPartTwo {

  public static void run() {
    System.out.println("Welcome to the Ninth Lab Part Two: Producer-Consumer with Ring Buffers!");

    RingBuffer buffer1 = new RingBuffer(10);
    RingBuffer buffer2 = new RingBuffer(10);

    for (int i = 1; i <= 5; i++) {
      new MessageProducer(buffer1, i).start();
    }

    for (int i = 1; i <= 2; i++) {
      new MessageTranslator(buffer1, buffer2, i).start();
    }

    int messageCount = 0;
    while (messageCount < 100) {
      try {
        String message = buffer2.remove();
        System.out.println("Main Thread consumed: " + message);
        messageCount++;
        Thread.sleep(200);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }

    System.out.println("Finished reading 100 messages.");
  }
}
