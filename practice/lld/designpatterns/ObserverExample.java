import java.util.*;

public class ObserverExample {

    public static void main(String[] args) {
        Group topic = new Group();// Create a Topic

        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");

        topic.subscribe(user1);
        topic.subscribe(user2);
        topic.subscribe(user3);

        topic.notifyAllSubscribers("Hello, I am a message published by the topic.");

        topic.unsubscribe(user2);

        topic.notifyAllSubscribers("Hello, I am a message published by the topic.");
    }
}

// Interface for subscribers (observers)
interface Subscriber {
    void notify(String message);
}

//User Class (Observer)
class User implements Subscriber {
    private String userId;

    public User(String userId) {
        this.userId = userId;
    }

    public void notify(String message) {
        System.out.println("User " + userId + " received message: " + message);
    }
}

// Group class acting as the subject (publisher)
class Group {
    private List<Subscriber> users;

    public Group() {
        this.users = new ArrayList<>();
    }

    public void subscribe(Subscriber user) {
        users.add(user);
    }

    public void unsubscribe(Subscriber user) {
        users.remove(user);
    }

    public void notifyAllSubscribers(String message) {
        for (Subscriber user : users) {
            user.notify(message);
        }
    }
}