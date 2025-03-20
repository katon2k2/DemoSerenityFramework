package Common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvalidData {
    @JsonProperty("InputUserAccountWrong")
    private String inputUserAccountWrong;

    @JsonProperty("InputUserAccountExists")
    private String inputUserAccountExists;

    @JsonProperty("InputUserAccountOverLength")
    private String inputUserAccountOverLength;

    @JsonProperty("InputUserAccountTooShort")
    private String inputUserAccountTooShort;

    @JsonProperty("InputUserAccountStartWithNumber")
    private String inputUserAccountStartWithNumber;

    @JsonProperty("InputUserAccountWithSpecialCharacters")
    private String inputUserAccountWithSpecialCharacters;

    @JsonProperty("InputUserAccountOnlySpace")
    private String inputUserAccountOnlySpace;

    @JsonProperty("InputUserPasswordWrong")
    private String inputUserPasswordWrong;

    @JsonProperty("InputUserPasswordOverLength")
    private String inputUserPasswordOverLength;

    @JsonProperty("InputUserPasswordTooShort")
    private String inputUserPasswordTooShort;

    @JsonProperty("InputUserPasswordOnlySpace")
    private String inputUserPasswordOnlySpace;

    @JsonProperty("InputUserNameOverLength")
    private String inputUserNameOverLength;

    @JsonProperty("InputUserNameWithNumber")
    private String inputUserNameWithNumber;

    @JsonProperty("InputUserNameWithSpecialCharacters")
    private String inputUserNameWithSpecialCharacters;

    @JsonProperty("InputUserNameOnlySpace")
    private String inputUserNameOnlySpace;

    @JsonProperty("InputUserPhoneOverLength")
    private String inputUserPhoneOverLength;

    @JsonProperty("InputUserPhoneTooShort")
    private String inputUserPhoneTooShort;

    @JsonProperty("InputUserPhoneWithAlphabet")
    private String inputUserPhoneWithAlphabet;

    @JsonProperty("InputUserPhoneWithSpecialCharacters")
    private String inputUserPhoneWithSpecialCharacters;

    @JsonProperty("InputUserPhoneOnlySpace")
    private String inputUserPhoneOnlySpace;

    @JsonProperty("InputUserEmailOverLength")
    private String inputUserEmailOverLength;

    @JsonProperty("InputUserEmailWithSpecialCharacters")
    private String inputUserEmailWithSpecialCharacters;

    @JsonProperty("InputUserEmailIncorrectExtension")
    private String inputUserEmailIncorrectExtension;

    @JsonProperty("InputUserEmailHeaderIsSpace")
    private String inputUserEmailHeaderIsSpace;

    // Getter methods
    public String getInputUserAccountWrong() {
        return inputUserAccountWrong;
    }

    public String getInputUserAccountExists() {
        return inputUserAccountExists;
    }

    public String getInputUserAccountOverLength() {
        return inputUserAccountOverLength;
    }

    public String getInputUserAccountTooShort() {
        return inputUserAccountTooShort;
    }

    public String getInputUserAccountStartWithNumber() {
        return inputUserAccountStartWithNumber;
    }

    public String getInputUserAccountWithSpecialCharacters() {
        return inputUserAccountWithSpecialCharacters;
    }

    public String getInputUserAccountOnlySpace() {
        return inputUserAccountOnlySpace;
    }

    public String getInputUserPasswordWrong() {
        return inputUserPasswordWrong;
    }

    public String getInputUserPasswordOverLength() {
        return inputUserPasswordOverLength;
    }

    public String getInputUserPasswordTooShort() {
        return inputUserPasswordTooShort;
    }

    public String getInputUserPasswordOnlySpace() {
        return inputUserPasswordOnlySpace;
    }

    public String getInputUserNameOverLength() {
        return inputUserNameOverLength;
    }

    public String getInputUserNameWithNumber() {
        return inputUserNameWithNumber;
    }

    public String getInputUserNameWithSpecialCharacters() {
        return inputUserNameWithSpecialCharacters;
    }

    public String getInputUserNameOnlySpace() {
        return inputUserNameOnlySpace;
    }

    public String getInputUserPhoneOverLength() {
        return inputUserPhoneOverLength;
    }

    public String getInputUserPhoneTooShort() {
        return inputUserPhoneTooShort;
    }

    public String getInputUserPhoneWithAlphabet() {
        return inputUserPhoneWithAlphabet;
    }

    public String getInputUserPhoneWithSpecialCharacters() {
        return inputUserPhoneWithSpecialCharacters;
    }

    public String getInputUserPhoneOnlySpace() {
        return inputUserPhoneOnlySpace;
    }

    public String getInputUserEmailOverLength() {
        return inputUserEmailOverLength;
    }

    public String getInputUserEmailWithSpecialCharacters() {
        return inputUserEmailWithSpecialCharacters;
    }

    public String getInputUserEmailIncorrectExtension() {
        return inputUserEmailIncorrectExtension;
    }

    public String getInputUserEmailHeaderIsSpace() {
        return inputUserEmailHeaderIsSpace;
    }
}
