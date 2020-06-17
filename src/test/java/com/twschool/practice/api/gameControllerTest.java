package com.twschool.practice.api;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
public class gameControllerTest {
    @Autowired MockMvc mockMvc;
    @Test
    public void should_return_message_start_game_when_start_given_start() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/start")
                .contentType(MediaType.APPLICATION_JSON)
                .param("1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.input").value("start game"));
    }


    @Test
    public void should_return_guess_status1(){
        // MockMvc.perform();
    }



}
