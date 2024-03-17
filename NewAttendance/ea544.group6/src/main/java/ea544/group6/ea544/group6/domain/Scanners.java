package ea544.group6.ea544.group6.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Scanners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scanner_code")
    private String scannerCode;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
