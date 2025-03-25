package Common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterData {
    @JsonProperty("InputUserName")
    public String InputUserName;

    @JsonProperty("InputUserPhone")
    public String InputUserPhone;

    @JsonProperty("InputUserEmail")
    public String InputUserEmail;

    @JsonProperty("InputUserAccount")
    public String InputUserAccount;

    @JsonProperty("InputUserPassword")
    public String InputUserPassword;

    @JsonProperty("InputUserConfirmPassword")
    public String InputUserConfirmPassword;
}
