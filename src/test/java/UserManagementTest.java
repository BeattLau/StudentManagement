import org.example.User;
import org.example.UserManagement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagementTest {
    private ArrayList<User> userList;
    private UserManagement userManagement;

    @BeforeEach
    void setUp() {
        userList = new ArrayList<>();
        userManagement = new UserManagement(userList);
    }

    @Test
    void testAddUser() {
        User user = new User("testUser", "password");
        userManagement.addUser(user);
        assertTrue(userList.contains(user));
    }

    @Test
    void testUpdateUser() {
        User user = new User("testUser", "password");
        userManagement.addUser(user);

        userManagement.updateUser("testUser", "newPassword");
        User updatedUser = userManagement.searchForUser("testUser");

        assertNotNull(updatedUser, "User should be found");
        assertEquals("newPassword", updatedUser.getPassword(), "Password should be updated");
    }
    @Test
    void testRemoveUser() {
        User user = new User("testUser", "password");
        userManagement.addUser(user);
        userManagement.removeUser(user);
        assertFalse(userList.contains(user));
    }

    @Test
    void testSearchForUser() {
        User user = new User("testUser", "password");
        userManagement.addUser(user);
        User foundUser = userManagement.searchForUser("testUser");
        assertNotNull(foundUser, "User should be found");
        assertEquals("testUser", foundUser.getUsername(), "Found user's username should match");
    }

    @Test
    void testDisplayUsers() {
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        userManagement.addUser(user1);
        userManagement.addUser(user2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        userManagement.displayUsers();
        String expectedOutput = "All users: \nUsername: user1, Password: password1\nUsername: user2, Password: password2\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
