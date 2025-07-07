package src;

import src.singleton.Singleton;
import src.factory.Factory;
import src.factory.Product;
import src.observer.Publisher;
import src.observer.Subscriber;
import src.strategy.Context;
import src.strategy.StrategyA;
import src.strategy.StrategyB;
import src.utils.FileUtils;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Singleton
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();

        // Factory
        Product productA = Factory.getProduct("A");
        productA.create();
        Product productB = Factory.getProduct("B");
        productB.create();

        // Observer
        Publisher publisher = new Publisher();
        Subscriber sub1 = new Subscriber("Alice");
        Subscriber sub2 = new Subscriber("Bob");
        publisher.subscribe(sub1);
        publisher.subscribe(sub2);
        publisher.notifyObservers("Hello Subscribers!");
        publisher.unsubscribe(sub1);
        publisher.notifyObservers("Only Bob should see this.");

        // Strategy
        Context context = new Context();
        context.setStrategy(new StrategyA());
        context.executeStrategy();
        context.setStrategy(new StrategyB());
        context.executeStrategy();

        // File Utils
        String filePath = "test.txt";
        List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3");
        FileUtils.writeFile(filePath, lines);
        List<String> readLines = FileUtils.readFile(filePath);
        System.out.println("Read from file:");
        for (String line : readLines) {
            System.out.println(line);
        }
        FileUtils.logInfo("Demo completed successfully.");
    }
}
