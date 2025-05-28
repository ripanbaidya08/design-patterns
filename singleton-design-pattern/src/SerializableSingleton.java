import java.io.Serializable;

public class SerializableSingleton implements Serializable {

    // Use transient to avoid serializing the singleton instance field.
    // volatile is used to ensure changes made in the instance by one thread are visible to others
    private static volatile SerializableSingleton instance = null;

    // Private constructor to prevent direct instantiation.
    private SerializableSingleton() {}

    /**
     * Method to get the singleton instance.
     * Creates the instance if it doesn't already exist.
     * @return the singleton instance
     */
    public static SerializableSingleton getInstance() {
        if (instance == null) {
            instance = new SerializableSingleton();
        }
        return instance;
    }

    /**
     * This method is invoked during deserialization to ensure the same instance is used.
     * The `readResolve()` method returns the same instance instead of creating a new one during deserialization.
     * This helps to maintain the singleton property.
     *
     * @return instance of SerializableSingleton class
     */
    protected Object readResolve() {
        // Ensure that the same or existing instance is returned after deserialization.
        return instance;
    }

    /**
     * To verify Singleton functionality, this method can be used to display the instance.
     */
    public void displayMessage() {
        System.out.println("Inside SerializableSingleton..");
    }
}
