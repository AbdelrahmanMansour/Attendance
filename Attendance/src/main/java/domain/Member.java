package domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "bar_code")
    private String barCode;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "email")
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
