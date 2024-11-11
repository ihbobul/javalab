package labs.ninth;

import java.util.concurrent.locks.ReentrantLock;

public class Account {

  private final int id;
  private final ReentrantLock lock = new ReentrantLock();
  private int balance;

  public Account(int id, int initialBalance) {
    this.id = id;
    this.balance = initialBalance;
  }

  public int getId() {
    return id;
  }

  public int getBalance() {
    return balance;
  }

  public ReentrantLock getLock() {
    return lock;
  }

  public void deposit(int amount) {
    balance += amount;
  }

  public void withdraw(int amount) {
    if (balance >= amount) {
      balance -= amount;
    }
  }
}
