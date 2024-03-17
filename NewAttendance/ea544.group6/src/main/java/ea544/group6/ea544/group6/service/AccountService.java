package ea544.group6.ea544.group6.service;

import ea544.group6.ea544.group6.domain.Account;
import ea544.group6.ea544.group6.domain.MemberDemo;
import ea544.group6.ea544.group6.service.contract.AccountPayload;
import ea544.group6.ea544.group6.service.contract.MemberDemoPayload;
import edu.miu.common.service.BaseReadWriteService;

public interface AccountService extends BaseReadWriteService<AccountPayload, Account, Long> {

}
