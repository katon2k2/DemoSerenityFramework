package Test.Api;

import Common.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.IOException;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiTest {
    private static String token;
    private static DataApi data;

    public ApiTest() throws IOException {
        data = JsonDataReader.getTestDataApi("src/test/resources/DataApi.json");
    }

    @Test
    @Order(1)
    @DisplayName("kiểm tra api đăng ký tài khoản")
    public void apiRegister() throws SQLException {
        String message = RestAssured.given()
                .baseUri("http://127.0.0.1:8000/api")
                .contentType(ContentType.JSON)
                .body(data.registerData)
                .when().post("/register")
                .then().statusCode(201)
                .extract().jsonPath().getString("message");
        if (message.equals("Đăng ký tài khoản thành công")){
            MySqlConnection.connection = MySqlConnection.getConnection(data.mySqlData.Url, data.mySqlData.Account, data.mySqlData.Password);
            MySqlConnection.statement = MySqlConnection.connection.createStatement();
            assertThat(MySqlConnection.getResultQuery("SELECT id FROM users WHERE name LIKE '" +data.registerData.InputUserName+ "' AND phone LIKE '"+data.registerData.InputUserPhone+"' AND email LIKE '"+data.registerData.InputUserEmail+"' AND account LIKE '"+data.registerData.InputUserAccount+"'").next()).isTrue();
            MySqlConnection.closeConnection();
        }
    }

    @Test
    @Order(1)
    @DisplayName("kiểm tra api đăng nhập")
    public void apiLogin(){
        JsonPath response = RestAssured.given()
                .baseUri("http://127.0.0.1:8000/api")
                .contentType(ContentType.JSON)
                .body(data.loginData)
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
    public void apiUpdateInfo() throws SQLException {
        String message = RestAssured.given()
                .baseUri("http://127.0.0.1:8000/api")
                .basePath("/user/update")
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .body(data.updateData)
                .when().put()
                .then().statusCode(200)
                .extract().jsonPath().getString("message");
        if (message.equals("Cập nhật thông tin thành công")){
            MySqlConnection.connection = MySqlConnection.getConnection(data.mySqlData.Url, data.mySqlData.Account, data.mySqlData.Password);
            MySqlConnection.statement = MySqlConnection.connection.createStatement();
            assertThat(MySqlConnection.getResultQuery("SELECT id FROM `users` WHERE account LIKE '"+ data.loginData.InputUserAccount +"' AND name LIKE '"+ data.updateData.InputUserName +"' AND phone LIKE '"+ data.updateData.InputUserPhone +"' AND email LIKE '"+ data.updateData.InputUserEmail +"'").next()).isTrue();
            MySqlConnection.closeConnection();
        }
    }

    @Test
    @Order(4)
    @DisplayName("kiểm tra api xóa tài khoản")
    public void apiDeleteInfo() throws SQLException {
        String message = RestAssured.given()
                .baseUri("http://127.0.0.1:8000/api")
                .basePath("/user/delete")
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .when().delete()
                .then().statusCode(200)
                .extract().jsonPath().getString("message");
        assertThat(message).isEqualTo("Xóa tài khoản thành công");
        if (message.equals("Xóa tài khoản thành công")){
            MySqlConnection.connection = MySqlConnection.getConnection(data.mySqlData.Url, data.mySqlData.Account, data.mySqlData.Password);
            MySqlConnection.statement = MySqlConnection.connection.createStatement();
            assertThat(MySqlConnection.getResultQuery("SELECT id FROM `users` WHERE account LIKE '"+ data.loginData.InputUserAccount +"'").next()).isFalse();
            MySqlConnection.closeConnection();
        }
    }
}
