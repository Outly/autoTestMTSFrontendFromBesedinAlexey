package tests.api;

import api.RegisterLoginApi;
import api.models.registerLogin.IdTokenForm;
import api.models.registerLogin.RegisterLoginError;
import api.models.registerLogin.RegisterLoginForm;
import org.junit.Assert;
import org.junit.Test;

public class RegistrationTest {

    @Test
    public void checkingRegistrationSuccess() {
        String email = "eve.holt@reqres.in";
        String password = "pistol";

        RegisterLoginForm registerLoginForm = new RegisterLoginForm(email, password);

        IdTokenForm idTokenForm = RegisterLoginApi.registerSuccess(registerLoginForm);

        // Ассерты наверное лишние, так как при несоответствии типов не будет сгенерирован результат
        Assert.assertTrue(idTokenForm.getId() instanceof Integer);
        Assert.assertTrue(idTokenForm.getToken() instanceof String);
    }

    @Test
    public void checkingRegistrationFail() {
        String email = "eve.holt@reqres.in";
        RegisterLoginForm registerLoginForm = new RegisterLoginForm(email);

        RegisterLoginError registerLoginError = RegisterLoginApi.registerFail(registerLoginForm);

        Assert.assertEquals("Missing password", registerLoginError.getError());
    }
}
