public class Counter {
    private int count = 0;

    // Synchronized method to increment the count
    public synchronized void increment() {
        count++;
    }

    // Synchronized method to retrieve the count
    public synchronized int getCount() {
        return count;
    }
}