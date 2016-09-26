package controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Optional;

import models.Activity;
import models.Location;
import models.User;

public class PacemakerAPI {
	// private List<User> users = new ArrayList<User>();
	private Map<Long, User> userIndex = new HashMap<>();
	private Map<String, User> emailIndex = new HashMap<>();
	private Map<Long, Activity> activitiesIndex = new HashMap<>();

	public Collection<User> getUsers() {
		return userIndex.values();
	}

	public User createUser(String firstName, String lastName, String email, String password) {
		User user = new User(firstName, lastName, email, password);
		userIndex.put(user.id, user);
		emailIndex.put(email, user);
		return user;
	}

	public User getUserByEmail(String email) {
		return emailIndex.get(email);
	}

	public User getUser(long id) {
		return userIndex.get(id);
	}

	public void deleteUsers() {
		userIndex.clear();
		emailIndex.clear();
	}

	public void deleteUser(long id) {
		User user = userIndex.remove(id);
		emailIndex.remove(user.email);
	}

	public Activity createActivity(Long id, String type, String location, double distance) {
		Activity activity = null;
		Optional<User> user = Optional.fromNullable(userIndex.get(id));
		if (user.isPresent()) {
			activity = new Activity(type, location, distance);
			user.get().activities.put(activity.id, activity);
			activitiesIndex.put(activity.id, activity);
		}
		return activity;
	}

	public Activity getActivity(Long id) {
		return activitiesIndex.get(id);
	}

	public void addLocation(Long id, float latitude, float longitude) {
		Optional<Activity> activity = Optional.fromNullable(activitiesIndex.get(id));
		if (activity.isPresent()) {
			activity.get().route.add(new Location(latitude, longitude));
		}
	}

	/*
	 * public List<User> getUsers() { return users; }
	 * 
	 * public void deleteUsers() { users.clear(); }
	 * 
	 * public User createUser(String firstName, String lastName, String email,
	 * String password) { User user = new User(firstName, lastName, email,
	 * password); users.add(user); return user; }
	 * 
	 * public User getUser(String email) { for (User user : users) { if
	 * (email.equals(user.email)) return user; } return null; }
	 * 
	 * public void deleteUser(String email) { User foundUser = null; for (User
	 * user : users) { if (email.equals(user.email)) foundUser = user; } if
	 * (foundUser != null) { users.remove(foundUser); } }
	 */
}