package Test.Web;

import Action.LoginStep;
import Action.ShowInfoStep;
import Action.UpdateInfoStep;
import Common.*;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;

@ExtendWith(SerenityJUnit5Extension.class)
public class UpdateInfoTest {
    private static Data data;
    private static LoginData loginData;
    private static UpdateData updateData;
    private static InvalidData invalidData;

    public UpdateInfoTest() throws IOException {
        data = JsonDataReader.getTestData();
        loginData = data.getLoginData();
        updateData = data.getUpdateData();
        invalidData = data.getInvalidData();
    }

    @Steps
    LoginStep loginStep;

    @Steps
    ShowInfoStep showInfoStep;

    @Steps
    UpdateInfoStep updateInfoStep;

    @Test
    @DisplayName("Kiểm tra hiển thị trang cập nhật thông tin")
    public void checkOpenUpdateInfoPage(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        assertThat(updateInfoStep.isDisabledInputUserName()).isFalse();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống họ tên")
    public void checkEmptyInputUserName(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống số điện thoại")
    public void checkEmptyInputUserPhone(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống số địa chỉ email")
    public void checkEmptyInputUserEmail(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên > 50 ký tự")
    public void checkInputUserNameOverLength(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(invalidData.getInputUserNameOverLength());
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên chứa chữ số")
    public void checkInputUserNameWithNumber(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(invalidData.getInputUserNameWithNumber());
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên chứa ký tự đặc biệt")
    public void checkInputUserNameWithSpecialCharacters(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(invalidData.getInputUserNameWithSpecialCharacters());
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên chỉ chứa khoảng trắng")
    public void checkInputUserNameOnlySpace(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(invalidData.getInputUserNameOnlySpace());
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại > 10 ký tự")
    public void checkInputUserPhoneOverLength(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(invalidData.getInputUserPhoneOverLength());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại < 10 ký tự")
    public void checkInputUserPhoneTooShort(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(invalidData.getInputUserPhoneTooShort());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại chứa chữ cái")
    public void checkInputUserPhoneWithAlphabet(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(invalidData.getInputUserPhoneWithAlphabet());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại chứa ký tự đặc biệt")
    public void checkInputUserPhoneWithSpecialCharacters(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(invalidData.getInputUserPhoneWithSpecialCharacters());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại chỉ chứa khoảng trắng")
    public void checkInputUserPhoneOnlySpace(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(invalidData.getInputUserPhoneOnlySpace());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email > 255 ký tự")
    public void checkInputUserEmailOverLength(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.inputUserEmail(invalidData.getInputUserEmailOverLength());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email chứa ký tự đặc biệt")
    public void checkInputUserEmailWithSpecialCharacters(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.inputUserEmail(invalidData.getInputUserEmailWithSpecialCharacters());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email với đuôi không phải @gmail.com")
    public void checkInputUserEmailIncorrectExtension(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.inputUserEmail(invalidData.getInputUserEmailIncorrectExtension());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email với đầu chỉ chứa khoảng trắng")
    public void checkInputUserEmailHeaderIsSpace(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.inputUserEmail(invalidData.getInputUserEmailHeaderIsSpace());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bấm nút trở về")
    public void checkClickButtonBack(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clickButtonBack();
        assertThat(showInfoStep.isDisabledInputUserName()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bấm nút đăng xuất")
    public void checkClickButtonLogin(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clickButtonLogout();
        assertThat(loginStep.isTitleVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra đăng ký thành công")
    public void checkRegisterSuccess(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        updateInfoStep.clearUserName();
        updateInfoStep.clearUserPhone();
        updateInfoStep.clearUserEmail();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(showInfoStep.isNotiUpdateSuccessVisible()).isTrue();
    }
}
