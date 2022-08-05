package api.models.registerLogin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterLoginForm {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public RegisterLoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegisterLoginForm(String email) {
        this.email = email;
    }

    public RegisterLoginForm() {
    }
}
