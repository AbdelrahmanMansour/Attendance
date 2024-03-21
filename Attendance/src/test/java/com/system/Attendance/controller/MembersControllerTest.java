package com.system.Attendance.controller;

import com.system.Attendance.domain.Event;
import com.system.Attendance.domain.Member;
import com.system.Attendance.enums.AccountType;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.service.EventService;
import com.system.Attendance.service.MemberService;
import com.system.Attendance.service.contract.MemberAttendenceOverAccount;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
class MembersControllerTest {

    private MockMvc mock;

    @Mock
    MemberService memberService;

    @InjectMocks
    private MembersController membersController;

    @MockBean
    MembersRepository membersRepository;

    @Mock
    private EventService eventService;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mock = MockMvcBuilders.standaloneSetup(membersController).build();
        membersController = new MembersController(memberService,eventService);
    }
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

    @Test
    void countAttendanceForEventByMember() throws Exception {
        // Setup
        Event event = new Event();
        event.setId(2L);
        Member member = new Member();
        member.setId(1L);

        int expectedAttendanceCount = 5;

        when(eventService.countAttendanceForEventByMember(1L, 2L))
                .thenReturn(expectedAttendanceCount);

        // Invocation
        mock.perform(MockMvcRequestBuilders.get("/members/1/events/2/attendance"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("5"));

    }
}