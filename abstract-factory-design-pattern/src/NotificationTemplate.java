/**
 * This interface defines the contract for different notification templates.
 * Each template can format a message in its own way.
 */
interface NotificationTemplate {
    /**
     * Formats the given message for a specific channel.
     *
     * @param channel The channel (e.g., "Email", "SMS").
     * @param message The message content.
     * @return A fully formatted notification string.
     */
    String format(String channel, String message);
}

/**
 * A concrete implementation of {@link NotificationTemplate} that provides a
 * formal, professional-looking format for notifications.
 */
class FormalTemplate implements NotificationTemplate {
    @Override
    public String format(String channel, String message) {
        return "========================================\n"
             + "Formal " + channel + " Notification\n"
             + "========================================\n"
             + "Message: " + message + "\n"
             + "Regards,\n"
             + "System Administration\n"
             + "========================================";
    }
}

/**
 * A concrete implementation of {@link NotificationTemplate} that provides a
 * friendly, informal format for notifications.
 */
class CasualTemplate implements NotificationTemplate {
    @Override
    public String format(String channel, String message) {
        return " Just a quick update for you via " + channel + ": " + message + " ";
    }
}