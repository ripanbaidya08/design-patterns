/**
 * This interface defines the contract for all notification products. It declares a
 * method to send a notification, which will be composed using a template.
 */
interface Notification {
    /**
     * Sends a notification using a specific message and template.
     *
     * @param message The core message to be sent.
     * @param template The template to format the notification content.
     */
    void send(String message, NotificationTemplate template);
}

/**
 * A concrete implementation of the {@link Notification} interface for sending
 * email notifications.
 */
class EmailNotification implements Notification {
    @Override
    public void send(String message, NotificationTemplate template) {
        System.out.println("Sending Email...");
        System.out.println(template.format("Email", message));
    }
}

/**
 * A concrete implementation of the {@link Notification} interface for sending
 * SMS text messages.
 */
class SMSNotification implements Notification {
    @Override
    public void send(String message, NotificationTemplate template) {
        System.out.println("Sending SMS...");
        System.out.println(template.format("SMS", message));
    }
}