package Common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterData {
    @JsonProperty("InputUserName")
    private String InputUserName;

    @JsonProperty("InputUserPhone")
    private String InputUserPhone;

    @JsonProperty("InputUserEmail")
    private String InputUserEmail;

    @JsonProperty("InputUserAccount")
    private String InputUserAccount;

    @JsonProperty("InputUserPassword")
    private String InputUserPassword;

    @JsonProperty("InputUserConfirmPassword")
    private String InputUserConfirmPassword;

    public String getInputUserName() { return InputUserName; }
    public String getInputUserPhone() { return InputUserPhone; }
    public String getInputUserEmail() { return InputUserEmail; }
    public String getInputUserAccount() { return InputUserAccount; }
    public String getInputUserPassword() { return InputUserPassword; }
    public String getInputUserConfirmPassword() { return InputUserConfirmPassword; }
}
