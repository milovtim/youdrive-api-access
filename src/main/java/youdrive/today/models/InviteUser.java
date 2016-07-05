package youdrive.today.models;

public class InviteUser {
    private String email;
    private Long phone;
    private boolean readyToUse;
    private String region;

    public InviteUser(String email, long phone, String region, boolean readyToUse) {
        this.email = email;
        this.phone = Long.valueOf(phone);
        this.region = region;
        this.readyToUse = readyToUse;
    }
}
