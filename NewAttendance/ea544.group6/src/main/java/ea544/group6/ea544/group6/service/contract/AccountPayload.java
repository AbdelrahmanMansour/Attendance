package ea544.group6.ea544.group6.service.contract;

import ea544.group6.ea544.group6.domain.Account;
import ea544.group6.ea544.group6.domain.Role;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class AccountPayload implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Double defaultBalance;
    private Account.AccountType type = Account.AccountType.EATING;
    private List<Role> roles = new ArrayList<Role>();
}
