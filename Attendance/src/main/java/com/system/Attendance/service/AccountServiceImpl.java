package com.system.Attendance.service;

import com.system.Attendance.domain.Account;
import com.system.Attendance.service.contract.AccountPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseReadWriteServiceImpl<AccountPayload, Account, Long> implements AccountService {

}
