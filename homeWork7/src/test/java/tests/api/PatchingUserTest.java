package tests.api;

import api.UsersApi;
import api.models.updateUser.UpdateUserData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PatchingUserTest {

    @Test
    public void checkingPatchingUser() {
        String name = "Boris";
        String job = "QA engineer";
        int userId = 2;

        UpdateUserData patchUserData = new UpdateUserData(name, job);
        UpdateUserData actualPatchUserData = UsersApi.patchUserSuccess(patchUserData, userId);

        assertEquals(name, actualPatchUserData.getName());
        assertEquals(job, actualPatchUserData.getJob());
    }
}
