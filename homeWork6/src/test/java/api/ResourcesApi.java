package api;

import api.models.getResource.Resource;
import api.models.getResource.Resources;
import org.apache.http.HttpStatus;

import static api.endpoints.UsersEndpoints.RESOURCE;
import static api.endpoints.UsersEndpoints.RESOURCES;
import static api.models.SpecHelper.getRequestSpec;
import static api.models.SpecHelper.getResponseSpec;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class ResourcesApi {

    public static Resource getResourceSuccess(int resourceId) {
        return given()
                .spec(getRequestSpec())
                .when()
                .get(String.format(RESOURCE.getUrl(), resourceId))
                .then()
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(Resource.class);
    }

    public static void getResourceFail(int resourceId) {
        given()
                .spec(getRequestSpec())
                .when()
                .get(String.format(RESOURCE.getUrl(), resourceId))
                .then()
                .spec(getResponseSpec(HttpStatus.SC_NOT_FOUND));
    }

    public static Resources getResourcesSuccess(int page) {
        return given()
                .spec(getRequestSpec())
                .when()
                .get(String.format(RESOURCES.getUrl() + "?page=" + page))
                .then()
                .spec(getResponseSpec(SC_OK))
                .extract()
                .as(Resources.class);
    }
}
