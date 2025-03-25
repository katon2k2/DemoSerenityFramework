package Common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvalidData {
    @JsonProperty("InputUserAccountWrong")
    public String inputUserAccountWrong;

    @JsonProperty("InputUserAccountExists")
    public String inputUserAccountExists;

    @JsonProperty("InputUserAccountOverLength")
    public String inputUserAccountOverLength;

    @JsonProperty("InputUserAccountTooShort")
    public String inputUserAccountTooShort;

    @JsonProperty("InputUserAccountStartWithNumber")
    public String inputUserAccountStartWithNumber;

    @JsonProperty("InputUserAccountWithSpecialCharacters")
    public String inputUserAccountWithSpecialCharacters;

    @JsonProperty("InputUserAccountOnlySpace")
    public String inputUserAccountOnlySpace;

    @JsonProperty("InputUserPasswordWrong")
    public String inputUserPasswordWrong;

    @JsonProperty("InputUserPasswordOverLength")
    public String inputUserPasswordOverLength;

    @JsonProperty("InputUserPasswordTooShort")
    public String inputUserPasswordTooShort;

    @JsonProperty("InputUserPasswordOnlySpace")
    public String inputUserPasswordOnlySpace;

    @JsonProperty("InputUserNameOverLength")
    public String inputUserNameOverLength;

    @JsonProperty("InputUserNameWithNumber")
    public String inputUserNameWithNumber;

    @JsonProperty("InputUserNameWithSpecialCharacters")
    public String inputUserNameWithSpecialCharacters;

    @JsonProperty("InputUserNameOnlySpace")
    public String inputUserNameOnlySpace;

    @JsonProperty("InputUserPhoneOverLength")
    public String inputUserPhoneOverLength;

    @JsonProperty("InputUserPhoneTooShort")
    public String inputUserPhoneTooShort;

    @JsonProperty("InputUserPhoneWithAlphabet")
    public String inputUserPhoneWithAlphabet;

    @JsonProperty("InputUserPhoneWithSpecialCharacters")
    public String inputUserPhoneWithSpecialCharacters;

    @JsonProperty("InputUserPhoneOnlySpace")
    public String inputUserPhoneOnlySpace;

    @JsonProperty("InputUserEmailOverLength")
    public String inputUserEmailOverLength;

    @JsonProperty("InputUserEmailWithSpecialCharacters")
    public String inputUserEmailWithSpecialCharacters;

    @JsonProperty("InputUserEmailIncorrectExtension")
    public String inputUserEmailIncorrectExtension;

    @JsonProperty("InputUserEmailHeaderIsSpace")
    public String inputUserEmailHeaderIsSpace;
}
