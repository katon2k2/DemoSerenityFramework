package Common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MySqlData {
    @JsonProperty("Url")
    public String Url;

    @JsonProperty("Account")
    public String Account;

    @JsonProperty("Password")
    public String Password;
}
