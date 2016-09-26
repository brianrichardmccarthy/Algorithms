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

	@Test
	public void testAddActivity() {
		User marge = pacemaker.getUserByEmail("marge@simpson.com");
		Activity activity = pacemaker.createActivity(marge.id, Fixtures.activities[0].type,
				Fixtures.activities[0].location, Fixtures.activities[0].distance);
		Activity returnedActivity = pacemaker.getActivity(activity.id);
		assertEquals(Fixtures.activities[0], returnedActivity);
		assertNotSame(Fixtures.activities[0], returnedActivity);
	}

	@Test
	public void testAddActivityWithSingleLocation() {
		User marge = pacemaker.getUserByEmail("marge@simpson.com");
		Long activityId = pacemaker.createActivity(marge.id, Fixtures.activities[0].type, Fixtures.activities[0].location,
				Fixtures.activities[0].distance).id;

		pacemaker.addLocation(activityId, Fixtures.locations[0].latitude, Fixtures.locations[0].longitude);

		Activity activity = pacemaker.getActivity(activityId);
		assertEquals(1, activity.route.size());
		assertEquals(0.0001, Fixtures.locations[0].latitude, activity.route.get(0).latitude);
		assertEquals(0.0001, Fixtures.locations[0].longitude, activity.route.get(0).longitude);
	}

	@Test
	public void testAddActivityWithMultipleLocation() {
		User marge = pacemaker.getUserByEmail("marge@simpson.com");
		Long activityId = pacemaker.createActivity(marge.id, Fixtures.activities[0].type, Fixtures.activities[0].location,
				Fixtures.activities[0].distance).id;

		for (Location location : Fixtures.locations) {
			pacemaker.addLocation(activityId, location.latitude, location.longitude);
		}

		Activity activity = pacemaker.getActivity(activityId);
		assertEquals(Fixtures.locations.length, activity.route.size());
		int i = 0;
		for (Location location : activity.route) {
			assertEquals(location, Fixtures.locations[i]);
			i++;
		}
	}
}