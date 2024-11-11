package labs.ninth.parttwo;

public class MessageTranslator extends Thread {

  private final RingBuffer sourceBuffer;
  private final RingBuffer targetBuffer;
  private final int translatorId;

  public MessageTranslator(RingBuffer sourceBuffer, RingBuffer targetBuffer, int translatorId) {
    this.sourceBuffer = sourceBuffer;
    this.targetBuffer = targetBuffer;
    this.translatorId = translatorId;
    setDaemon(true);
  }

  @Override
  public void run() {
    while (true) {
      try {
        String message = sourceBuffer.remove();
        String translatedMessage = "Translator " + translatorId + " translated: " + message;

        targetBuffer.add(translatedMessage);
        System.out.println(translatedMessage);
        Thread.sleep(150);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
