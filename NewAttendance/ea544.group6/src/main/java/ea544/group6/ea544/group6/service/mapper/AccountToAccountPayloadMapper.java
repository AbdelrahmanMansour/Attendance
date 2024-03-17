package ea544.group6.ea544.group6.service.mapper;

import ea544.group6.ea544.group6.domain.Account;
import ea544.group6.ea544.group6.domain.MemberDemo;
import ea544.group6.ea544.group6.service.contract.AccountPayload;
import ea544.group6.ea544.group6.service.contract.MemberDemoPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountToAccountPayloadMapper extends BaseMapper<Account, AccountPayload> {

    public AccountToAccountPayloadMapper(MapperFactory mapperFactory) {
        super(mapperFactory, Account.class, AccountPayload.class);
    }
}