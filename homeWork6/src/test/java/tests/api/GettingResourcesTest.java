package tests.api;

import api.ResourcesApi;
import api.models.getResource.Resources;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GettingResourcesTest {

    @Test
    public void checkingGetResources() {
        int page = 1;
        int resourceId = 2;
        String name = "fuchsia rose";
        int year = 2001;
        String color = "#C74375";
        String pantoneValue = "17-2031";

        Resources resources = ResourcesApi.getResourcesSuccess(page);

        int elementIndex = resourceId % resources.getPerPage() - 1;

        assertEquals(page, resources.getPage());
        assertEquals(resourceId, resources.getData().get(elementIndex).getId());
        assertEquals(name, resources.getData().get(elementIndex).getName());
        assertEquals(year, resources.getData().get(elementIndex).getYear());
        assertEquals(color, resources.getData().get(elementIndex).getColor());
        assertEquals(pantoneValue, resources.getData().get(elementIndex).getPantoneValue());
    }
}
