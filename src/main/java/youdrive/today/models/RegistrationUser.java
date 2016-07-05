package youdrive.today.models;

public class RegistrationUser {
    private String card_number;
    private String documents_storage_url;
    private String email;
    private String first_name;
    private String last_name;
    private String middle_name;
    private boolean online_contract_signed;
    private String password;
    private String password_confirm;
    private String phone;
    private String promocode;
    private String user_id;

    public boolean getOnline_contract_signed() {
        return this.online_contract_signed;
    }

    public void setOnline_contract_signed(boolean online_contract_signed) {
        this.online_contract_signed = online_contract_signed;
    }

    public String getUserId() {
        return this.user_id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirm() {
        return this.password_confirm;
    }

    public void setPassword_confirm(String password_confirm) {
        this.password_confirm = password_confirm;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return this.middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDocuments_storage_url() {
        return this.documents_storage_url;
    }

    public void setDocuments_storage_url(String documents_storage_url) {
        this.documents_storage_url = documents_storage_url;
    }

    public String getCard_number() {
        return this.card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getPromocode() {
        return this.promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }

    public String toString() {
        return "RegistrationUser{online_contract_signed=" + this.online_contract_signed + ", email='" + this.email + '\'' + ", password='" + this.password + '\'' + ", password_confirm='" + this.password_confirm + '\'' + ", phone='" + this.phone + '\'' + ", first_name='" + this.first_name + '\'' + ", middle_name='" + this.middle_name + '\'' + ", last_name='" + this.last_name + '\'' + ", documents_storage_url='" + this.documents_storage_url + '\'' + ", card_number='" + this.card_number + '\'' + ", promocode='" + this.promocode + '\'' + '}';
    }
}
