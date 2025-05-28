/**
 * This interface is the core of the Abstract Factory pattern. It declares a set
 * of methods for creating abstract products (in this case, {@link Notification}
 * and {@link NotificationTemplate}). Each concrete factory implementing this
 * interface will be responsible for creating a family of related objects.
 */
interface NotificationFactory {
    /**
     * Creates a notification object.
     * @param type The type of notification (e.g., "EMAIL", "SMS").
     * @return A {@link Notification} object.
     */
    Notification createNotification(String type);

    /**
     * Creates a notification template object.
     * @return A {@link NotificationTemplate} object compatible with the notifications.
     */
    NotificationTemplate createTemplate();
}

/**
 * This factory creates a family of products for urgent, formal notifications.
 * It pairs notifications (like Email and SMS) with a {@link FormalTemplate}.
 */
class UrgentNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        }
        return null;
    }

    @Override
    public NotificationTemplate createTemplate() {
        return new FormalTemplate();
    }
}

/**
 * This factory creates a family of products for marketing or casual updates.
 * It pairs notifications (like Email) with a {@link CasualTemplate}.
 */
class MarketingNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification(String type) {
        // Marketing might only support Email, for example.
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }
        // SMS might not be available for marketing, returning null.
        return null;
    }

    @Override
    public NotificationTemplate createTemplate() {
        return new CasualTemplate();
    }
}