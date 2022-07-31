package api.endpoints;

public enum UsersEndpoints {
    USER("/users/%s"),
    USERS("/users"),
    RESOURCE("/unknown/%s"),
    RESOURCES("/unknown"),
    REGISTER("/register"),
    LOGIN("/login");

    private String url;

    UsersEndpoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
