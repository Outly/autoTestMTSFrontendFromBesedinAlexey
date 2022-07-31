package api.models.updateUser;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateUserData {
    @JsonProperty("name")
    public String name;
    @JsonProperty("job")
    public String job;
    @JsonProperty("updatedAt")
    public String updatedAt;

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public UpdateUserData(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public UpdateUserData(String name) {
        this.name = name;
    }

    public UpdateUserData() {
    }
}
