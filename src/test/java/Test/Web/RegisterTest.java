package Test.Web;

import Action.LoginStep;
import Action.RegisterStep;
import Common.*;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ExtendWith(SerenityJUnit5Extension.class)
public class RegisterTest {
    private static Data data;
    private static RegisterData registerData;
    private static InvalidData invalidData;

    public RegisterTest() throws IOException {
        data = JsonDataReader.getTestData();
        registerData = data.getRegisterData();
        invalidData = data.getInvalidData();
    }

    @Steps
    LoginStep loginStep;

    @Steps
    RegisterStep registerStep;

    @Test
    @DisplayName("Kiểm tra hiển thị trang đăng ký")
    public void checkOpenRegisterPage(){
        registerStep.openRegisterPage();
        assertThat(registerStep.isTitleVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống họ tên")
    public void checkEmptyInputUserName(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống số điện thoại")
    public void checkEmptyInputUserPhone(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống số địa chỉ email")
    public void checkEmptyInputUserEmail(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống tên đăng nhập")
    public void checkEmptyInputUserAccount(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống mật khẩu")
    public void checkEmptyInputUserPassword(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidPasswordVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống nhập lại mật khẩu")
    public void checkEmptyInputUserConfirmPassword(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidConfirmPasswordVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên > 50 ký tự")
    public void checkInputUserNameOverLength(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(invalidData.getInputUserNameOverLength());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên chứa chữ số")
    public void checkInputUserNameWithNumber(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(invalidData.getInputUserNameWithNumber());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên chứa ký tự đặc biệt")
    public void checkInputUserNameWithSpecialCharacters(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(invalidData.getInputUserNameWithSpecialCharacters());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên chỉ chứa khoảng trắng")
    public void checkInputUserNameOnlySpace(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(invalidData.getInputUserNameOnlySpace());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại > 10 ký tự")
    public void checkInputUserPhoneOverLength(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(invalidData.getInputUserPhoneOverLength());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại < 10 ký tự")
    public void checkInputUserPhoneTooShort(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(invalidData.getInputUserPhoneTooShort());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại chứa chữ cái")
    public void checkInputUserPhoneWithAlphabet(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(invalidData.getInputUserPhoneWithAlphabet());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại chứa ký tự đặc biệt")
    public void checkInputUserPhoneWithSpecialCharacters(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(invalidData.getInputUserPhoneWithSpecialCharacters());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại chỉ chứa khoảng trắng")
    public void checkInputUserPhoneOnlySpace(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(invalidData.getInputUserPhoneOnlySpace());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email > 255 ký tự")
    public void checkInputUserEmailOverLength(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(invalidData.getInputUserEmailOverLength());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email chứa ký tự đặc biệt")
    public void checkInputUserEmailWithSpecialCharacters(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(invalidData.getInputUserEmailWithSpecialCharacters());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email với đuôi không phải @gmail.com")
    public void checkInputUserEmailIncorrectExtension(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(invalidData.getInputUserEmailIncorrectExtension());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email với đầu chỉ chứa khoảng trắng")
    public void checkInputUserEmailHeaderIsSpace(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(invalidData.getInputUserEmailHeaderIsSpace());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập tên đăng nhập đã tồn tại")
    public void checkInputUserAccountExists(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(invalidData.getInputUserAccountExists());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiAccountExistsVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập tên đăng nhập > 30 ký tự")
    public void checkInputUserAccountOverLength(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(invalidData.getInputUserAccountOverLength());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập tên đăng nhập < 6 ký tự")
    public void checkInputUserAccountTooShort(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(invalidData.getInputUserAccountTooShort());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập tên đăng nhập bắt đầu bằng chữ số")
    public void checkInputUserAccountStartWithNumber(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(invalidData.getInputUserAccountStartWithNumber());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập tên đăng nhập chứa ký tự đặc biệt")
    public void checkInputUserAccountWithSpecialCharacters(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(invalidData.getInputUserAccountWithSpecialCharacters());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập tên đăng nhập chỉ chứa khoảng trắng")
    public void checkInputUserAccountOnlySpace(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(invalidData.getInputUserAccountOnlySpace());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập mật khẩu > 30 ký tự")
    public void checkInputUserPasswordOverLength(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(invalidData.getInputUserPasswordOverLength());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidPasswordVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập mật khẩu < 6 ký tự")
    public void checkInputUserPasswordTooShort(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(invalidData.getInputUserPasswordTooShort());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidPasswordVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập mật khẩu chỉ chứa khoảng trắng")
    public void checkInputUserPasswordOnlySpace(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(invalidData.getInputUserPasswordOnlySpace());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidPasswordVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập lại mật khẩu không khớp")
    public void checkInputUserPasswordWrong(){
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(registerData.getInputUserAccount());
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(invalidData.getInputUserPasswordWrong());
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidConfirmPasswordVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bấm nút đăng nhập")
    public void checkClickButtonLogin(){
        registerStep.openRegisterPage();
        registerStep.clickButtonLogin();
        assertThat(loginStep.isTitleVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra đăng ký thành công")
    public void checkRegisterSuccess(){
        String account = "A" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        registerStep.openRegisterPage();
        registerStep.clearUserName();
        registerStep.clearUserPhone();
        registerStep.clearUserEmail();
        registerStep.clearUserAccount();
        registerStep.clearUserPassword();
        registerStep.clearUserConfirmPassword();
        registerStep.inputUserName(registerData.getInputUserName());
        registerStep.inputUserPhone(registerData.getInputUserPhone());
        registerStep.inputUserEmail(registerData.getInputUserEmail());
        registerStep.inputUserAccount(account);
        registerStep.inputUserPassword(registerData.getInputUserPassword());
        registerStep.inputUserConfirmPassword(registerData.getInputUserConfirmPassword());
        registerStep.clickButtonRegister();
        assertThat(loginStep.isNotiRegisterSuccessVisible()).isTrue();
    }
}
