
package api.models.getUser;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @JsonProperty("data")
    private UserData data;
    @JsonProperty("support")
    private Support support;

    public UserData getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }

    public User() {
    }
}
