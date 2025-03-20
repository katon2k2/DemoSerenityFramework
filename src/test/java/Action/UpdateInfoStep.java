package Action;

import Page.UpdateInfoPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import java.time.Duration;

public class UpdateInfoStep extends UIInteractionSteps {
    @Step("nhập họ tên")
    public void inputUserName(String value) {
        find(UpdateInfoPage.InputUserName).sendKeys(value);
    }

    @Step("nhập số điện thoại")
    public void inputUserPhone(String value) {
        find(UpdateInfoPage.InputUserPhone).sendKeys(value);
    }

    @Step("nhập địa chỉ email")
    public void inputUserEmail(String value) {
        find(UpdateInfoPage.InputUserEmail).sendKeys(value);
    }

    @Step("xóa họ tên")
    public void clearUserName() {
        find(UpdateInfoPage.InputUserName).clear();
    }

    @Step("xóa số điện thoại")
    public void clearUserPhone() {
        find(UpdateInfoPage.InputUserPhone).clear();
    }

    @Step("xóa địa chỉ email")
    public void clearUserEmail() {
        find(UpdateInfoPage.InputUserEmail).clear();
    }

    @Step("bấm nút trở về")
    public void clickButtonBack() {
        find(UpdateInfoPage.ButtonBack).click();
    }

    @Step("bấm nút lưu")
    public void clickButtonSave() {
        find(UpdateInfoPage.ButtonSave).click();
    }

    @Step("bấm nút đồng ý")
    public void clickButtonAgree() {
        find(UpdateInfoPage.ButtonAgree).click();
    }

    @Step("bấm nút đăng xuất")
    public void clickButtonLogout() {
        find(UpdateInfoPage.ButtonLogout).click();
    }

    @Step("kiểm tra ô nhập họ tên bị vô hiệu hóa")
    public boolean isDisabledInputUserName() {
        return find(UpdateInfoPage.InputUserName).isDisabled();
    }

    @Step("kiểm tra hiển thị thông báo họ tên không hợp lệ")
    public boolean isNotiInvalidUserNameVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(UpdateInfoPage.NotiInvalidUserName).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo số điện thoại không hợp lệ")
    public boolean isNotiInvalidUserPhoneVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(UpdateInfoPage.NotiInvalidUserPhone).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo địa chỉ email không hợp lệ")
    public boolean isNotiInvalidUserEmailVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(UpdateInfoPage.NotiInvalidUserEmail).isVisible();
    }
}
