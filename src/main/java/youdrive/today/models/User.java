package youdrive.today.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class User implements Parcelable {
    public static final Creator<User> CREATOR;
    private String avatar;
    private String name;
    private String sessionId;

    /* renamed from: youdrive.today.models.User.1 */
    static class C17431 implements Creator<User> {
        C17431() {
        }

        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    }

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

    protected User(Parcel in) {
        this.sessionId = in.readString();
        this.name = in.readString();
        this.avatar = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.sessionId);
        dest.writeString(this.name);
        dest.writeString(this.avatar);
    }

    static {
        CREATOR = new C17431();
    }
}
