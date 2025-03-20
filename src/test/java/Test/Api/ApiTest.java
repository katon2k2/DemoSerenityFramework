package Test.Api;

import Common.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiTest {
    private static String token;
    private static Data data;
    private static LoginData loginData;
    private static RegisterData registerData;
    private static UpdateData updateData;

    public ApiTest() throws IOException {
        data = JsonDataReader.getTestData();
        loginData = data.getLoginData();
        registerData = data.getRegisterData();
        updateData = data.getUpdateData();
    }

    @Test
    @Order(1)
    @DisplayName("kiểm tra api đăng ký tài khoản")
    public void apiRegister(){
        String message = RestAssured.given()
                .baseUri("http://127.0.0.1:8000/api")
                .contentType(ContentType.JSON)
                .body(registerData)
                .when().post("/register")
                .then().statusCode(201)
                .extract().jsonPath().getString("message");
        assertThat(message).isEqualTo("Đăng ký tài khoản thành công");
    }

    @Test
    @Order(1)
    @DisplayName("kiểm tra api đăng nhập")
    public void apiLogin(){
        JsonPath response = RestAssured.given()
                .baseUri("http://127.0.0.1:8000/api")
                .contentType(ContentType.JSON)
                .body(loginData)
                .when().post("/login")
                .then().statusCode(200)
                .extract().jsonPath();
        token = response.getString("token");
    }

    @Test
    @Order(2)
    @DisplayName("kiểm tra api hiển thị thông tin tài khoản")
    public void apiShowInfo(){
        String message = RestAssured.given()
                .baseUri("http://127.0.0.1:8000/api")
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .when().get("/user/show")
                .then().statusCode(200)
                .extract().jsonPath().getString("message");
        assertThat(message).isEqualTo("Thông tin tài khoản");
    }

    @Test
    @Order(3)
    @DisplayName("kiểm tra api cập nhật thông tin tài khoản")
    public void apiUpdateInfo(){
        String message = RestAssured.given()
                .baseUri("http://127.0.0.1:8000/api")
                .basePath("/user/update")
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(updateData)
                .when().put()
                .then().statusCode(200)
                .extract().jsonPath().getString("message");
        assertThat(message).isEqualTo("Cập nhật thông tin thành công");
    }

    @Test
    @Order(4)
    @DisplayName("kiểm tra api xóa tài khoản")
    public void apiDeleteInfo(){
        String message = RestAssured.given()
                .baseUri("http://127.0.0.1:8000/api")
                .basePath("/user/delete")
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .when().delete()
                .then().statusCode(200)
                .extract().jsonPath().getString("message");
        assertThat(message).isEqualTo("Xóa tài khoản thành công");
    }
}
