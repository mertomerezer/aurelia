package structures;
import model.User;
public class UserLinkedList {
    private UserNode head;

    public UserLinkedList() {
        this.head = null;
    }

    public boolean addUser(User user) {
        if (user == null || user.getUsername() == null) {
            return false;
        }

        if (findByUsername(user.getUsername()) != null) {
            return false;
        }

        UserNode newNode = new UserNode(user);

        if (head == null) {
            head = newNode;
            return true;
        }

        UserNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
        return true;
    }

    public User findByUsername(String username) {
        if (username == null) {
            return null;
        }

        UserNode current = head;

        while (current != null) {
            User user = current.getUser();
            if (user.getUsername() != null
                    && user.getUsername().equals(username)) {
                return user;
            }
            current = current.getNext();
        }
        return null;
    }
}