package tests.api;

import api.ResourcesApi;
import api.models.getResource.Resource;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GettingResourceTest {

    @Test
    public void checkingGetResource() {
        int id = 2;
        String name = "fuchsia rose";
        int year = 2001;
        String color = "#C74375";
        String pantoneValue = "17-2031";

        Resource resource = ResourcesApi.getResourceSuccess(id);

        assertEquals(id, resource.getData().getId());
        assertEquals(name, resource.getData().getName());
        assertEquals(year, resource.getData().getYear());
        assertEquals(color, resource.getData().getColor());
        assertEquals(pantoneValue, resource.getData().getPantoneValue());
    }

    @Test
    public void checkingGetResourceFail() {
        int id = 23;
        ResourcesApi.getResourceFail(id);
    }
}
