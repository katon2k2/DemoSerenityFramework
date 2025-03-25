package Test.Web;

import Action.LoginStep;
import Action.RegisterStep;
import Common.*;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegisterTest {
    private static DataWeb data;

    public RegisterTest() throws IOException {
        data = JsonDataReader.getTestDataWeb("src/test/resources/DataWeb.json");
    }

    @Steps
    LoginStep loginStep;

    @Steps
    RegisterStep registerStep;

    @Test
    @Order(1)
    @DisplayName("Kiểm tra hiển thị trang đăng ký")
    public void checkOpenRegisterPage(){
        registerStep.openRegisterPage();
        assertThat(registerStep.isTitleVisible()).isTrue();
    }

    @Test
    @Order(2)
    @DisplayName("kiểm tra đăng ký thành công")
    public void checkRegisterSuccess() throws SQLException {
        String account = "A" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(account);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        if(loginStep.isNotiRegisterSuccessVisible()){
            MySqlConnection.connection = MySqlConnection.getConnection(data.mySqlData.Url, data.mySqlData.Account, data.mySqlData.Password);
            MySqlConnection.statement = MySqlConnection.connection.createStatement();
            assertThat(MySqlConnection.getResultQuery("SELECT id FROM users WHERE name LIKE '" +data.registerData.InputUserName+ "' AND phone LIKE '"+data.registerData.InputUserPhone+"' AND email LIKE '"+data.registerData.InputUserEmail+"' AND account LIKE '"+account+"'").next()).isTrue();
            MySqlConnection.closeConnection();
        }
    }

    @Test
    @DisplayName("kiểm tra bỏ trống họ tên")
    public void checkEmptyInputUserName(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống số điện thoại")
    public void checkEmptyInputUserPhone(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống số địa chỉ email")
    public void checkEmptyInputUserEmail(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống tên đăng nhập")
    public void checkEmptyInputUserAccount(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống mật khẩu")
    public void checkEmptyInputUserPassword(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidPasswordVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống nhập lại mật khẩu")
    public void checkEmptyInputUserConfirmPassword(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidConfirmPasswordVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên > 50 ký tự")
    public void checkInputUserNameOverLength(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.invalidData.inputUserNameOverLength);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên chứa chữ số")
    public void checkInputUserNameWithNumber(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.invalidData.inputUserNameWithNumber);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên chứa ký tự đặc biệt")
    public void checkInputUserNameWithSpecialCharacters(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.invalidData.inputUserNameWithSpecialCharacters);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên chỉ chứa khoảng trắng")
    public void checkInputUserNameOnlySpace(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.invalidData.inputUserNameOnlySpace);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại > 10 ký tự")
    public void checkInputUserPhoneOverLength(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.invalidData.inputUserPhoneOverLength);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại < 10 ký tự")
    public void checkInputUserPhoneTooShort(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.invalidData.inputUserPhoneTooShort);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại chứa chữ cái")
    public void checkInputUserPhoneWithAlphabet(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.invalidData.inputUserPhoneWithAlphabet);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại chứa ký tự đặc biệt")
    public void checkInputUserPhoneWithSpecialCharacters(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.invalidData.inputUserPhoneWithSpecialCharacters);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại chỉ chứa khoảng trắng")
    public void checkInputUserPhoneOnlySpace(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.invalidData.inputUserPhoneOnlySpace);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email > 255 ký tự")
    public void checkInputUserEmailOverLength(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.invalidData.inputUserEmailOverLength);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email chứa ký tự đặc biệt")
    public void checkInputUserEmailWithSpecialCharacters(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.invalidData.inputUserEmailWithSpecialCharacters);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email với đuôi không phải @gmail.com")
    public void checkInputUserEmailIncorrectExtension(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.invalidData.inputUserEmailIncorrectExtension);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email với đầu chỉ chứa khoảng trắng")
    public void checkInputUserEmailHeaderIsSpace(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.invalidData.inputUserEmailHeaderIsSpace);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập tên đăng nhập đã tồn tại")
    public void checkInputUserAccountExists(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.invalidData.inputUserAccountExists);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiAccountExistsVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập tên đăng nhập > 30 ký tự")
    public void checkInputUserAccountOverLength(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.invalidData.inputUserAccountOverLength);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập tên đăng nhập < 6 ký tự")
    public void checkInputUserAccountTooShort(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.invalidData.inputUserAccountTooShort);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập tên đăng nhập bắt đầu bằng chữ số")
    public void checkInputUserAccountStartWithNumber(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.invalidData.inputUserAccountStartWithNumber);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập tên đăng nhập chứa ký tự đặc biệt")
    public void checkInputUserAccountWithSpecialCharacters(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.invalidData.inputUserAccountWithSpecialCharacters);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập tên đăng nhập chỉ chứa khoảng trắng")
    public void checkInputUserAccountOnlySpace(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.invalidData.inputUserAccountOnlySpace);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập mật khẩu > 30 ký tự")
    public void checkInputUserPasswordOverLength(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.invalidData.inputUserPasswordOverLength);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidPasswordVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập mật khẩu < 6 ký tự")
    public void checkInputUserPasswordTooShort(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.invalidData.inputUserPasswordTooShort);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidPasswordVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập mật khẩu chỉ chứa khoảng trắng")
    public void checkInputUserPasswordOnlySpace(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.invalidData.inputUserPasswordOnlySpace);
        registerStep.inputUserConfirmPassword(data.registerData.InputUserConfirmPassword);
        registerStep.clickButtonRegister();
        assertThat(registerStep.isNotiInvalidPasswordVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập lại mật khẩu không khớp")
    public void checkInputUserPasswordWrong(){
        registerStep.openRegisterPage();
        registerStep.clearInput();
        registerStep.inputUserName(data.registerData.InputUserName);
        registerStep.inputUserPhone(data.registerData.InputUserPhone);
        registerStep.inputUserEmail(data.registerData.InputUserEmail);
        registerStep.inputUserAccount(data.registerData.InputUserAccount);
        registerStep.inputUserPassword(data.registerData.InputUserPassword);
        registerStep.inputUserConfirmPassword(data.invalidData.inputUserPasswordWrong);
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
}
