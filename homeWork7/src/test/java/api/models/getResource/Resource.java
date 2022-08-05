package api.models.getResource;
import api.models.getUser.Support;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resource {

    @JsonProperty("data")
    private ResourceData data;
    @JsonProperty("support")
    private Support support;

    public ResourceData getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }

    public Resource() {
    }
}
