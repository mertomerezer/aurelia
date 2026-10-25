package model;

    public class User {
        private int userId;
        private String username;
        private String displayName;
        private String password;
        private String role;

        public User(int userId, String username, String displayName, String password, String role) {
            this.userId = userId;
            this.username = username;
            this.displayName = displayName;
            this.password = password;
            this.role = role;
        }

        public int getUserId() {
            return userId;

        }

        public String getUsername() {
            return username;

        }

        public String getDisplayName() {
            return displayName;

        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setRole(String role) {
            this.role = role;
        }
        @Override
        public String toString(){
            return "Kullanıcı numarası: " + userId + ", kullanıcı adı: " + username + ", görünen ad: " + displayName + ",rol " +role;
        }

    }

