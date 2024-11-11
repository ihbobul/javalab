package labs.ninth.parttwo;

public class MessageProducer extends Thread {

  private final RingBuffer buffer;
  private final int producerId;

  public MessageProducer(RingBuffer buffer, int producerId) {
    this.buffer = buffer;
    this.producerId = producerId;
    setDaemon(true);
  }

  @Override
  public void run() {
    int messageCount = 1;
    while (true) {
      String message = "Producer " + producerId + " generated message " + messageCount++;
      try {
        buffer.add(message);
        System.out.println(message);
        Thread.sleep(100);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
