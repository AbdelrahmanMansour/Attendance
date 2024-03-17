package com.system.Attendance.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Member implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String name;

	private String firstName;

	private String lastName;

	private String barCode;

	private Double balance;

	private String email;



	@ManyToMany
	@JoinTable(name = "event_member",
			joinColumns = {@JoinColumn(name = "member_id")},
			inverseJoinColumns = {@JoinColumn(name = "event_id")})
	private List<Event> eventList;


	@ManyToMany
	@JoinTable(name = "session_member",
			joinColumns = {@JoinColumn(name = "member_id")},
			inverseJoinColumns = {@JoinColumn(name = "session_id")})
	private List<Session> sessionList;

	@ManyToMany
	@JoinTable(name = "member_role",
			joinColumns = {@JoinColumn(name = "member_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private List<Role> roles;

}
