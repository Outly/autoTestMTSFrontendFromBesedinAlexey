package api.models.getUser;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("data")
    private List<UserData> data = null;
    @JsonProperty("support")
    private Support support;

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public List<UserData> getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }

    public Users() {
    }

    public Users(Integer page, Integer perPage, Integer total, Integer totalPages, List<UserData> data, Support support) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
        this.support = support;
    }
}