package Action;

import Page.LoginPage;
import Page.RegisterPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import java.time.Duration;

public class RegisterStep extends UIInteractionSteps {
    private RegisterPage registerPage;

    @Step("truy cập trang đăng ký")
    public void openRegisterPage() {
        registerPage.open();
    }

    @Step("nhập họ tên")
    public void inputUserName(String value) {
        find(registerPage.InputUserName).sendKeys(value);
    }

    @Step("nhập số điện thoại")
    public void inputUserPhone(String value) {
        find(registerPage.InputUserPhone).sendKeys(value);
    }

    @Step("nhập địa chỉ email")
    public void inputUserEmail(String value) {
        find(registerPage.InputUserEmail).sendKeys(value);
    }

    @Step("nhập tài khoản đăng nhập")
    public void inputUserAccount(String value) {
        find(registerPage.InputUserAccount).sendKeys(value);
    }

    @Step("nhập mật khẩu")
    public void inputUserPassword(String value) {
        find(registerPage.InputUserPassword).sendKeys(value);
    }

    @Step("nhập lại mật khẩu")
    public void inputUserConfirmPassword(String value) {
        find(registerPage.InputUserConfirmPassword).sendKeys(value);
    }

    @Step("xóa họ tên")
    public void clearUserName() {
        find(registerPage.InputUserName).clear();
    }

    @Step("xóa số điện thoại")
    public void clearUserPhone() {
        find(registerPage.InputUserPhone).clear();
    }

    @Step("xóa địa chỉ email")
    public void clearUserEmail() {
        find(registerPage.InputUserEmail).clear();
    }

    @Step("xóa tài khoản đăng xóa")
    public void clearUserAccount() {
        find(registerPage.InputUserAccount).clear();
    }

    @Step("xóa mật khẩu")
    public void clearUserPassword() {
        find(registerPage.InputUserPassword).clear();
    }

    @Step("xóa nhập lại mật khẩu")
    public void clearUserConfirmPassword() {
        find(registerPage.InputUserConfirmPassword).clear();
    }

    @Step("bấm nút đăng nhập")
    public void clickButtonLogin() {
        find(registerPage.ButtonLogin).click();
    }

    @Step("bấm nút đăng ký")
    public void clickButtonRegister() {
        find(registerPage.ButtonRegister).click();
    }

    @Step("kiểm tra hiển thị tiêu đề trang đăng ký")
    public boolean isTitleVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(RegisterPage.Title).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo họ tên không hợp lệ")
    public boolean isNotiInvalidUserNameVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(RegisterPage.NotiInvalidUserName).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo số điện thoại không hợp lệ")
    public boolean isNotiInvalidUserPhoneVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(RegisterPage.NotiInvalidUserPhone).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo địa chỉ email không hợp lệ")
    public boolean isNotiInvalidUserEmailVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(RegisterPage.NotiInvalidUserEmail).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo tài khoản không hợp lệ")
    public boolean isNotiInvalidAccountVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(RegisterPage.NotiInvalidAccount).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo tài khoản đã tồn tại")
    public boolean isNotiAccountExistsVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(RegisterPage.NotiAccountExists).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo mật khẩu không hợp lệ")
    public boolean isNotiInvalidPasswordVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(RegisterPage.NotiInvalidPassword).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo nhập lại mật khẩu không hợp lệ")
    public boolean isNotiInvalidConfirmPasswordVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(RegisterPage.NotiInvalidConfirmPassword).isVisible();
    }
}
