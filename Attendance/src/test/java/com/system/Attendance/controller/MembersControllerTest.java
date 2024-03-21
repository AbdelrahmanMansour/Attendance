package com.system.Attendance.controller;

import com.system.Attendance.enums.AccountType;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.service.MemberService;
import com.system.Attendance.service.contract.MemberAttendenceOverAccount;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class MembersControllerTest {
    @Autowired
    MockMvc mock;

    @MockBean
    MemberService memberService;

    @MockBean
    MembersRepository membersRepository;

    @Test
    void getEmptyMemberAttendanceAccountType() throws Exception {
        Mockito.when(memberService.getMemberAttendanceOverAccount(5)).thenReturn(new ArrayList<MemberAttendenceOverAccount>());
        mock.perform(MockMvcRequestBuilders.get("/members/5/attendance"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(Matchers.empty()));
    }

    @Test
    void getMemberAttendanceAccountType() throws Exception {
        List<MemberAttendenceOverAccount> result = new ArrayList<>();
        result.add(new MemberAttendenceOverAccount(AccountType.EATING, 10));
        result.add(new MemberAttendenceOverAccount(AccountType.ATTENDANCE, 10));
        Mockito.when(memberService.getMemberAttendanceOverAccount(10)).thenReturn(result);
        mock.perform(MockMvcRequestBuilders.get("/members/10/attendance"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].accountType").value("EATING"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].count").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].accountType").value("ATTENDANCE"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].count").value(10));
    }
}