import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {
  private final int index;
  private ReentrantLock leftLock, rightLock;

  Philosopher(int index) {
    this.index = index;
    leftLock = new ReentrantLock();
    rightLock = new ReentrantLock();
  }

  public void think() {

    try {
      Thread.sleep((int) (Math.random() * 3000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Philosopher " + index + " finished thinking");
  }

  void eat() {
    think();
    try {
      leftLock.lock();
      rightLock.lock();
      System.out.println("Philosopher " + index + " started eating");
      wait(3000);
      System.out.println("Philosopher " + index + " finished eating");
      leftLock.unlock();
      rightLock.unlock();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        if (leftLock != null)
          leftLock.unlock();
        if (rightLock != null)
          rightLock.unlock();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  @Override
  public void run() {
    eat();
  }
}
