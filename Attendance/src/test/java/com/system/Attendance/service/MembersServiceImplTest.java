package com.system.Attendance.service;

import com.system.Attendance.enums.AccountType;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.service.contract.MemberAttendenceOverAccount;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
class MembersServiceImplTest {

    @TestConfiguration
    static class MemberServiceConfiguration {
        @Bean
        public MemberService memberService() {
            return new MembersServiceImpl();
        }
    }
    @Autowired
    private MemberService memberService;

    @MockBean
    private MembersRepository membersRepository;
    @Before
    public void setUp() {
        List<Object[]> emptyList = new ArrayList<>();
        List<Object[]> list2 = new ArrayList<>();
        list2.add(new Object[]{AccountType.EATING, 10});
        list2.add(new Object[]{AccountType.ATTENDANCE, 10});
        Mockito.when(membersRepository.getMemberAttendanceOverAccount(5)).thenReturn(emptyList);
        Mockito.when(membersRepository.getMemberAttendanceOverAccount(10)).thenReturn(list2);
    }
    @Test
    void getEmptyMemberAttendanceOverAccount() {
        List<MemberAttendenceOverAccount> expected = new ArrayList<>();
        List<MemberAttendenceOverAccount> result = memberService.getMemberAttendanceOverAccount(5);
        assertThat(result).isEqualTo(expected);
    }
}