package tests.api;
import api.UsersApi;
import api.models.updateUser.UpdateUserData;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UpdatingUserTest {

    @Test
    public void checkingUpdatingUser() {
        String name = "Artem";
        String job = "QA engineer";
        int userId = 2;

        UpdateUserData updateUserData = new UpdateUserData(name, job);
        UpdateUserData actualUpdateUserData = UsersApi.updateUserSuccess(updateUserData, userId);

        assertEquals(name, actualUpdateUserData.getName());
        assertEquals(job, actualUpdateUserData.getJob());

    }
}
