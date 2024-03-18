package com.system.Attendance.controller;

import com.system.Attendance.domain.Member;
import com.system.Attendance.service.contract.MembersPayload;
import edu.miu.common.controller.BaseReadWriteController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MembersController extends BaseReadWriteController<MembersPayload, Member, Integer> {

}
