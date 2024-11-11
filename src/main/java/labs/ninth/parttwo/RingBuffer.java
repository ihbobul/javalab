package labs.ninth.parttwo;

public class RingBuffer {

  private final String[] buffer;
  private final int capacity;
  private int head = 0;
  private int tail = 0;
  private int count = 0;

  public RingBuffer(int capacity) {
    this.capacity = capacity;
    this.buffer = new String[capacity];
  }

  public synchronized void add(String message) throws InterruptedException {
    while (count == capacity) {
      wait();
    }
    buffer[tail] = message;
    tail = (tail + 1) % capacity;
    count++;
    notifyAll();
  }

  public synchronized String remove() throws InterruptedException {
    while (count == 0) {
      wait();
    }
    String message = buffer[head];
    head = (head + 1) % capacity;
    count--;
    notifyAll();
    return message;
  }

  public synchronized boolean isEmpty() {
    return count == 0;
  }
}
