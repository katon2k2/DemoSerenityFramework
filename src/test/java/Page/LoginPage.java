package Page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("http://demoframework.free.nf/login")
public class LoginPage extends PageObject{
    public static final By Title = By.xpath("//h1[contains(text(),'Đăng Nhập')]");
    public static final By InputUserAccount = By.xpath("//input[@id='InputUserAccount']");
    public static final By InputUserPassword = By.xpath("//input[@id='InputUserPassword']");
    public static final By ButtonLogin = By.xpath("//button[@id='ButtonLogin']");
    public static final By ButtonRegister = By.xpath("//button[@id='ButtonRegister']");
    public static final By NotiEmptyInput = By.xpath("//label[contains(text(),'Vui lòng nhập đầy đủ thông đăng nhập')]");
    public static final By NotiWrongAccount = By.xpath("//label[contains(text(),'Tên đăng nhập hoặc mật khẩu không chính xác!')]");
    public static final By NotiRegisterSuccess = By.xpath("//label[contains(text(),'Đăng ký tài khoản thành công')]");
}
