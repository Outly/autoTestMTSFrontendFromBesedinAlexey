package tests.api;

import api.UsersApi;
import api.models.getUser.Users;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GettingUsersTest {

    @Test
    public void checkingGetUsers() {
        int page = 2;
        Integer userId = 7;
        String email = "michael.lawson@reqres.in";
        String firstName = "Michael";
        String lastName = "Lawson";
        String avatar = "https://reqres.in/img/faces/7-image.jpg";

        Users users = UsersApi.getUsersSuccess(page);

        int elementIndex = userId % users.getPerPage() - 1;

        assertEquals(page, users.getPage());
        assertEquals(userId, users.getData().get(elementIndex).getId());
        assertEquals(email, users.getData().get(elementIndex).getEmail());
        assertEquals(firstName, users.getData().get(elementIndex).getFirstName());
        assertEquals(lastName, users.getData().get(elementIndex).getLastName());
        assertEquals(avatar, users.getData().get(elementIndex).getAvatar());
    }
}
