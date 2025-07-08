// Create a thread-safe counter class that uses synchronized methods for incrementing and retrieving the count
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}