package youdrive.today.response;

import com.google.gson.annotations.SerializedName;
import youdrive.today.models.Check;

public class CommandResponse extends BaseResponse {
    Check check;
    @SerializedName("result_token")
    String resultToken;
    String status;

    public Check getCheck() {
        return this.check;
    }

    public String getResultToken() {
        return this.resultToken;
    }

    public String getStatus() {
        return this.status;
    }
}
