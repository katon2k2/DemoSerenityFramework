package Common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateData {
    @JsonProperty("InputUserName")
    private String InputUserName;

    @JsonProperty("InputUserPhone")
    private String InputUserPhone;

    @JsonProperty("InputUserEmail")
    private String InputUserEmail;

    public String getInputUserName() { return InputUserName; }
    public String getInputUserPhone() { return InputUserPhone; }
    public String getInputUserEmail() { return InputUserEmail; }
}
