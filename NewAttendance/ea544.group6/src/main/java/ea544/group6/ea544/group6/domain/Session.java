package ea544.group6.ea544.group6.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_name")
    private String name;

    @Column(name = "start_session_time")
    private LocalDateTime startTime;

    @Column(name = "end_session_time")
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "scanner_id")
    private Scanners scanner;

    @ManyToMany(mappedBy = "sessionList")
    private List<Member> memberList = new ArrayList<Member>();


}
