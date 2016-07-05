package youdrive.today.response;

import youdrive.today.models.RegistrationUser;

public class RegistrationModel extends BaseResponse {
    private RegistrationUser data;
    private String id;
    private String session_id;
    private RegistrationUser validation;

    public String getSession_id() {
        return this.session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RegistrationUser getData() {
        return this.data;
    }

    public void setData(RegistrationUser data) {
        this.data = data;
    }

    public RegistrationUser getValidation() {
        return this.validation;
    }

    public void setValidation(RegistrationUser validation) {
        this.validation = validation;
    }
}
