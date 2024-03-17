package ea544.group6.ea544.group6.controller;

import ea544.group6.ea544.group6.domain.Account;
import ea544.group6.ea544.group6.domain.MemberDemo;
import ea544.group6.ea544.group6.service.contract.AccountPayload;
import ea544.group6.ea544.group6.service.contract.MemberDemoPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController extends BaseReadWriteController<AccountPayload, Account, Long> {

}
