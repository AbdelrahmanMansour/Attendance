package domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account {

    enum AccountType {
        EATING,
        ATTENDANCE,
        VIRTUAL_DOLLAR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "account_balance")
    private Double defaultBalance;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType type;

    @ManyToMany(mappedBy = "accounts")
    private List<Role> roles = new ArrayList<Role>();
}
