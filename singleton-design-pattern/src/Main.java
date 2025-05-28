import java.io.*;
import java.lang.reflect.Constructor;

/**
 * Demonstrates how Singleton patterns can be broken using:<br>
 * 1. Serialization/Deserialization <br>
 * 2. Reflection <br>
 * 3. Enum (Enum implementation is resistant to breaking)
 */
public class Main {
    public static void main(String[] args) throws Exception {

        LazySingleton lazySingleton = LazySingleton.getInstance();

//        usingSerializable();
//        usingReflection();
//        usingEnum();
    }

    /**
     * Demonstrates the safety of EnumSingleton.
     * EnumSingleton prevents breaking Singleton via Serialization or Reflection.
     */
    private static void usingEnum() {
        EnumSingleton.INSTANCE.doSomething();
    }

    /**
     * Demonstrates breaking a Singleton pattern using Reflection.
     * Reflection can bypass private constructors and create new instances.
     */
    private static void usingReflection() throws Exception {
        Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
        Constructor constructor = constructors[0];

        constructor.setAccessible(true); // change the accessibility of the constructor from private to public
        LazySingleton lazySingleton = (LazySingleton) constructor.newInstance(); // create a new instance
        LazySingleton instance = LazySingleton.getInstance();

        System.out.println("Reflection LazySingleton hashCode: "+lazySingleton.hashCode());
        System.out.println("Without Reflection LazySingleton hashCode: "+instance.hashCode());
        // Both hashcode values would be different, and this will violate the singleton pattern
    }

    /**
     * Demonstrates breaking a Singleton pattern using Serialization/Deserialization.
     * Serialization creates a new instance of the Singleton, breaking the pattern.
     */
    private static void usingSerializable() throws IOException, ClassNotFoundException {
        // Create an instance of LazySingleton
        LazySingleton lazySingleton = LazySingleton.getInstance();

        // Serialize the LazySingleton instance
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("singleton.obj"));
        objectOutputStream.writeObject(lazySingleton); // serialize
        objectOutputStream.close();

        // Deserialize to create a new instance
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("singleton.obj"));
        LazySingleton deserializedSingleton = (LazySingleton) objectInputStream.readObject(); // deserialize
        objectInputStream.close();

        // Print hash codes of the original and deserialized instances
        System.out.println("Original LazySingleton hashCode: " + lazySingleton.hashCode());
        System.out.println("Deserialized LazySingleton hashCode: " + deserializedSingleton.hashCode());

        // This demonstrates the Singleton pattern is broken.
        // Solution: Override the `readResolve()` method in the Singleton class.
    }
}
