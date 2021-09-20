package com.tangazoletu.www.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(max = 100)
	@NotBlank
	private String name;
	@Size(max = 100)
	@NotBlank
	private String email;
	@Size(max = 100)
	@NotBlank
	private String date_of_birth;
	@Size(max = 100)
	@NotBlank
	private String location;
	@Size(max = 100)
	@NotBlank
	private String username;
	@Size(max = 100)
	@NotBlank
	private String timezone;

	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param date_of_birth
	 * @param location
	 * @param username
	 * @param timezone
	 */
	public Employee(Long id, @Size(max = 100) @NotBlank String name, @Size(max = 100) @NotBlank String email,
			@Size(max = 100) @NotBlank String date_of_birth, @Size(max = 100) @NotBlank String location,
			@Size(max = 100) @NotBlank String username, @Size(max = 100) @NotBlank String timezone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.date_of_birth = date_of_birth;
		this.location = location;
		this.username = username;
		this.timezone = timezone;
	}

	/**
	 *
	 */
	public Employee() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the date_of_birth
	 */
	public String getDate_of_birth() {
		return date_of_birth;
	}

	/**
	 * @param date_of_birth the date_of_birth to set
	 */
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", date_of_birth=" + date_of_birth + ", location="
				+ location + ", username=" + username + ", timezone=" + timezone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(date_of_birth, email, id, location, name, timezone, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(date_of_birth, other.date_of_birth) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(location, other.location)
				&& Objects.equals(name, other.name) && Objects.equals(timezone, other.timezone)
				&& Objects.equals(username, other.username);
	}

}
