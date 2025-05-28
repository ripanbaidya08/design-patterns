import java.io.Serializable;

/**
 * EagerSingleton is an implementation of the Singleton Design Pattern with eager initialization.
 * 
 * <p> The <b>singleton</b> instance is created as soon as the class is loaded into memory.
 * This ensures thread safety by design, as the instance is created during class loading
 * and shared across all threads. </p>
 * 
 * <p> Drawback: If the instance is not used, it still occupies memory unnecessarily, which can lead to
 * resource wastage in cases where the singleton object is heavy or rarely used.</p>
 * 
 * <p> Note: If the instance is rarely used, consider using the LazySingleton or MultithreadSingleton implementations
 * instead of EagerSingleton. </p>
 */
public class EagerSingleton implements Serializable {

    // The singleton instance is created eagerly during class loading.
    private static final EagerSingleton instance = new EagerSingleton();

    // Prevents instantiation from outside the class
    private EagerSingleton() {}

    /**
     * Provides a globally accessible method to get the single instance of this class.
     *
     * @return The singleton instance of EagerSingleton.
     * Since the instance is eagerly initialized, this method simply returns the already-created instance.
     */
    public static EagerSingleton getInstance() {
        return instance;
    }
}