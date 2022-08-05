package api.models.registerLogin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IdTokenForm {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("token")
    private String token;

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public IdTokenForm() {
    }

    public IdTokenForm(Integer id, String token) {
        this.id = id;
        this.token = token;
    }
}
