package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Member implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String firstName;

	private String lastName;

	private String barCode;

	private Double balance;

	private String email;



	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "event_member",
			joinColumns = {@JoinColumn(name = "member_id")},
			inverseJoinColumns = {@JoinColumn(name = "event_id")})
	private List<Event> eventList = new ArrayList<Event>();


	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "session_member",
			joinColumns = {@JoinColumn(name = "member_id")},
			inverseJoinColumns = {@JoinColumn(name = "session_id")})
	private List<Session> sessionList = new ArrayList<Session>();

	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "member_role",
			joinColumns = {@JoinColumn(name = "member_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private List<Role> roles = new ArrayList<Role>();

	public Member() {
	}

	public Member(String name, String firstName, String lastName, String barCode, Double balance, String email) {
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.barCode = barCode;
		this.balance = balance;
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}

	public void setSessionList(List<Session> sessionList) {
		this.sessionList = sessionList;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void addSession(Session session) {
		this.sessionList.add(session);
	}

	public void addEvent(Event event) {
		this.eventList.add(event);
	}
}
