package ea544.group6.ea544.group6.service;

import ea544.group6.ea544.group6.domain.MemberDemo;
import ea544.group6.ea544.group6.service.contract.MemberDemoPayload;
import edu.miu.common.service.BaseReadWriteServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MemberDemoServiceImpl extends BaseReadWriteServiceImpl<MemberDemoPayload, MemberDemo, Integer> implements MemberDemoService {

}
