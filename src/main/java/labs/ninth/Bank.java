package labs.ninth;

import java.util.List;

public class Bank {

  public void transfer(Account from, Account to, int amount) {
    Account first = from.getId() < to.getId() ? from : to;
    Account second = from.getId() < to.getId() ? to : from;

    synchronized (first.getLock()) {
      synchronized (second.getLock()) {
        if (from.getBalance() >= amount) {
          from.withdraw(amount);
          to.deposit(amount);
        }
      }
    }
  }

  public int calculateTotalBalance(List<Account> accounts) {
    return accounts.stream().mapToInt(Account::getBalance).sum();
  }
}
