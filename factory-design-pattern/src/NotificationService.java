/**
 * NotificationService is a client class that demonstrates the use of the
 * NotificationFactory. It shows how the client is decoupled from the concrete
 * notification classes.
 *
 * The class contains a main method that creates a notification object using
 * the factory method and sends a notification.
 */
/**
 * <h1>NotificationService (Client)</h1>
 * <p>
 * This is the main client class that demonstrates the use of the
 * {@link NotificationFactory} to send notifications. It shows how the client is
 * decoupled from the concrete notification classes.
 * </p>
 */
public class NotificationService {

    public static void main(String[] args) {
        // Create an instance of the factory.
        NotificationFactory factory = new NotificationFactory();

        // Use the factory to create a notification object for a specific channel.
        // The client code does not need to know about `EmailNotification.class`.
        Notification emailNotifier = factory.createNotification("EMAIL");
        if (emailNotifier != null) {
            emailNotifier.send("Your order has been shipped!");
        }

        // Easily switch to another notification type by changing the input string.
        Notification smsNotifier = factory.createNotification("SMS");
        if (smsNotifier != null) {
            smsNotifier.send("Your package will arrive tomorrow.");
        }

        Notification pushNotifier = factory.createNotification("PUSH");
        if (pushNotifier != null) {
            pushNotifier.send("You have a new message.");
        }

        // Example of handling an unknown channel.
        try {
            Notification unknownNotifier = factory.createNotification("FAX");
            if (unknownNotifier != null) {
                unknownNotifier.send("This will not be sent.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}