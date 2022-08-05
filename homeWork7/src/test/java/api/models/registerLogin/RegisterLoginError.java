package api.models.registerLogin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterLoginError {
    @JsonProperty("error")
    private String error;

    public String getError() {
        return error;
    }

    public RegisterLoginError() {
    }
}
