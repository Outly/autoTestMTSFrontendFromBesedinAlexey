package tests.api;
import api.UsersApi;
import api.models.getUser.User;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DelayedResponseTest {
    @Test
    public void checkingGetUserWithDelay() {
        int delay = 5;
        Integer userId = 2;
        String email = "janet.weaver@reqres.in";
        String firstName = "Janet";
        String lastName = "Weaver";
        String avatar = "https://reqres.in/img/faces/2-image.jpg";
        long timerStart = System.currentTimeMillis(); // Засекаем время старта

        User user = UsersApi.getUserWithDelaySuccess(userId, delay);
        long timerFinish = System.currentTimeMillis(); // Засекаем время финиша
        long actualDelay = timerFinish - timerStart; // Рассчитываем время работы метода

        assertTrue(actualDelay <= delay * 1000); // Переводим секунды в миллисекунды
        assertEquals(user.getData().getAvatar(), avatar);
        assertEquals(user.getData().getEmail(), email);
        assertEquals(userId, user.getData().getId());
        assertEquals(user.getData().getFirstName(), firstName);
        assertEquals(user.getData().getLastName(), lastName);
    }
}
