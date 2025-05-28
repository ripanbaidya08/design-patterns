/**
 * MultithreadSingleton is a thread-safe implementation of the Singleton Design Pattern.
 * This ensures that only one instance of the class is created, even in a multithreaded environment.
 */
public class MultithreadSingleton {

    // Volatile variable to ensure changes made by one thread are visible to others
    private static volatile MultithreadSingleton instance = null;

    private MultithreadSingleton() {
        // Prevents instantiation from outside the class
    }

    /**
     * Provides a globally accessible method to get the single instance of this class.
     *
     * @return The singleton instance of MultithreadSingleton.
     *
     * This method uses double-checked locking to ensure that the singleton instance is
     * created only once, and it is done in a thread-safe manner. The first check of
     * the instance being null is outside the synchronized block for performance reasons,
     * allowing multiple threads to read the instance without synchronization.
     * The synchronized block only comes into play when the instance is being created,
     * ensuring that only one thread can execute this block at a time.
     */
    public static MultithreadSingleton getInstance() {
        // Check if the instance is null (first check, improves performance)
        if (instance == null) {
            // Synchronize only if the instance is not yet created
            // Here, we have applied double-checked locking
            synchronized (MultithreadSingleton.class) {
                // Double-check to ensure only one instance is created in a multithreaded environment
                if (instance == null) {
                    instance = new MultithreadSingleton();
                }
            }
        }
        return instance;
    }
}