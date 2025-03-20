package Action;

import Page.ShowInfoPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import java.time.Duration;

public class ShowInfoStep extends UIInteractionSteps {
    private ShowInfoPage showInfoPage;

    @Step("bấm nút cập nhật")
    public void clickButtonUpdate() {
        find(showInfoPage.ButtonUpdate).click();
    }

    @Step("bấm nút đăng xuất")
    public void clickButtonLogout() {
        find(showInfoPage.ButtonLogout).click();
    }

    @Step("kiểm tra ô nhập họ tên bị vô hiệu hóa")
    public boolean isDisabledInputUserName() {
        return find(showInfoPage.InputUserName).isDisabled();
    }

    @Step("kiểm tra hiển thị tiêu đề trang hiển thị thông tin")
    public boolean isTitleVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(showInfoPage.Title).isVisible();
    }

    @Step("kiểm tra hiển thị thông báo cập nhật thông tin tài khoản thành công")
    public boolean isNotiUpdateSuccessVisible() {
        return withTimeoutOf(Duration.ofSeconds(5)).waitFor(showInfoPage.NotiUpdateSuccess).isVisible();
    }
}
