package com.system.Attendance.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
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
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "member_role",
			joinColumns = {@JoinColumn(name = "member_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private List<Role> roles = new ArrayList<Role>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "session_member",
			joinColumns = {@JoinColumn(name = "member_id")},
			inverseJoinColumns = {@JoinColumn(name = "session_id")})
	private List<Session> sessions = new ArrayList<>();
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

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void unsetRole(Integer roleId){
		roles.removeIf(role -> roleId.equals(role.getId()));
	}
}
