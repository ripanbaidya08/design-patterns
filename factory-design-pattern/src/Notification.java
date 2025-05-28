/**
 * Notification Interface
 * This interface defines a contract for all types of notifications. It includes
 * a single abstract method, {@code send()}, which must be implemented by any
 * concrete class that represents a specific notification type. This design
 * ensures that client code can interact consistently with various notification
 * objects without relying on their concrete implementations.
 */
interface Notification {
    /**
     * Sends a notification with the specified message content.
     * @param message The message content to be sent as part of the notification.
     */
    void send(String message);
}

/**
 * A concrete implementation of the {@link Notification} interface dedicated to
 * sending email notifications. This class encapsulates the specific logic required
 * to send an email, ensuring that the email is properly formatted and delivered
 * to the recipient's inbox.
 */
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("📧 Sending Email: " + message);
        // In a real-world scenario, this would involve sending the email using
        // the JavaMail API or a similar email delivery service to handle SMTP
        // communication, email formatting, and error handling.
    }
}

/**
 * A concrete implementation of the {@link Notification} interface for sending
 * SMS text messages to mobile phones. This class handles the specific requirements
 * for integrating with an SMS gateway to ensure messages are sent reliably to
 * the intended recipients.
 */
class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("📱 Sending SMS: " + message);
        // In practice, this would involve using an SMS gateway service like
        // Twilio or Vonage, managing API keys, handling message encoding,
        // and ensuring delivery confirmations.
    }
}

/**
 * A concrete implementation of the {@link Notification} interface for sending
 * push notifications to mobile devices. This class is designed to interact with
 * push notification services, ensuring that messages are dispatched correctly
 * to devices via platforms such as Firebase Cloud Messaging (FCM) or Apple Push
 * Notification Service (APNS).
 */
class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("🔔 Sending Push Notification: " + message);
        // In a production environment, this would involve connecting to push
        // notification services, handling device tokens, payload formatting,
        // and managing notification delivery statuses.
    }
}