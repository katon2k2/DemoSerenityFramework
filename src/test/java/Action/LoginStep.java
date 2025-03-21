package Action;

import Page.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import java.time.Duration;

public class LoginStep extends UIInteractionSteps {
    private LoginPage loginPage;

    @Step("truy cập trang đăng nhập")
    public void openLoginPage() {
        loginPage.open();
    }

    @Step("nhập tài khoản")
    public void inputAccount(String value) {
        find(loginPage.InputUserAccount).sendKeys(value);
    }

    @Step("nhập mật khẩu")
    public void inputPassword(String value) {
        find(loginPage.InputUserPassword).sendKeys(value);
    }

    @Step("xóa dữ liệu ô nhập")
    public void clearInput() {
        find(loginPage.InputUserAccount).clear();
        find(loginPage.InputUserPassword).clear();
    }

    @Step("bấm nút đăng nhập")
    public void clickButtonLogin() {
        find(loginPage.ButtonLogin).click();
    }

    @Step("bấm nút đăng ký")
    public void clickButtonRegister() {
        find(loginPage.ButtonRegister).click();
    }

    @Step("kiểm tra hiển thị tiêu đề trang đăng nhập")
    public boolean isTitleVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(LoginPage.Title).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo để trống tài khoản hoặc mật khẩu")
    public boolean isNotiEmptyInputVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(LoginPage.NotiEmptyInput).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo nhập sai tài khoản hoặc mật khẩu")
    public boolean isNotiWrongAccountVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(LoginPage.NotiWrongAccount).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo đăng ký tài khoản thành công")
    public boolean isNotiRegisterSuccessVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(LoginPage.NotiRegisterSuccess).isVisible();
    }
}
