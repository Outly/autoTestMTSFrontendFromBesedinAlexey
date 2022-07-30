package api;

import api.models.getUser.User;

import static api.endpoints.UsersEndpoints.USER;
import static api.endpoints.UsersEndpoints.USERS;
import static api.models.SpecHelper.getRequestSpec;
import static api.models.SpecHelper.getResponseSpec;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;

public class UsersApi {
    public static User getUserSuccess(int userId) {
        return given()
                .spec(getRequestSpec())
                .when()
                .get(String.format(USER.getUrl(), userId))
                .then()
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(User.class);
    }

    public static void getUserFail(int userId) {
        given()
                .spec(getRequestSpec())
                .when()
                .get(String.format(USER.getUrl(), userId))
                .then()
                .spec(getResponseSpec(SC_NOT_FOUND));
    }

    public static void createUserFail(int name, int job) {
        given()
                .spec(getRequestSpec())
                .when()
                .body(String.format("{'name': '%s', 'job': '%s';}", name, job))
                .post(USERS.getUrl())
                .then()
                .spec(getResponseSpec(SC_BAD_REQUEST));
    }
}