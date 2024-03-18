package com.system.Attendance.service.mapper;


import com.system.Attendance.domain.Account;
import com.system.Attendance.service.contract.AccountPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountPayloadToAccountMapper extends BaseMapper<AccountPayload, Account> {

    public AccountPayloadToAccountMapper(MapperFactory mapperFactory) {
        super(mapperFactory, AccountPayload.class, Account.class);
    }
}
