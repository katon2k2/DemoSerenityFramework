package Page;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ShowInfoPage extends PageObject{
    public static final By Title = By.xpath("//b[normalize-space()='DemoApp']");
    public static final By InputUserName = By.xpath("//input[@id='InputUserName']");
    public static final By ButtonLogout = By.xpath("//form[@id='FormLogout']//button[@type='submit']");
    public static final By ButtonUpdate = By.xpath("//div[@class='ButtonUpdate']//button[@type='submit']");
    public static final By NotiUpdateSuccess = By.xpath("//label[contains(text(),'Cập nhật thông tin thành công')]");
}
