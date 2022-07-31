package tests.api;

import api.RegisterLoginApi;
import api.models.registerLogin.IdTokenForm;
import api.models.registerLogin.RegisterLoginError;
import api.models.registerLogin.RegisterLoginForm;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    @Test
    public void checkingLoginSuccess() {
        String email = "eve.holt@reqres.in";
        String password = "pistol";
        RegisterLoginForm registerLoginForm = new RegisterLoginForm(email, password);

        IdTokenForm idTokenForm = RegisterLoginApi.loginSuccess(registerLoginForm);

        // Ассерт наверное лишний, так как при несоответствии типов не будет сгенерирован результат
        assertTrue(idTokenForm.getToken() instanceof String);
    }

    @Test
    public void checkingLoginFail() {
        String email = "eve.holt@reqres.in";
        RegisterLoginForm registerLoginForm = new RegisterLoginForm(email);

        RegisterLoginError registerLoginError = RegisterLoginApi.loginFail(registerLoginForm);

        Assert.assertEquals("Missing password", registerLoginError.getError());
    }
}
