package Test.Web;

import Action.LoginStep;
import Action.ShowInfoStep;
import Action.UpdateInfoStep;
import Common.*;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;
import java.sql.SQLException;

@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UpdateInfoTest {
    private static DataWeb data;

    public UpdateInfoTest() throws IOException {
        data = JsonDataReader.getTestDataWeb("src/test/resources/DataWeb.json");
    }

    @Steps
    LoginStep loginStep;

    @Steps
    ShowInfoStep showInfoStep;

    @Steps
    UpdateInfoStep updateInfoStep;

    @BeforeEach
    @DisplayName("đăng nhập và mở trang cập nhật thông tin")
    public void checkLoginSuccess(){
        loginStep.openLoginPage();
        loginStep.clearInput();
        loginStep.inputAccount(data.loginData.InputUserAccount);
        loginStep.inputPassword(data.loginData.InputUserPassword);
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
    }

    @Test
    @Order(1)
    @DisplayName("Kiểm tra hiển thị trang cập nhật thông tin")
    public void checkOpenUpdateInfoPage() throws SQLException {
        assertThat(updateInfoStep.isDisabledInputUserName()).isFalse();
    }

    @Test
    @Order(2)
    @DisplayName("kiểm tra cập nhật thông tin thành công")
    public void checkUpdateInfoSuccess() throws SQLException {
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.updateData.InputUserName);
        updateInfoStep.inputUserPhone(data.updateData.InputUserPhone);
        updateInfoStep.inputUserEmail(data.updateData.InputUserEmail);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        if(showInfoStep.isNotiUpdateSuccessVisible()){
            MySqlConnection.connection = MySqlConnection.getConnection(data.mySqlData.Url, data.mySqlData.Account, data.mySqlData.Password);
            MySqlConnection.statement = MySqlConnection.connection.createStatement();
            assertThat(MySqlConnection.getResultQuery("SELECT id FROM `users` WHERE account LIKE '"+ data.loginData.InputUserAccount +"' AND name LIKE '"+ data.updateData.InputUserName +"' AND phone LIKE '"+ data.updateData.InputUserPhone +"' AND email LIKE '"+ data.updateData.InputUserEmail +"'").next()).isTrue();
            MySqlConnection.closeConnection();
        }
    }

    @Test
    @DisplayName("kiểm tra bỏ trống họ tên")
    public void checkEmptyInputUserName(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserPhone(data.updateData.InputUserPhone);
        updateInfoStep.inputUserEmail(data.updateData.InputUserEmail);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống số điện thoại")
    public void checkEmptyInputUserPhone(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.updateData.InputUserName);
        updateInfoStep.inputUserEmail(data.updateData.InputUserEmail);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống số địa chỉ email")
    public void checkEmptyInputUserEmail(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.updateData.InputUserName);
        updateInfoStep.inputUserPhone(data.updateData.InputUserPhone);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên > 50 ký tự")
    public void checkInputUserNameOverLength(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.invalidData.inputUserNameOverLength);
        updateInfoStep.inputUserPhone(data.updateData.InputUserPhone);
        updateInfoStep.inputUserEmail(data.updateData.InputUserEmail);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên chứa chữ số")
    public void checkInputUserNameWithNumber(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.invalidData.inputUserNameWithNumber);
        updateInfoStep.inputUserPhone(data.updateData.InputUserPhone);
        updateInfoStep.inputUserEmail(data.updateData.InputUserEmail);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên chứa ký tự đặc biệt")
    public void checkInputUserNameWithSpecialCharacters(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.invalidData.inputUserNameWithSpecialCharacters);
        updateInfoStep.inputUserPhone(data.updateData.InputUserPhone);
        updateInfoStep.inputUserEmail(data.updateData.InputUserEmail);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên chỉ chứa khoảng trắng")
    public void checkInputUserNameOnlySpace(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.invalidData.inputUserNameOnlySpace);
        updateInfoStep.inputUserPhone(data.updateData.InputUserPhone);
        updateInfoStep.inputUserEmail(data.updateData.InputUserEmail);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại > 10 ký tự")
    public void checkInputUserPhoneOverLength(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.updateData.InputUserName);
        updateInfoStep.inputUserPhone(data.invalidData.inputUserPhoneOverLength);
        updateInfoStep.inputUserEmail(data.updateData.InputUserEmail);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại < 10 ký tự")
    public void checkInputUserPhoneTooShort(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.updateData.InputUserName);
        updateInfoStep.inputUserPhone(data.invalidData.inputUserPhoneTooShort);
        updateInfoStep.inputUserEmail(data.updateData.InputUserEmail);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại chứa chữ cái")
    public void checkInputUserPhoneWithAlphabet(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.updateData.InputUserName);
        updateInfoStep.inputUserPhone(data.invalidData.inputUserPhoneWithAlphabet);
        updateInfoStep.inputUserEmail(data.updateData.InputUserEmail);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại chứa ký tự đặc biệt")
    public void checkInputUserPhoneWithSpecialCharacters(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.updateData.InputUserName);
        updateInfoStep.inputUserPhone(data.invalidData.inputUserPhoneWithSpecialCharacters);
        updateInfoStep.inputUserEmail(data.updateData.InputUserEmail);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập số điện thoại chỉ chứa khoảng trắng")
    public void checkInputUserPhoneOnlySpace(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.updateData.InputUserName);
        updateInfoStep.inputUserPhone(data.invalidData.inputUserPhoneOnlySpace);
        updateInfoStep.inputUserEmail(data.updateData.InputUserEmail);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email > 255 ký tự")
    public void checkInputUserEmailOverLength(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.updateData.InputUserName);
        updateInfoStep.inputUserPhone(data.updateData.InputUserPhone);
        updateInfoStep.inputUserEmail(data.invalidData.inputUserEmailOverLength);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email chứa ký tự đặc biệt")
    public void checkInputUserEmailWithSpecialCharacters(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.updateData.InputUserName);
        updateInfoStep.inputUserPhone(data.updateData.InputUserPhone);
        updateInfoStep.inputUserEmail(data.invalidData.inputUserEmailWithSpecialCharacters);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email với đuôi không phải @gmail.com")
    public void checkInputUserEmailIncorrectExtension(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.updateData.InputUserName);
        updateInfoStep.inputUserPhone(data.updateData.InputUserPhone);
        updateInfoStep.inputUserEmail(data.invalidData.inputUserEmailIncorrectExtension);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập email với đầu chỉ chứa khoảng trắng")
    public void checkInputUserEmailHeaderIsSpace(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(data.updateData.InputUserName);
        updateInfoStep.inputUserPhone(data.updateData.InputUserPhone);
        updateInfoStep.inputUserEmail(data.invalidData.inputUserEmailHeaderIsSpace);
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bấm nút trở về")
    public void checkClickButtonBack(){
        updateInfoStep.clickButtonBack();
        assertThat(showInfoStep.isDisabledInputUserName()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bấm nút đăng xuất")
    public void checkClickButtonLogin(){
        updateInfoStep.clickButtonLogout();
        assertThat(loginStep.isTitleVisible()).isTrue();
    }
}
