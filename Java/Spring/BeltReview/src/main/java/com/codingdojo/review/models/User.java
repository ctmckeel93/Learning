package com.codingdojo.review.models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Size(min=2, max=255)
	private String firstName;
	@Size(min=2, max=255)
	private String lastName;
	
	
	@Email(message="Email must be valid")
	@Size(min=5, max=255, message="Email must have more than 5 characters")
	private String email;
	
	@Size(min=8, message="Password must contain more than 8 characters")
	private String password;
	
	@Transient
	private String confirm;
	
	private String city;
	
	@Size(max=2)
	private String state;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="commenter",fetch=FetchType.LAZY)
	private List<Message> messages;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Event> hostedEvents;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="users_events",
			joinColumns= @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="event_id")
	)
	private List<Event> events;
	
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	// Get relationship models
	
	 public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
	
	// handle creation and update info

	public List<Event> getHostedEvents() {
		return hostedEvents;
	}

	public void setHostedEvent(List<Event> hostedEvents) {
		this.hostedEvents = hostedEvents;
	}

	@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
