package youdrive.today.models;

public class CreditCardResponse {
    private String finish_url;
    private String req_url;
    private boolean secure_check_needed;

    public boolean isSecure_check_needed() {
        return this.secure_check_needed;
    }

    public String getReq_url() {
        return this.req_url;
    }

    public String getFinish_url() {
        return this.finish_url;
    }
}
