package ea544.group6.ea544.group6.service.mapper;

import ea544.group6.ea544.group6.domain.Account;
import ea544.group6.ea544.group6.service.contract.AccountPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountPayloadToAccountMapper extends BaseMapper<AccountPayload, Account> {

    public AccountPayloadToAccountMapper(MapperFactory mapperFactory) {
        super(mapperFactory, AccountPayload.class, Account.class);
    }
}
