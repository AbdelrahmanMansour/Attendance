package ea544.group6.ea544.group6.service.mapper;

import ea544.group6.ea544.group6.domain.MemberDemo;
import ea544.group6.ea544.group6.service.contract.MemberDemoPayload;
import edu.miu.common.service.mapper.BaseMapper;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

@Component
public class MemberDemoToMemberDemoPayloadMapper extends BaseMapper<MemberDemo, MemberDemoPayload> {

    public MemberDemoToMemberDemoPayloadMapper(MapperFactory mapperFactory) {
        super(mapperFactory, MemberDemo.class, MemberDemoPayload.class);
    }

}
