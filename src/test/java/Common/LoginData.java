package Common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginData {
    @JsonProperty("InputUserAccount")
    public String InputUserAccount;

    @JsonProperty("InputUserPassword")
    public String InputUserPassword;
}
