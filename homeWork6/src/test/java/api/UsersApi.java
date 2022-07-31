package api;

import api.models.createUser.CreateUserData;
import api.models.getUser.User;
import api.models.getUser.Users;
import api.models.updateUser.UpdateUserData;

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

    public static CreateUserData createUserSuccess(CreateUserData createUserData) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(createUserData)
                .post(USERS.getUrl())
                .then()
                .spec(getResponseSpec(SC_CREATED))
                .extract()
                .as(CreateUserData.class);
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

    public static void createUserFail() {
        given()
                .spec(getRequestSpec())
                .when()
                .post(USERS.getUrl())
                .then()
                .spec(getResponseSpec(SC_BAD_REQUEST));
    }

    public static Users getUsersSuccess(int page) {
        return given()
                .spec(getRequestSpec())
                .when()
                .get(USERS.getUrl() + "?page=" + page)
                .then()
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(Users.class);
    }

    public static UpdateUserData updateUserSuccess(UpdateUserData updateUserData, int userId) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(updateUserData)
                .put(String.format(USER.getUrl(), userId))
                .then()
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(UpdateUserData.class);
    }

    public static UpdateUserData patchUserSuccess(UpdateUserData updateUserData, int userId) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(updateUserData)
                .patch(String.format(USER.getUrl(), userId))
                .then()
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(UpdateUserData.class);
    }

}
