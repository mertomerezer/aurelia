
package auth;

import model.User;
import structures.UserLinkedList;

public class AuthService {
    private final UserLinkedList users;
    private User currentUsers;

    public AuthService(UserLinkedList users){
        if (users == null){
            throw new IllegalArgumentException("Kullanıcı listesi boş olamaz.");
        }
        this.users = users;
    }

    public boolean addUser(User user){
        if (user == null
                || isBlank(user.getUsername())
                || isBlank(user.getPassword())
                || user.getRole() == null ){
            return false;
        }

        return users.addUser(user);
    }
    public boolean login(String username, String password){

        if (isBlank(username) || isBlank(password)){
            return false;
        }
        User user = users.findByUsername(username.trim());
        if (user == null || !password.equals(user.getPassword())){
            return false;
        }
        currentUsers = user;
        return true;
    }
    public void logout(){
        currentUsers = null;
    }

    public User getCurrentUsers(){
        return currentUsers;
    }

    public String getCurrentUSerDisplayName(){
        return currentUsers == null ? null : currentUsers.getDisplayName();
    }

    public String getCurrentUserRoleName(){
        return currentUsers == null || currentUsers.getRole() == null ? null : currentUsers.getRole().name();
    }

    private boolean isBlank(String value){
        return value == null || value.trim().isEmpty();
    }
}
