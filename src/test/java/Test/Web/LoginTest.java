package Test.Web;

import Action.LoginStep;
import Action.RegisterStep;
import Action.ShowInfoStep;
import Common.Data;
import Common.InvalidData;
import Common.JsonDataReader;
import Common.LoginData;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;

@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {
    private static Data data;
    private static LoginData loginData;
    private static InvalidData invalidData;

    public LoginTest() throws IOException {
        data = JsonDataReader.getTestData();
        loginData = data.getLoginData();
        invalidData = data.getInvalidData();
    }

    @Steps
    LoginStep loginStep;

    @Steps
    RegisterStep register;

    @Steps
    ShowInfoStep showInfoStep;

    @Test
    @Order(1)
    @DisplayName("Kiểm tra hiển thị trang đăng nhập")
    public void checkOpenLoginPage(){
        loginStep.openLoginPage();
        assertThat(loginStep.isTitleVisible()).isTrue();
    }

    @Test
    @Order(2)
    @DisplayName("kiểm tra đăng nhập thành công")
    public void checkLoginSuccess(){
        loginStep.openLoginPage();
        loginStep.clearInput();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        assertThat(showInfoStep.isTitleVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống tài khoản")
    public void checkEmptyInputAccount(){
        loginStep.openLoginPage();
        loginStep.clearInput();
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        assertThat(loginStep.isNotiEmptyInputVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bỏ trống mật khẩu")
    public void checkEmptyInputPassword(){
        loginStep.openLoginPage();
        loginStep.clearInput();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.clickButtonLogin();
        assertThat(loginStep.isNotiEmptyInputVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập sai tài khoản")
    public void checkWrongInputAccount(){
        loginStep.openLoginPage();
        loginStep.clearInput();
        loginStep.inputAccount(invalidData.getInputUserAccountWrong());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        assertThat(loginStep.isNotiWrongAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra nhập sai mật khẩu")
    public void checkWrongInputPassword(){
        loginStep.openLoginPage();
        loginStep.clearInput();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(invalidData.getInputUserPasswordWrong());
        loginStep.clickButtonLogin();
        assertThat(loginStep.isNotiWrongAccountVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bấm nút đăng ký")
    public void checkClickButtonRegister(){
        loginStep.openLoginPage();
        loginStep.clickButtonRegister();
        assertThat(register.isTitleVisible()).isTrue();
    }
}
