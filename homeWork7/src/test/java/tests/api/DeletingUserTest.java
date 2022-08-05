package tests.api;
import api.UsersApi;
import org.junit.Test;

public class DeletingUserTest {

    @Test
    public void checkingDeleteUser() {
        int userId = 2;
        UsersApi.deleteUserSuccess(userId);
    }
}
