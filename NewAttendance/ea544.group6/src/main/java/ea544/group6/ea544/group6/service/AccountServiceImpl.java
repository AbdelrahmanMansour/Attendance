package ea544.group6.ea544.group6.service;

import ea544.group6.ea544.group6.domain.Account;
import ea544.group6.ea544.group6.service.contract.AccountPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseReadWriteServiceImpl<AccountPayload, Account, Long> implements AccountService {

}
