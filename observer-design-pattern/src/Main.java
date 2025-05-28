import java.util.ArrayList;
import java.util.List;

/**
 * Observer interface - defines the contract for any subscriber.
 */
interface Subscriber {
    /**
     * This method is called to notify the subscriber about an update.
     */
    void update();
}

/**
 * Subject interface - defines the contract for a channel that manages subscribers.
 */
interface Channel {
    /**
     * Registers a new subscriber to the channel.
     * @param subscriber the subscriber to be added
     */
    void subscribe(Subscriber subscriber);

    /**
     * Unregisters an existing subscriber from the channel.
     * @param subscriber the subscriber to be removed
     */
    void unsubscribe(Subscriber subscriber);

    /**
     * Notifies all registered subscribers about an update.
     */
    void notifySubscribers();
}

/**
 * Concrete implementation of the Channel interface.
 * Represents a YouTube-like channel that can notify subscribers when a new video is uploaded.
 */
class ChannelImpl implements Channel {
    private final String channelName;  // Name of the channel
    private String latestVideo;        // Title of the latest uploaded video
    private final List<Subscriber> subscribers;  // List of all registered subscribers

    /**
     * Constructor to initialize the channel with a name.
     * @param channelName name of the channel
     */
    public ChannelImpl(String channelName) {
        this.channelName = channelName;
        this.subscribers = new ArrayList<>();
    }

    /**
     * Adds a subscriber to the list if not already present.
     */
    @Override
    public void subscribe(Subscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    /**
     * Removes a subscriber from the list.
     */
    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    /**
     * Notifies all subscribers about the latest video.
     */
    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    /**
     * Simulates uploading a video and triggers notification to subscribers.
     * @param videoTitle title of the uploaded video
     */
    public void uploadVideo(String videoTitle) {
        this.latestVideo = videoTitle;
        System.out.println("\n[Channel] New video uploaded: " + videoTitle);
        notifySubscribers();
    }

    /**
     * Provides the latest video information for subscribers.
     * @return a string containing the latest video title and channel name
     */
    public String getVideoInformation() {
        return "Latest video on \"" + channelName + "\": " + latestVideo;
    }
}

/**
 * Concrete implementation of the Subscriber interface.
 * Represents a user who subscribes to a channel and gets notified.
 */
class SubscriberImpl implements Subscriber {
    private final String name;              // Subscriber's name
    private final ChannelImpl channel;      // Channel to which this subscriber is subscribed

    /**
     * Constructor registers this subscriber with a channel upon creation.
     * @param name subscriber name
     * @param channel the channel to subscribe to
     */
    public SubscriberImpl(String name, ChannelImpl channel) {
        this.name = name;
        this.channel = channel;
        channel.subscribe(this);  // Automatically subscribe during construction
    }

    /**
     * Called when the channel uploads a new video.
     */
    @Override
    public void update() {
        System.out.println("[Notification] " + name + " has been notified: " + channel.getVideoInformation());
    }
}

/**
 * Main class to test the Observer pattern implementation.
 */
public class Main {
    public static void main(String[] args) {
        // Creating a channel (subject)
        ChannelImpl techChannel = new ChannelImpl("Tech Insights");

        // Creating subscribers (observers)
        SubscriberImpl alice = new SubscriberImpl("Alice", techChannel);
        SubscriberImpl bob = new SubscriberImpl("Bob", techChannel);
        SubscriberImpl charlie = new SubscriberImpl("Charlie", techChannel);

        // Uploading a new video to the channel
        techChannel.uploadVideo("Observer Pattern in Java");

        // Unsubscribing one user and uploading another video
        techChannel.unsubscribe(bob);
        techChannel.uploadVideo("Advanced Java Multithreading");
    }
}
