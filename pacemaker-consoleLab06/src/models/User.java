package models;

import static com.google.common.base.MoreObjects.toStringHelper;

import com.google.common.base.Objects;

public class User {

	private static Long counter = 0l;

	public Long id;
	public String firstName;
	public String lastName;
	public String email;
	public String password;

	public User() {
	}

	public User(String firstName, String lastName, String email, String password) {
		this.id = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.lastName, this.firstName, this.email, this.password);
	}

	/*
	 * public String toString() { return firstName + ' ' + lastName + ' ' +
	 * email + ' ' + password; }
	 */
	@Override
	public String toString() {
		return toStringHelper(this).addValue(firstName).addValue(lastName).addValue(password).addValue(email)
				.toString();
	}

}
