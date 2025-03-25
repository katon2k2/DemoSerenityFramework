package Test.Web;

import Action.LoginStep;
import Action.ShowInfoStep;
import Common.DataWeb;
import Common.InvalidData;
import Common.JsonDataReader;
import Common.LoginData;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.assertj.core.api.Assertions.*;
import java.io.IOException;

@ExtendWith(SerenityJUnit5Extension.class)
public class ShowInfoTest {
    private static DataWeb data;

    public ShowInfoTest() throws IOException {
        data = JsonDataReader.getTestDataWeb("src/test/resources/DataWeb.json");
    }

    @Steps
    LoginStep loginStep;

    @Steps
    ShowInfoStep showInfoStep;

    @BeforeEach
    @DisplayName("đăng nhập")
    public void checkLoginSuccess(){
        loginStep.openLoginPage();
        loginStep.clearInput();
        loginStep.inputAccount(data.loginData.InputUserAccount);
        loginStep.inputPassword(data.loginData.InputUserPassword);
        loginStep.clickButtonLogin();
    }

    @Test
    @DisplayName("kiểm tra hiển thị trang hiển thị thông tin")
    public void checkOpenShowInfoPage(){
        assertThat(showInfoStep.isTitleVisible()).isTrue();
    }

    @Test
    @DisplayName("kiểm tra bấm nút cập nhật")
    public void checkClickButtonUpdate(){
        showInfoStep.clickButtonUpdate();
        assertThat(showInfoStep.isDisabledInputUserName()).isFalse();
    }

    @Test
    @DisplayName("kiểm tra bấm nút đăng xuất")
    public void checkClickButtonLogout(){
        showInfoStep.clickButtonLogout();
        assertThat(loginStep.isTitleVisible()).isTrue();
    }
}
