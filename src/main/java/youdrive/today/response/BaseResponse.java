package youdrive.today.response;

public class BaseResponse {
    private int code;
    private boolean success;
    private String text;

    public boolean isSuccess() {
        return this.success;
    }

    public int getCode() {
        return this.code;
    }

    public String getText() {
        return this.text;
    }
}
