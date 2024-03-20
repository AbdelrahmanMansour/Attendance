package com.system.Attendance.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
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
	@ManyToMany(fetch = FetchType.LAZY)
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

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
