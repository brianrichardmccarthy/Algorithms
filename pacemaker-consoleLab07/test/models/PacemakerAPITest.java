package models;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controllers.PacemakerAPI;

public class PacemakerAPITest {
	private PacemakerAPI pacemaker;

	@Before
	public void setup() {
		pacemaker = new PacemakerAPI();
		for (User user : Fixtures.users) {
			pacemaker.createUser(user.firstName, user.lastName, user.email, user.password);
		}
	}

	@After
	public void tearDown() {
		pacemaker = null;
	}

	@Test
	public void testUser() {
		assertEquals(Fixtures.users.length, pacemaker.getUsers().size());
		pacemaker.createUser("homer", "simpson", "homer@simpson.com", "secret");
		assertEquals(Fixtures.users.length + 1, pacemaker.getUsers().size());
		assertEquals(Fixtures.users[0], pacemaker.getUserByEmail(Fixtures.users[0].email));
	}

	@Test
	public void testUsers() {
		assertEquals(Fixtures.users.length, pacemaker.getUsers().size());
		for (User user : Fixtures.users) {
			User eachUser = pacemaker.getUserByEmail(user.email);
			assertEquals(user, eachUser);
			assertNotSame(user, eachUser);
		}
	}

	@Test
	public void testDeleteUsers() {
		assertEquals(Fixtures.users.length, pacemaker.getUsers().size());
		User marge = pacemaker.getUserByEmail("marge@simpson.com");
		pacemaker.deleteUser(marge.id);
		assertEquals(Fixtures.users.length - 1, pacemaker.getUsers().size());
	}
}