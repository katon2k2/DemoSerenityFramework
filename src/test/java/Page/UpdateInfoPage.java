package Page;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class UpdateInfoPage extends PageObject{
    public static final By InputUserName = By.xpath("//input[@id='InputUserName']");
    public static final By InputUserPhone = By.xpath("//input[@id='InputUserPhone']");
    public static final By InputUserEmail = By.xpath("//input[@id='InputUserEmail']");
    public static final By ButtonLogout = By.xpath("//form[@id='FormLogout']//button[@type='submit']");
    public static final By ButtonBack = By.xpath("//div[@class='ButtonBack']//a");
    public static final By ButtonSave = By.xpath("//button[@onclick='showConfirmUpdate()']");
    public static final By ButtonAgree = By.xpath("//button[contains(text(),'Đồng ý')]");
    public static final By ButtonCancel = By.xpath("//button[normalize-space()='Thoát']");
    public static final By NotiInvalidUserName = By.xpath("//label[contains(text(),'Họ tên không hợp lệ. Họ tên không được chứa chữ số')]");
    public static final By NotiInvalidUserPhone = By.xpath("//label[contains(text(),'Số điện thoại không hợp lệ. Số điện thoại chỉ được')]");
    public static final By NotiInvalidUserEmail = By.xpath("//label[contains(text(),'Địa chỉ email không hợp lệ. Địa chỉ email phải có ')]");
}
