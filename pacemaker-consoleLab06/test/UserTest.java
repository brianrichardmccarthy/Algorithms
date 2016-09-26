import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import controllers.PacemakerAPI;
import models.User;


public class UserTest {
	User homer = new User("Homer", "Simpson", "homer@simpson.com", "secret");
	PacemakerAPI pacemakerAPI;
	Collection<User> users;
	
	@Before
	public void setUp() {
		pacemakerAPI = new PacemakerAPI();

		pacemakerAPI.createUser("Bart", "Simpson", "bart@simpson.com", "secret");
		pacemakerAPI.createUser("Homer", "Simpson", "homer@simpson.com", "secret");
		pacemakerAPI.createUser("Lisa", "Simpson", " lisa@simpson.com", "secret");

		users = pacemakerAPI.getUsers();
	}
	
	@Test
	public void testCreate() {
		assertEquals("Homer", homer.firstName);
		assertEquals("Simpson", homer.lastName);
		assertEquals("homer@simpson.com", homer.email);
		assertEquals("secret", homer.password);
	}

	@Test
	public void testIds() {
		Set<Long> ids = new HashSet<>();
		for (User user : users) {
			ids.add(user.id);
		}
		assertEquals(users.size(), ids.size());
	}

	@Test
	public void testToString() {
		assertEquals("User{Homer, Simpson, secret, homer@simpson.com}", homer.toString());
	}
}