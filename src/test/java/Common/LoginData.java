package Common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginData {
    @JsonProperty("InputUserAccount")
    private String InputUserAccount;

    @JsonProperty("InputUserPassword")
    private String InputUserPassword;

    public String getInputUserAccount() { return InputUserAccount; }
    public String getInputUserPassword() { return InputUserPassword; }
}
