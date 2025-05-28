import java.io.Serializable;

/**
 * LazySingleton is a basic implementation of the Singleton Design Pattern.
 *
 * <p> This implementation lazily initializes the singleton instance when it is first requested.
 * However, this class is not thread-safe, meaning multiple threads can potentially create multiple instances,
 * violating the Singleton principle. </p>
 *
 * <p> Note: If thread safety is required, consider using thread-safe techniques such as synchronized blocks or the
 * double-checked locking mechanism. </p>
 */
public class LazySingleton implements Serializable {

    // Static instance of the LazySingleton, initialized to null (lazy initialization)
    private static LazySingleton instance = null;

    /**
     * Private constructor prevents external instantiation of this class.
     * This ensures that objects cannot be created directly using the `new` keyword.
     */
    private LazySingleton() {}

    /**
     * Provides a globally accessible method to get the single instance of this class.
     *
     * <p> This method lazily initializes the instance when it is first requested.
     * However, since it is not thread-safe, multiple threads calling this method concurrently
     * may create multiple instances of the class, breaking the Singleton principle. </p>
     *
     * <p> To make this implementation thread-safe, consider using a synchronized block
     * or the double-checked locking mechanism. </p>
     *
     * @return The singleton instance of <b>LazySingleton</b>.
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton(); // Create the instance if it doesn't exist
        }
        return instance;
    }

    // simple method
    public void displayMessage() {
        System.out.println("Inside LazySingleton..");
    }
}