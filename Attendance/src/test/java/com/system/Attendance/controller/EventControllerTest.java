package com.system.Attendance.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.Attendance.domain.Session;
import com.system.Attendance.repository.EventRepository;
import com.system.Attendance.service.EventService;
import com.system.Attendance.service.SessionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)
@AutoConfigureMockMvc(addFilters = false)
//@SpringBootTest(classes = Appendable.class)
public class EventControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    EventService eventService;

    @Autowired
    SessionServiceImpl sessionService;

    @Test
    public void getSessionsForEventTest() throws Exception {

       Session session = new Session("2024-03-20T04:11:29.212530200", "2024-03-20T04:11:29.212530200");

        Mockito.when(sessionService.getSession(1)).thenReturn(session);

        mockMvc.perform(MockMvcRequestBuilders.get("/events/{eventId}/sessions/{sessionId}", 1L, 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Session 1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Monday"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDateTime").value("2024-04-01T05:00:00.000+00:00"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDateTime").value("2024-04-03T05:00:00.000+00:00"));
    }

//    @Test
//    public void getAllSessionsForEventTest() throws Exception {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date start = dateFormat.parse("2024-04-01");
//        Date end = dateFormat.parse("2024-04-03");
//
//        SessionPayload sessionPayload = SessionPayload.builder()
//                .id(1L)
//                .name("Session 1")
//                .description("Monday")
//                .startDateTime(start)
//                .endDateTime(end)
//                .build();
//        List<SessionPayload> sessionPayloadList = new ArrayList<>();
//        sessionPayloadList.add(sessionPayload);
//
//        Mockito.when(eventService.getAllSessionsForEvent(1L)).thenReturn(sessionPayloadList);
//
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/events/1/sessions")
//            .contentType(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk())
//            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
//            .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
//            .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Session 1"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value("Monday"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].startDateTime").value("2024-04-01T05:00:00.000+00:00"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].endDateTime").value("2024-04-03T05:00:00.000+00:00"));
//    }
//
//
//    @Test
//    public void saveSessionForEventTest() throws Exception {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date start = dateFormat.parse("2024-04-01");
//        Date end = dateFormat.parse("2024-04-03");
//
//        SessionPayload sessionPayload = SessionPayload.builder()
//                .id(1L)
//                .name("Session 1")
//                .description("Monday")
//                .startDateTime(start)
//                .endDateTime(end)
//                .build();
//
//        Mockito.when(eventService.saveSessionForEvent(1L, sessionPayload)).thenReturn(sessionPayload);
//        mockMvc.perform(MockMvcRequestBuilders.post("/events/{eventId}/sessions", 1L)
//                        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(sessionPayload)))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Session 1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Monday"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.startDateTime").value("2024-04-01T05:00:00.000+00:00"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.endDateTime").value("2024-04-03T05:00:00.000+00:00"));
//
//    }
//
//    @Test
//    public void updateSessionInEventTest() throws Exception {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date start = dateFormat.parse("2024-04-01");
//        Date end = dateFormat.parse("2024-04-03");
//
//        SessionPayload sessionPayload = SessionPayload.builder()
//                .id(1L)
//                .name("Session 1")
//                .description("Monday")
//                .startDateTime(start)
//                .endDateTime(end)
//                .build();
//
//        Mockito.when(eventService.updateSessionInEvent(1L,1L, sessionPayload)).thenReturn(sessionPayload);
//        mockMvc.perform(MockMvcRequestBuilders.put("/events/{eventId}/sessions/{sessionId}", 1L, 1L)
//                        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(sessionPayload)))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Session 1"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Monday"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.startDateTime").value("2024-04-01T05:00:00.000+00:00"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.endDateTime").value("2024-04-03T05:00:00.000+00:00"));
//
//
//    }
//
//    @Test
//    public void deleteSessionFromEventTest() throws Exception {
//        String expected = "Session deleted or it was already not exist for this event";
//        Mockito.when(eventService.deleteSessionFromEvent(1L,1L)).thenReturn(expected);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/events/{eventId}/sessions/{sessionId}", 1L, 1L)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$").value(expected));
//
//    }

    public static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
