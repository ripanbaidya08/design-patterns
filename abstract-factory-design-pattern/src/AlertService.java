/**
 * AlertService (Client)
 *
 * This main class acts as the client. It demonstrates how to use the Abstract
 * Factory pattern to create and send notifications without coupling the client
 * to concrete product classes. The client only needs to know which factory to
 * use (e.g., for urgent vs. marketing messages).
 */
public class AlertService {
    public static void main(String[] args) {
        // Scenario 1: Sending an urgent system alert
        // This scenario demonstrates using the UrgentNotificationFactory to
        // create and send a formal notification for urgent alerts.
        System.out.println("--- Running Urgent Notification Scenario ---");

        // We choose the factory for urgent notifications.
        NotificationFactory urgentFactory = new UrgentNotificationFactory();

        // The factory creates a compatible notification and template.
        Notification urgentSms = urgentFactory.createNotification("SMS");
        NotificationTemplate formalTemplate = urgentFactory.createTemplate();

        // Check if the notification and template are created successfully
        // and then send the notification with the specified message.
        if (urgentSms != null && formalTemplate != null) {
            urgentSms.send("System is going down for maintenance in 1 hour.", formalTemplate);
        }

        // Add spacing for better readability between scenarios.
        System.out.println("\n");

        // Scenario 2: Sending a casual marketing update
        // This scenario demonstrates using the MarketingNotificationFactory to
        // create and send a casual notification for marketing updates.
        System.out.println("--- Running Marketing Notification Scenario ---");

        // Now, we switch to the marketing factory.
        NotificationFactory marketingFactory = new MarketingNotificationFactory();

        // The factory creates a different family of related objects.
        Notification marketingEmail = marketingFactory.createNotification("EMAIL");
        NotificationTemplate casualTemplate = marketingFactory.createTemplate();

        // Check if the notification and template are created successfully
        // and then send the notification with the specified message.
        if (marketingEmail != null && casualTemplate != null) {
            marketingEmail.send("Our summer sale just started! Get 50% off.", casualTemplate);
        }

        // Example of an unsupported combination
        // Demonstrates that the marketing factory does not support SMS notifications.
        Notification marketingSms = marketingFactory.createNotification("SMS");
        if (marketingSms == null) {
            System.out.println("\nMarketing SMS is not supported by this factory.");
        }
    }
}