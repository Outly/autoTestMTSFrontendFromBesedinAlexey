package api;

import api.models.registerLogin.IdTokenForm;
import api.models.registerLogin.RegisterLoginError;
import api.models.registerLogin.RegisterLoginForm;

import static api.endpoints.UsersEndpoints.LOGIN;
import static api.endpoints.UsersEndpoints.REGISTER;
import static api.models.SpecHelper.getRequestSpec;
import static api.models.SpecHelper.getResponseSpec;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;

public class RegisterLoginApi {

    public static IdTokenForm registerSuccess(RegisterLoginForm registerLoginForm) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(registerLoginForm)
                .post(REGISTER.getUrl())
                .then()
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(IdTokenForm.class);
    }

    public static RegisterLoginError registerFail(RegisterLoginForm registerLoginForm) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(registerLoginForm)
                .post(REGISTER.getUrl())
                .then()
                .spec(getResponseSpec(SC_BAD_REQUEST))
                .extract()
                .as(RegisterLoginError.class);
    }

    public static IdTokenForm loginSuccess(RegisterLoginForm registerLoginForm) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(registerLoginForm)
                .post(LOGIN.getUrl())
                .then()
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(IdTokenForm.class);
    }

    public static RegisterLoginError loginFail(RegisterLoginForm registerLoginForm) {
        return given()
                .spec(getRequestSpec())
                .when()
                .body(registerLoginForm)
                .post(LOGIN.getUrl())
                .then()
                .spec(getResponseSpec(SC_BAD_REQUEST))
                .extract()
                .as(RegisterLoginError.class);
    }
}
