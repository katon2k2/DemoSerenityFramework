package Page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("http://demoframework.free.nf/register")
public class RegisterPage extends PageObject{
    public static final By Title = By.xpath("//h1[contains(text(),'Đăng Ký')]");
    public static final By InputUserName = By.xpath("//input[@id='InputUserName']");
    public static final By InputUserPhone = By.xpath("//input[@id='InputUserPhone']");
    public static final By InputUserEmail = By.xpath("//input[@id='InputUserEmail']");
    public static final By InputUserAccount = By.xpath("//input[@id='InputUserAccount']");
    public static final By InputUserPassword = By.xpath("//input[@id='InputUserPassword']");
    public static final By InputUserConfirmPassword = By.xpath("//input[@id='InputUserConfirmPassword']");
    public static final By ButtonLogin = By.xpath("//button[@id='ButtonLogin']");
    public static final By ButtonRegister = By.xpath("//button[@id='ButtonRegister']");
    public static final By NotiInvalidUserName = By.xpath("//label[contains(text(),'Họ tên không hợp lệ. Họ tên không được chứa chữ số')]");
    public static final By NotiInvalidUserPhone = By.xpath("//label[contains(text(),'Số điện thoại không hợp lệ. Số điện thoại chỉ được')]");
    public static final By NotiInvalidUserEmail = By.xpath("//label[contains(text(),'Địa chỉ email không hợp lệ. Địa chỉ email phải có ')]");
    public static final By NotiInvalidAccount = By.xpath("//label[contains(text(),'Tên đăng nhập không hợp lệ. Tên đăng nhập phải bắt')]");
    public static final By NotiAccountExists = By.xpath("//label[contains(text(),'Tên đăng nhập này đã tồn tại!')]");
    public static final By NotiInvalidPassword = By.xpath("//label[contains(text(),'Mật khẩu không hợp lệ. Mật khẩu phải có tối thiểu ')]");
    public static final By NotiInvalidConfirmPassword = By.xpath("//label[contains(text(),'Nhập lại mật khẩu không khớp.')]");
}
