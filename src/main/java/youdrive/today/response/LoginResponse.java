package youdrive.today.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse extends BaseResponse {
    String avatar;
    String name;
    @SerializedName("session_id")
    String sessionId;

    public String getSessionId() {
        return this.sessionId;
    }

    public String getName() {
        return this.name;
    }

    public String getAvatar() {
        return this.avatar;
    }
}
