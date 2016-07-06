package youdrive.today.models;


public class User {
    private String avatar;
    private String name;
    private String sessionId;


    public User(String sessionId, String name, String avatar) {
        this.sessionId = sessionId;
        this.name = name;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "User{session_id='" + this.sessionId + '\'' + ", name='" + this.name + '\'' + ", avatar='" + this.avatar + '\'' + '}';
    }


    public int describeContents() {
        return 0;
    }
}
