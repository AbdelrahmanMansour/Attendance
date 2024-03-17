package ea544.group6.ea544.group6.controller;


import ea544.group6.ea544.group6.domain.MemberDemo;
import ea544.group6.ea544.group6.service.contract.MemberDemoPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/members")
public class MemberDemoController extends BaseReadWriteController<MemberDemoPayload, MemberDemo, Integer> {

}
