package com.system.Attendance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.Attendance.domain.Session;
import com.system.Attendance.service.EventServiceImpl;
import com.system.Attendance.service.SessionServiceImpl;
import com.system.Attendance.service.contract.SessionPayload;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)

class EventControllerTest {

    @Autowired
    MockMvc mock;

    @MockBean
    SessionServiceImpl sessionService;


    @Test
    void addSessionTest() throws Exception {
//        Long eventId = 1L;
//        List<SessionPayload> sessionlist = new ArrayList<>();
//        SessionPayload session= new   Session(, "2024-03-20T04:11:29.212530200");
//        session.setStartTime("2024-03-20");
//        session.setEndTime("2024-03-29");
//        sessionlist.add(session);
//        mock.perform(MockMvcRequestBuilders.post("events/{eventId}/sessions", eventId))
//                .contentType(MediaType.APPLICATION_JSON))
//                        .content(asJsonString(session))
//
//                .andExpect(status().isOk());
//        verify(sessionService, times(1)).addSession(eventId, sessionlist);

    }

    @Test
    void getSessionTest() throws Exception {
        Long eventId = 1L;
        Mockito.when(sessionService.getSession(1)).thenReturn(new Session("2024-03-20T04:11:29.212530200", "2024-03-20T04:11:29.212530200"));
        mock.perform(get("events/{eventId}/sessions", eventId))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.startTime").value("2024-03-20"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endTime").value("2024-03-20"));
    }

    @Test
    void deleteSessionTest() throws Exception {
        mock.perform(MockMvcRequestBuilders.delete("/{eventId}/sessions/{sessionId}",1, 1))
                .andExpect(status().isOk());
        verify(sessionService, times(1)).deleteSession(1L,1L);
    }

    @Test
    void updateSessionTest() {
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}