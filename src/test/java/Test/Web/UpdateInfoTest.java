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

@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    @BeforeEach
    @DisplayName("đăng nhập và mở trang cập nhật thông tin")
    public void checkLoginSuccess(){
        loginStep.openLoginPage();
        loginStep.clearInput();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
    }

    @Test
    @Order(1)
    @DisplayName("Kiểm tra hiển thị trang cập nhật thông tin")
    public void checkOpenUpdateInfoPage(){
        assertThat(updateInfoStep.isDisabledInputUserName()).isFalse();
    }

    @Test
    @Order(2)
    @DisplayName("kiểm tra cập nhật thông tin thành công")
    public void checkUpdateInfoSuccess(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(showInfoStep.isNotiUpdateSuccessVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống họ tên")
    public void checkEmptyInputUserName(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserNameVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống số điện thoại")
    public void checkEmptyInputUserPhone(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserEmail(updateData.getInputUserEmail());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserPhoneVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống số địa chỉ email")
    public void checkEmptyInputUserEmail(){
        updateInfoStep.clearInput();
        updateInfoStep.inputUserName(updateData.getInputUserName());
        updateInfoStep.inputUserPhone(updateData.getInputUserPhone());
        updateInfoStep.clickButtonSave();
        updateInfoStep.clickButtonAgree();
        assertThat(updateInfoStep.isNotiInvalidUserEmailVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập họ tên > 50 ký tự")
    public void checkInputUserNameOverLength(){
        updateInfoStep.clearInput();
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
        updateInfoStep.clearInput();
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
        updateInfoStep.clearInput();
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
        updateInfoStep.clearInput();
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
        updateInfoStep.clearInput();
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
        updateInfoStep.clearInput();
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
        updateInfoStep.clearInput();
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
        updateInfoStep.clearInput();
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
        updateInfoStep.clearInput();
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
        updateInfoStep.clearInput();
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
        updateInfoStep.clearInput();
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
        updateInfoStep.clearInput();
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
        updateInfoStep.clearInput();
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
