package Test.Web;

import Action.LoginStep;
import Action.ShowInfoStep;
import Common.Data;
import Common.InvalidData;
import Common.JsonDataReader;
import Common.LoginData;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;

@ExtendWith(SerenityJUnit5Extension.class)
public class ShowInfoTest {
    private static Data data;
    private static LoginData loginData;
    private static InvalidData invalidData;

    public ShowInfoTest() throws IOException {
        data = JsonDataReader.getTestData();
        loginData = data.getLoginData();
        invalidData = data.getInvalidData();
    }

    @Steps
    LoginStep loginStep;

    @Steps
    ShowInfoStep showInfoStep;

    @Test
    @DisplayName("kiểm tra hiển thị trang hiển thị thông tin")
    public void checkOpenShowInfoPage(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        assertThat(showInfoStep.isTitleVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bấm nút cập nhật")
    public void checkClickButtonUpdate(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonUpdate();
        assertThat(showInfoStep.isDisabledInputUserName()).isFalse();
    }

    @Test
    @DisplayName("kiểm tra bấm nút đăng xuất")
    public void checkClickButtonLogout(){
        loginStep.openLoginPage();
        loginStep.clearAccount();
        loginStep.clearPassword();
        loginStep.inputAccount(loginData.getInputUserAccount());
        loginStep.inputPassword(loginData.getInputUserPassword());
        loginStep.clickButtonLogin();
        showInfoStep.clickButtonLogout();
        assertThat(loginStep.isTitleVisible()).isTrue();
    }
}
