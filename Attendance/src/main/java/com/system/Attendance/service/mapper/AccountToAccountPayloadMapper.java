package com.system.Attendance.service.mapper;


import com.system.Attendance.domain.Account;
import com.system.Attendance.service.contract.AccountPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountToAccountPayloadMapper extends BaseMapper<Account, AccountPayload> {

    public AccountToAccountPayloadMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Account.class, AccountPayload.class);
    }
}