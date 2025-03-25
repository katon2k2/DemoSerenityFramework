package Common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateData {
    @JsonProperty("InputUserName")
    public String InputUserName;

    @JsonProperty("InputUserPhone")
    public String InputUserPhone;

    @JsonProperty("InputUserEmail")
    public String InputUserEmail;
}
