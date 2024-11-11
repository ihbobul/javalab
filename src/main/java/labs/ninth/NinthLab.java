package labs.ninth;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NinthLab {

  public static void run() {
    System.out.println("Welcome to the Ninth Lab: Parallel Transfers in a Banking System!");

    Bank bank = new Bank();
    List<Account> accounts = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < 1000; i++) {
      accounts.add(new Account(i, random.nextInt(1000)));
    }

    int initialTotalBalance = bank.calculateTotalBalance(accounts);
    System.out.println("Initial Total Balance: " + initialTotalBalance);

    ExecutorService executor = Executors.newFixedThreadPool(100);
    for (int i = 0; i < 5000; i++) {
      executor.execute(() -> {
        Account from = accounts.get(random.nextInt(accounts.size()));
        Account to = accounts.get(random.nextInt(accounts.size()));
        int amount = random.nextInt(100);

        if (from != to) {
          bank.transfer(from, to, amount);
        }
      });
    }

    executor.shutdown();
    try {
      executor.awaitTermination(1, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    int finalTotalBalance = bank.calculateTotalBalance(accounts);
    System.out.println("Final Total Balance: " + finalTotalBalance);

    if (initialTotalBalance == finalTotalBalance) {
      System.out.println("Success: The total balance is consistent after transfers.");
    } else {
      System.out.println("Error: The total balance has changed.");
    }
  }
}
