
package api.models.getUser;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Support {

    @JsonProperty("url")
    public String url;
    @JsonProperty("text")
    public String text;

    public String getUrl() {
        return url;
    }

    public String getText() {
        return text;
    }

    public Support() {
    }
}
